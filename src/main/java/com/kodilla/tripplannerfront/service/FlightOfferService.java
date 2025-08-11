package com.kodilla.tripplannerfront.service;

import com.kodilla.tripplannerfront.dto.SearchRequestDTO;
import com.kodilla.tripplannerfront.tripplanerback.client.BackendClient;
import com.kodilla.tripplannerfront.tripplanerback.dto.flights.FlightSearchResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightOfferService {

    private final BackendClient backendClient;

    public List<FlightSearchResponseDTO> getFlightOffers(SearchRequestDTO searchRequestDTO) {
        return backendClient.getFlightOffers(searchRequestDTO);
    }
}