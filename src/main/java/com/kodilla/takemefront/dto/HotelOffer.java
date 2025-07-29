package com.kodilla.takemefront.dto;

import java.util.Objects;

public class HotelOffer {
    private String name;
    private String location;
    private String cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        HotelOffer that = (HotelOffer) object;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location)
                & Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, cost);
    }
}
