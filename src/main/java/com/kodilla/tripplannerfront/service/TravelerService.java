package com.kodilla.tripplannerfront.service;

import com.kodilla.tripplannerfront.dto.TravelerDTO;
import com.kodilla.tripplannerfront.tripplanerback.client.BackendClient;
import com.kodilla.tripplannerfront.tripplanerback.dto.travelers.TravelerRequestDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.travelers.TravelerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerService {

    private final BackendClient backendClient;

    public List<TravelerResponseDTO> getTravelers() {
        return backendClient.getTravelers();
    }

    public TravelerResponseDTO addTraveler(TravelerRequestDTO travelerRequestDTO) {
        return backendClient.addTraveler(travelerRequestDTO);
    }

    public void deleteTraveler(Long travelerId) {
        backendClient.deleteTraveler(travelerId);
    }
}
