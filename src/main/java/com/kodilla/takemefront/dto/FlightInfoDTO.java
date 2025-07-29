package com.kodilla.takemefront.dto;

public record FlightInfoDTO(String from,
                            String to,
                            String departureAirport,
                            String departureAirportCode,
                            String arrivalAirport,
                            String arrivalAirportCode,
                            String departureDate,
                            String departureTime,
                            String arrivalDate,
                            String arrivalTime,
                            String flightNumber) {
}
