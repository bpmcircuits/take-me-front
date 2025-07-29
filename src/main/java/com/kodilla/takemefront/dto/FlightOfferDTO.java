package com.kodilla.takemefront.dto;

import java.util.Objects;

public record FlightOfferDTO(String airline,
                             String departureTime,
                             String from,
                             String arrivalTime,
                             String to,
                             String cost) {
}