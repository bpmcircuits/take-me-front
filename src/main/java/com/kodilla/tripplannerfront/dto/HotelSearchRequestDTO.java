package com.kodilla.tripplannerfront.dto;

public record HotelSearchRequestDTO(String query,
                                    String checkinDate,
                                    String checkoutDate,
                                    int adultsNumber) {
}
