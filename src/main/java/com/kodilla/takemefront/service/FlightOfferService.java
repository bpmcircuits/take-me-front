package com.kodilla.takemefront.service;

import com.kodilla.takemefront.dto.FlightOfferDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightOfferService {
    private static final FlightOfferService INSTANCE = new FlightOfferService();
    private final List<FlightOfferDTO> offers;

    private FlightOfferService() {
        this.offers = exampleData();
    }

    public static FlightOfferService getInstance() {
        return INSTANCE;
    }

    public List<FlightOfferDTO> getAllOffers() {
        return new ArrayList<>(offers);
    }

    private List<FlightOfferDTO> exampleData() {
        List<FlightOfferDTO> offers = new ArrayList<>();
        FlightOfferDTO offer1 = new FlightOfferDTO(
                "LOT Polish Airlines",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Warsaw",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "London",
                "600 PLN"
        );

        FlightOfferDTO offer2 = new FlightOfferDTO(
                "Lufthansa",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Kraków",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Berlin",
                "450 PLN"
        );

        FlightOfferDTO offer3 = new FlightOfferDTO(
                "Ryanair",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Gdańsk",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Barcelona",
                "350 PLN"
        );

        FlightOfferDTO offer4 = new FlightOfferDTO(
                "Wizz Air",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Wrocław",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Budapest",
                "400 PLN"
        );

        FlightOfferDTO offer5 = new FlightOfferDTO(
                "Air France",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Poznań",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Paris",
                "700 PLN"
        );

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);

        return  offers;
    }
}