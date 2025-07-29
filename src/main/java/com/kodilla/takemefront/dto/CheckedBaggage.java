package com.kodilla.takemefront.dto;

import java.math.BigDecimal;

public class CheckedBaggage implements Baggage {

    private final BigDecimal weight;

    public CheckedBaggage(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("50.00");
    }
}
