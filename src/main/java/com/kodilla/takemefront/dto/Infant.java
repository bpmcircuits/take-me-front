package com.kodilla.takemefront.dto;

import java.util.Objects;

public class Infant implements Person {

    private String firstName;
    private String lastName;
    private String country;

    public Infant(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
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
        return "";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Infant infant = (Infant) object;
        return Objects.equals(firstName, infant.firstName) && Objects.equals(lastName, infant.lastName)
                && Objects.equals(country, infant.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country);
    }
}
