package com.kodilla.takemefront.component;

import com.kodilla.takemefront.dto.FlightInfoDTO;
import com.kodilla.takemefront.dto.FlightOrderDTO;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TripBoxComponent extends VerticalLayout {

    public TripBoxComponent(FlightInfoDTO info) {
        this.getStyle().set("border", "1px solid #ccc")
                .set("padding", "1rem")
                .set("margin-bottom", "1rem");
        this.setWidthFull();

        Span header = new Span(info.from() + " → " + info.to());
        header.getStyle().set("font-weight", "bold");

        HorizontalLayout line = new HorizontalLayout(
                new Span(info.departureTime() + " " + info.departureDate()),
                new Span(info.flightNumber()),
                new Span(info.arrivalTime() + " " + info.arrivalDate())
        );
        line.setWidthFull();
        line.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        HorizontalLayout cities = new HorizontalLayout(
                new Span(info.departureAirport() + " : " + info.departureAirportCode()),
                new Span("→"),
                new Span(info.arrivalAirport() + " : " + info.arrivalAirportCode())
        );
        cities.setWidthFull();
        cities.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        this.add(header, line, cities);
    }
}
