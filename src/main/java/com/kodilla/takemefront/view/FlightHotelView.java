package com.kodilla.takemefront.view;

import com.kodilla.takemefront.dto.FlightOfferDTO;
import com.kodilla.takemefront.dto.HotelOfferDTO;
import com.kodilla.takemefront.service.FlightOfferService;
import com.kodilla.takemefront.service.HotelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "results", layout = MainLayout.class)
@PageTitle("Flight and Hotel Offers")
public class FlightHotelView extends VerticalLayout {

    private final Grid<FlightOfferDTO> flightGrid = new Grid<>(FlightOfferDTO.class, false);
    private final Grid<HotelOfferDTO> hotelGrid = new Grid<>(HotelOfferDTO.class, false);
    private final Tabs tabs;
    private final Div content;

    private FlightOfferService flightOfferService = FlightOfferService.getInstance();
    private HotelService hotelService = HotelService.getInstance();

    public FlightHotelView() {
        Tab flightsTab = new Tab("Flights");
        Tab hotelsTab = new Tab("Hotels");
        tabs = new Tabs(flightsTab, hotelsTab);
        tabs.setSelectedTab(flightsTab);

        ComboBox<String> currencyBox = new ComboBox<>();
        currencyBox.setLabel("Currency");
        currencyBox.setItems("USD", "EUR", "PLN");
        currencyBox.setValue("USD");

        flightGrid.addColumn(FlightOfferDTO::airline).setHeader("Airline");
        flightGrid.addColumn(FlightOfferDTO::departureTime).setHeader("Departure Time");
        flightGrid.addColumn(FlightOfferDTO::from).setHeader("From");
        flightGrid.addColumn(FlightOfferDTO::arrivalTime).setHeader("Arrival Time");
        flightGrid.addColumn(FlightOfferDTO::to).setHeader("To");
        flightGrid.addColumn(FlightOfferDTO::cost).setHeader("Cost");

        hotelGrid.addColumn(HotelOfferDTO::name).setHeader("Hotel");
        hotelGrid.addColumn(HotelOfferDTO::location).setHeader("Location");
        hotelGrid.addColumn(HotelOfferDTO::price).setHeader("Cost");

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

        add(content, bottomBar);
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
        flightGrid.setItems(flightOfferService.getAllOffers());
    }

    private void refreshHotelGrid() {
        hotelGrid.setItems(hotelService.getAllOffers());
    }
}
