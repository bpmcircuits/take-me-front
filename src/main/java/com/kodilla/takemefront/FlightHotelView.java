package com.kodilla.takemefront;

import com.kodilla.takemefront.domain.FlightOffer;
import com.kodilla.takemefront.domain.HotelOffer;
import com.kodilla.takemefront.service.FlightService;
import com.kodilla.takemefront.service.HotelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("results")
public class FlightHotelView extends VerticalLayout {

    private final Grid<FlightOffer> flightGrid = new Grid<>(FlightOffer.class, false);
    private final Grid<HotelOffer> hotelGrid = new Grid<>(HotelOffer.class, false);
    private final Tabs tabs;
    private final Div content;

    private FlightService flightService = FlightService.getInstance();
    private HotelService hotelService = HotelService.getInstance();

    public FlightHotelView() {
        Tab flightsTab = new Tab("Flights");
        Tab hotelsTab = new Tab("Hotels");
        tabs = new Tabs(flightsTab, hotelsTab);
        tabs.setSelectedTab(flightsTab);

        Button loginButton = new Button("Log In");
        Button signUpButton = new Button("Sign Up");

        HorizontalLayout topBar = new HorizontalLayout(tabs, new Spacer(), loginButton, signUpButton);
        topBar.setWidthFull();
        topBar.setAlignItems(FlexComponent.Alignment.CENTER);

        ComboBox<String> currencyBox = new ComboBox<>();
        currencyBox.setLabel("Currency");
        currencyBox.setItems("USD", "EUR", "PLN");
        currencyBox.setValue("USD");

        flightGrid.addColumn(FlightOffer::getAirline).setHeader("Airline");
        flightGrid.addColumn(FlightOffer::getDepartureTime).setHeader("Departure Time");
        flightGrid.addColumn(FlightOffer::getFrom).setHeader("From");
        flightGrid.addColumn(FlightOffer::getArrivalTime).setHeader("Arrival Time");
        flightGrid.addColumn(FlightOffer::getTo).setHeader("To");
        flightGrid.addColumn(FlightOffer::getCost).setHeader("Cost");

        hotelGrid.addColumn(HotelOffer::getName).setHeader("Hotel");
        hotelGrid.addColumn(HotelOffer::getLocation).setHeader("Location");
        hotelGrid.addColumn(HotelOffer::getCost).setHeader("Cost");

        content = new Div(flightGrid);
        content.setWidthFull();

        Button backButton = new Button("Back to search");
        Button alertsButton = new Button("Get Price Alerts");

        HorizontalLayout bottomBar = new HorizontalLayout(backButton, new Spacer(), currencyBox, alertsButton);
        bottomBar.setWidthFull();

        tabs.addSelectedChangeListener(event -> {
            content.removeAll();
            if (event.getSelectedTab() == flightsTab) {
                content.add(flightGrid);
            } else {
                content.add(hotelGrid);
            }
        });

        add(topBar, content, bottomBar);
        setSizeFull();
        refreshFlightGrid();
        refreshHotelGrid();
    }

    private static class Spacer extends Div {
        public Spacer() {
            setWidthFull();
        }
    }

    private void refreshFlightGrid() {
        flightGrid.setItems(flightService.getAllOffers());
    }

    private void refreshHotelGrid() {
        hotelGrid.setItems(hotelService.getAllOffers());
    }
}
