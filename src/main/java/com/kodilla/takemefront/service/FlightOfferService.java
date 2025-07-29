package com.kodilla.takemefront.service;

import com.kodilla.takemefront.dto.FlightOfferDTO;
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
                "2024-07-01T10:00",
                "Warsaw",
                "2024-07-01T12:00",
                "London",
                "600 PLN"
        );

        FlightOfferDTO offer2 = new FlightOfferDTO(
                "Lufthansa",
                "2024-07-02T14:30",
                "Kraków",
                "2024-07-02T16:00",
                "Berlin",
                "450 PLN"
        );

        FlightOfferDTO offer3 = new FlightOfferDTO(
                "Ryanair",
                "2024-07-03T08:00",
                "Gdańsk",
                "2024-07-03T11:00",
                "Barcelona",
                "350 PLN"
        );

        FlightOfferDTO offer4 = new FlightOfferDTO(
                "Wizz Air",
                "2024-07-04T09:30",
                "Wrocław",
                "2024-07-04T11:00",
                "Budapest",
                "400 PLN"
        );

        FlightOfferDTO offer5 = new FlightOfferDTO(
                "Air France",
                "2024-07-05T15:00",
                "Poznań",
                "2024-07-05T17:30",
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