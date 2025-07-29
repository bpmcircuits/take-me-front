package com.kodilla.takemefront.view;

import com.kodilla.takemefront.component.PriceBoxComponent;
import com.kodilla.takemefront.component.TripBoxComponent;
import com.kodilla.takemefront.service.FlightInfoService;
import com.kodilla.takemefront.service.OrderService;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("trip-summary/round-trip")
public class RoundTripView extends VerticalLayout {

    private OrderService orderService = OrderService.getInstance();
    private PriceBoxComponent priceBox = new PriceBoxComponent(orderService.getOrder());

    private FlightInfoService flightInfoService = FlightInfoService.getInstance();
    private TripBoxComponent tripBoxComponent1 = new TripBoxComponent(
            flightInfoService.getFlightDetails("Warsaw", "London")
    );

    private TripBoxComponent tripBoxComponent2 = new TripBoxComponent(
            flightInfoService.getFlightDetails("London", "Warsaw")
    );

    public RoundTripView() {
        setWidthFull();
        setPadding(true);
        setSpacing(false);

        H2 title = new H2("Katowice ⇌ Milan and back");

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidthFull();
        mainLayout.setAlignItems(Alignment.START);
        mainLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);

        VerticalLayout tripDetails = new VerticalLayout();
        tripDetails.setWidth("100%");
        tripDetails.setMaxWidth("700px");
        tripDetails.setPadding(false);
        tripDetails.setSpacing(false);

        tripDetails.add(
                tripBoxComponent1,
                tripBoxComponent2
        );

        mainLayout.add(tripDetails, priceBox);
        add(title, mainLayout);
    }
}

