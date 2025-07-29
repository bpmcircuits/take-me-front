package com.kodilla.takemefront.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Child implements Person, BaggageOwner {

    private String firstName;
    private String lastName;
    private String country;
    private List<Baggage> baggages;

    public Child(String firstName, String lastName, String country, List<Baggage> baggages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.baggages = baggages;
    }

    @Override
    public String getFirstName() {
        return "";
    }

    @Override
    public String getLastName() {
        return "";
    }

    @Override
    public String getCountry() {
        return "";
    }

    @Override
    public String getTypeOfPerson() {
        return "Child";
    }

    @Override
    public List<Baggage> getBaggages() {
        return new ArrayList<>(baggages);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Child child = (Child) object;
        return Objects.equals(firstName, child.firstName) && Objects.equals(lastName, child.lastName)
                && Objects.equals(country, child.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country);
    }
}
