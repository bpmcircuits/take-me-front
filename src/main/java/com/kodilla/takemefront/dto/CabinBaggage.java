package com.kodilla.takemefront.dto;

import java.math.BigDecimal;

public class CabinBaggage implements Baggage {

    private final BigDecimal weight;

    public CabinBaggage(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String getType() {
        return "Cabin Baggage";
    }

    @Override
    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("20.00");
    }
}
