package com.kodilla.tripplannerfront.dto;

public record HotelOrderDTO(
        String hotelName,
        String city,
        String country,
        String checkInDate,
        String checkOutDate,
        int numberOfGuests,
        int numberOfRooms,
        String roomType,
        double totalPrice
) {
}
