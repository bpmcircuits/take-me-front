package com.kodilla.takemefront.view;

import com.kodilla.takemefront.component.PriceBoxComponent;
import com.kodilla.takemefront.component.TripBoxComponent;
import com.kodilla.takemefront.dto.FlightInfoDTO;
import com.kodilla.takemefront.service.FlightInfoService;
import com.kodilla.takemefront.service.OrderService;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "trip-summary/one-way", layout = MainLayout.class)
@PageTitle("One Way Trip Summary")
public class OneWayTripView extends VerticalLayout {

    private OrderService orderService = OrderService.getInstance();
    private PriceBoxComponent priceBox = new PriceBoxComponent(orderService.getOrder());

    private FlightInfoService flightInfoService = FlightInfoService.getInstance();
    private FlightInfoDTO flightInfo = flightInfoService.getFlightDetails("Warsaw", "London");
    private TripBoxComponent tripBoxComponent = new TripBoxComponent(flightInfo);

    public OneWayTripView() {
        setWidthFull();
        setPadding(true);
        setSpacing(false);

        VerticalLayout pageLayout = new VerticalLayout();
        pageLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        H2 title = new H2(flightInfo.from() + " ⇌ " + flightInfo.to());
        // center the title in center of the page
        title.getStyle().set("border", "1px solid #ccc").set("padding", "1rem");

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidthFull();
        mainLayout.setAlignItems(Alignment.START);
        mainLayout.setPadding(true);
        mainLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        mainLayout.setSpacing(false);
        mainLayout.getThemeList().add("spacing-l");

        VerticalLayout tripDetails = new VerticalLayout();
        tripDetails.setWidth("100%");
        tripDetails.setMaxWidth("700px");
        tripDetails.setPadding(false);
        tripDetails.setSpacing(false);

        tripDetails.add(tripBoxComponent);

        mainLayout.add(tripDetails, priceBox);

        pageLayout.add(title, mainLayout);

        add(pageLayout);
    }
}
