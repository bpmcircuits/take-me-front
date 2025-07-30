package com.kodilla.takemefront.dto;

import java.time.LocalDate;

public record TripsDTO(
        String id,
        String country,
        String city,
        LocalDate date,
        int numberOfTravelers
){
}
