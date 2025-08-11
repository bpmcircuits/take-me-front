package com.kodilla.tripplannerfront.mapper;

import com.kodilla.tripplannerfront.dto.HotelOfferDTO;
import com.kodilla.tripplannerfront.dto.HotelSearchRequestDTO;
import com.kodilla.tripplannerfront.dto.SearchRequestDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.hotels.BookingHotelsResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelMapper {

    public HotelSearchRequestDTO mapToHotelSearchDTO(SearchRequestDTO searchRequestDTO) {
        return new HotelSearchRequestDTO(
                searchRequestDTO.arrivalCity(),
                searchRequestDTO.departureDate(),
                searchRequestDTO.returnDate(),
                searchRequestDTO.adults() + searchRequestDTO.children() + searchRequestDTO.infants()
        );
    }

    public List<HotelOfferDTO> mapToHotelOfferDTOList(List<BookingHotelsResponseDTO> bookingHotelsResponseDTOList) {
        return bookingHotelsResponseDTOList.stream()
                .map(this::mapFromSearchResponse)
                .toList();
    }

    public HotelOfferDTO mapFromSearchResponse(BookingHotelsResponseDTO bookingHotelsResponseDTO) {
        return new HotelOfferDTO(
                bookingHotelsResponseDTO.name(),
                bookingHotelsResponseDTO.city(),
                bookingHotelsResponseDTO.checkInDate(),
                bookingHotelsResponseDTO.checkOutDate(),
                bookingHotelsResponseDTO.price(),
                bookingHotelsResponseDTO.reviewScore(),
                bookingHotelsResponseDTO.reviewScoreWord()
        );

    }
}
