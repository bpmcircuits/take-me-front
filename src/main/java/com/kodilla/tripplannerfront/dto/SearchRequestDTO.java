package com.kodilla.tripplannerfront.dto;

public record SearchRequestDTO(String departureCity,
                               String arrivalCity,
                               String departureDate,
                               String returnDate,
                               int adults,
                               int children,
                               int infants,
                               String currencyCode) {
}
