package com.kodilla.tripplannerfront.tripplanerback.client;

import com.kodilla.tripplannerfront.dto.HotelSearchRequestDTO;
import com.kodilla.tripplannerfront.dto.SearchRequestDTO;
import com.kodilla.tripplannerfront.mapper.HotelMapper;
import com.kodilla.tripplannerfront.tripplanerback.config.BackendConfig;
import com.kodilla.tripplannerfront.tripplanerback.dto.flights.FlightSearchResponseDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.hotels.BookingHotelsResponseDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.travelers.TravelerRequestDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.travelers.TravelerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BackendClient {

    private final BackendConfig config;
    private final RestTemplate restTemplate;

    private final HotelMapper hotelMapper;

    public List<FlightSearchResponseDTO> getFlightOffers(SearchRequestDTO searchRequestDTO) {
        URI uri = UriComponentsBuilder.fromUriString(config.getBackendApiEndpoint() + "/flights/flight-offer")
                .build().encode().toUri();

        try {
            FlightSearchResponseDTO[] responses =
                    restTemplate.postForObject(uri, searchRequestDTO, FlightSearchResponseDTO[].class);
            return Optional.ofNullable(responses).map(Arrays::asList).orElse(Collections.emptyList());
        } catch (RestClientException e) {
            return Collections.emptyList();
        }
    }

    public List<BookingHotelsResponseDTO> getHotelOffers(HotelSearchRequestDTO hotelSearchRequestDTO) {
        URI uri = UriComponentsBuilder.fromUriString(config.getBackendApiEndpoint() + "/hotels/hotel-offer")
                .build().encode().toUri();

        try {
            BookingHotelsResponseDTO[] responses =
                    restTemplate.postForObject(uri, hotelSearchRequestDTO, BookingHotelsResponseDTO[].class);
            return Optional.ofNullable(responses).map(Arrays::asList).orElse(Collections.emptyList());
        } catch (RestClientException e) {
            return Collections.emptyList();
        }
    }

    public List<TravelerResponseDTO> getTravelers() {
        URI uri = UriComponentsBuilder.fromUriString(config.getBackendApiEndpoint() + "/trips/travelers")
                .build().encode().toUri();

        try {
            TravelerResponseDTO[] responses =
                    restTemplate.getForObject(uri, TravelerResponseDTO[].class);
            return Optional.ofNullable(responses).map(Arrays::asList).orElse(Collections.emptyList());
        } catch (RestClientException e) {
            return Collections.emptyList();
        }
    }

    public TravelerResponseDTO addTraveler(TravelerRequestDTO travelerRequestDTO) {
        URI uri = UriComponentsBuilder.fromUriString(config.getBackendApiEndpoint() + "/trips/travelers/add")
                .build().encode().toUri();

        try {
            return restTemplate.postForObject(uri, travelerRequestDTO, TravelerResponseDTO.class);
        } catch (RestClientException e) {
            return null;
        }
    }

    public void deleteTraveler(Long travelerId) {
        URI uri = UriComponentsBuilder.fromUriString(config.getBackendApiEndpoint() + "/trips/travelers/" + travelerId)
                .build().encode().toUri();

        try {
            restTemplate.delete(uri);
        } catch (RestClientException e) {
            System.out.println("Deleting error!");
        }
    }

}
