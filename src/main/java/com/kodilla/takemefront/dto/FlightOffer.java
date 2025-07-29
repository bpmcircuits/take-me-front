package com.kodilla.takemefront.dto;

import java.util.Objects;

public class FlightOffer {

    private String airline;
    private String departureTime;
    private String from;
    private String arrivalTime;
    private String to;
    private String cost;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
        FlightOffer that = (FlightOffer) object;
        return Objects.equals(airline, that.airline) && Objects.equals(departureTime, that.departureTime)
                && Objects.equals(from, that.from) && Objects.equals(arrivalTime, that.arrivalTime)
                && Objects.equals(to, that.to) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, departureTime, from, arrivalTime, to, cost);
    }
}