package com.kodilla.takemefront.service;

import com.kodilla.takemefront.domain.FlightOffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightService {
    private static final FlightService INSTANCE = new FlightService();
    private final List<FlightOffer> offers;

    private FlightService() {
        this.offers = exampleData();
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }

    public List<FlightOffer> getAllOffers() {
        return new ArrayList<>(offers);
    }

    private List<FlightOffer> exampleData() {
        List<FlightOffer> offers = new ArrayList<>();
        FlightOffer offer1 = new FlightOffer();
        offer1.setAirline("LOT Polish Airlines");
        offer1.setFrom("Warsaw");
        offer1.setTo("London");
        offer1.setDepartureTime("2024-07-01T10:00");
        offer1.setArrivalTime("2024-07-01T12:00");
        offer1.setCost("600 PLN");

        FlightOffer offer2 = new FlightOffer();
        offer2.setAirline("Lufthansa");
        offer2.setFrom("Kraków");
        offer2.setTo("Berlin");
        offer2.setDepartureTime("2024-07-02T14:30");
        offer2.setArrivalTime("2024-07-02T16:00");
        offer2.setCost("450 PLN");

        FlightOffer offer3 = new FlightOffer();
        offer3.setAirline("Ryanair");
        offer3.setFrom("Gdańsk");
        offer3.setTo("Barcelona");
        offer3.setDepartureTime("2024-07-03T08:00");
        offer3.setArrivalTime("2024-07-03T11:00");
        offer3.setCost("350 PLN");

        FlightOffer offer4 = new FlightOffer();
        offer4.setAirline("Wizz Air");
        offer4.setFrom("Wrocław");
        offer4.setTo("Budapest");
        offer4.setDepartureTime("2024-07-04T09:30");
        offer4.setArrivalTime("2024-07-04T11:00");
        offer4.setCost("400 PLN");

        FlightOffer offer5 = new FlightOffer();
        offer5.setAirline("Air France");
        offer5.setFrom("Poznań");
        offer5.setTo("Paris");
        offer5.setDepartureTime("2024-07-05T15:00");
        offer5.setArrivalTime("2024-07-05T17:30");
        offer5.setCost("700 PLN");

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);

        return  offers;
    }
}