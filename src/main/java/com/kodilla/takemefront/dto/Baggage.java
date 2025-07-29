package com.kodilla.takemefront.dto;

import java.math.BigDecimal;

public interface Baggage {
    String getType();
    BigDecimal getWeight();
    BigDecimal getPrice();
}
