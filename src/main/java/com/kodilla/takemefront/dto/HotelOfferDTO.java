package com.kodilla.takemefront.dto;

import java.time.LocalDate;

public record HotelOfferDTO(String name,
                            String location,
                            LocalDate startDate,
                            LocalDate endDate,
                            int guests,
                            String price) {
}
