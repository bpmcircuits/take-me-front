package com.kodilla.tripplannerfront.tripplanerback.dto.travelers;

public record TravelerResponseDTO(Long id,
                                  String firstName,
                                  String lastName,
                                  String gender,
                                  String personType,
                                  int age,
                                  String baggage,
                                  Long tripId) {
}
