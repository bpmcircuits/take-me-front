package com.kodilla.tripplannerfront.mapper;

import com.kodilla.tripplannerfront.dto.FlightOfferDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.flights.FlightBoundDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.flights.FlightSearchResponseDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.flights.FlightSegmentDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightMapper {

    public List<FlightOfferDTO> mapFromResponseToFlightOfferDTOs(List<FlightSearchResponseDTO> flightSearchResponseDTOs) {
        List<FlightOfferDTO> result = new ArrayList<>();
        
        for (FlightSearchResponseDTO response : flightSearchResponseDTOs) {
            if (response.outbound() != null && !response.outbound().segments().isEmpty()) {
                result.addAll(createFlightOfferDTOs(response.outbound(), response.totalPrice().currency(), response.totalPrice().total()));
            }

            if (!response.oneWay() && response.inbound() != null && !response.inbound().segments().isEmpty()) {
                result.addAll(createFlightOfferDTOs(response.inbound(), response.totalPrice().currency(), response.totalPrice().total()));
            }
        }
        
        return result;
    }
    
    private List<FlightOfferDTO> createFlightOfferDTOs(FlightBoundDTO bound, String currency, String totalPrice) {
        List<FlightOfferDTO> offers = new ArrayList<>();
        
        for (FlightSegmentDTO segment : bound.segments()) {
            String airline = segment.carrierCode();
            LocalDateTime departureTime = parseDateTime(segment.departureAt());
            String from = segment.fromIata();
            LocalDateTime arrivalTime = parseDateTime(segment.arrivalAt());
            String to = segment.toIata();
            String cost = currency + " " + totalPrice;
            
            FlightOfferDTO offer = new FlightOfferDTO(
                    airline,
                    departureTime,
                    from,
                    arrivalTime,
                    to,
                    cost
            );
            
            offers.add(offer);
        }
        
        return offers;
    }
    
    private LocalDateTime parseDateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
}
