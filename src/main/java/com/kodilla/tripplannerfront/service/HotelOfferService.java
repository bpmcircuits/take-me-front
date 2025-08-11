package com.kodilla.tripplannerfront.service;

import com.kodilla.tripplannerfront.dto.HotelSearchRequestDTO;
import com.kodilla.tripplannerfront.tripplanerback.client.BackendClient;
import com.kodilla.tripplannerfront.tripplanerback.dto.hotels.BookingHotelsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelOfferService {

    private final BackendClient backendClient;

    public List<BookingHotelsResponseDTO> getHotelOffers(HotelSearchRequestDTO hotelSearchRequestDTO) {
        return backendClient.getHotelOffers(hotelSearchRequestDTO);
    }
}
