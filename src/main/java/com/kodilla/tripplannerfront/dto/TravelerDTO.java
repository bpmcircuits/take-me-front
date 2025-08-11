package com.kodilla.tripplannerfront.dto;

public record TravelerDTO (
        Long id,
        String firstName,
        String lastName,
        String gender,
        String personType,
        String baggageType
) {}
