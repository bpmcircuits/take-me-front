package com.kodilla.tripplannerfront.tripplanerback.dto.travelers;

public record TravelerRequestDTO(String firstName,
                                 String lastName,
                                 String gender,
                                 String personType,
                                 String baggage) {
}
