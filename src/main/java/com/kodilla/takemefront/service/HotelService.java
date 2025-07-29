package com.kodilla.takemefront.service;

import com.kodilla.takemefront.dto.HotelOffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelService {

    private static final HotelService INSTANCE = new HotelService();
    private final List<HotelOffer> offers;

    private HotelService() {
        this.offers = exampleData();
    }

    public static HotelService getInstance() {
        return INSTANCE;
    }

    public List<HotelOffer> getAllOffers() {
        return Collections.unmodifiableList(offers);
    }

    private List<HotelOffer> exampleData() {
        List<HotelOffer> offers = new ArrayList<>();
        HotelOffer offer1 = new HotelOffer();
        offer1.setName("Grand Hotel");
        offer1.setLocation("Kraków");
        offer1.setCost("500 PLN");

        HotelOffer offer2 = new HotelOffer();
        offer2.setName("City Center Inn");
        offer2.setLocation("Warsaw");
        offer2.setCost("400 PLN");

        HotelOffer offer3 = new HotelOffer();
        offer3.setName("Beach Resort");
        offer3.setLocation("Gdańsk");
        offer3.setCost("600 PLN");

        HotelOffer offer4 = new HotelOffer();
        offer4.setName("Mountain Lodge");
        offer4.setLocation("Zakopane");
        offer4.setCost("700 PLN");

        HotelOffer offer5 = new HotelOffer();
        offer5.setName("Luxury Suites");
        offer5.setLocation("Wrocław");
        offer5.setCost("800 PLN");

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);

        return offers;
    }
}