package com.kodilla.tripplannerfront.tripplanerback.dto.hotels;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookingHotelsResponseDTO(String name,
                                       String countryCode,
                                       String city,
                                       BigDecimal price,
                                       String currency,
                                       LocalDate checkInDate,
                                       LocalDate checkOutDate,
                                       double reviewScore,
                                       String reviewScoreWord,
                                       int reviewCount) {
}
