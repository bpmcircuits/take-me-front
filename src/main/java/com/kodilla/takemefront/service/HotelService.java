package com.kodilla.takemefront.service;

import com.kodilla.takemefront.dto.HotelOfferDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelService {

    private static final HotelService INSTANCE = new HotelService();
    private final List<HotelOfferDTO> offers;

    private HotelService() {
        this.offers = exampleData();
    }

    public static HotelService getInstance() {
        return INSTANCE;
    }

    public List<HotelOfferDTO> getAllOffers() {
        return Collections.unmodifiableList(offers);
    }

    private List<HotelOfferDTO> exampleData() {
        List<HotelOfferDTO> offers = new ArrayList<>();
        HotelOfferDTO offer1 = new HotelOfferDTO(
                "Grand Hotel",
                "Kraków",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 1),
                2,
                "500 PLN"
        );

        HotelOfferDTO offer2 = new HotelOfferDTO(
                "City Center Inn",
                "Warsaw",
                LocalDate.of(2025, 1, 2),
                LocalDate.of(2025, 1, 5),
                2,
                "400 PLN"
        );

        HotelOfferDTO offer3 = new HotelOfferDTO(
                "Beach Resort",
                "Gdańsk",
                LocalDate.of(2025, 7, 15),
                LocalDate.of(2025, 7, 20),
                2,
                "600 PLN"
        );

        HotelOfferDTO offer4 = new HotelOfferDTO(
                "Mountain Lodge",
                "Zakopane",
                LocalDate.of(2025, 2, 10),
                LocalDate.of(2025, 2, 15),
                2,
                "700 PLN"
        );

        HotelOfferDTO offer5 = new HotelOfferDTO(
                "Luxury Suites",
                "Wrocław",
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 3),
                2,
                "800 PLN"
        );


        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);

        return offers;
    }
}