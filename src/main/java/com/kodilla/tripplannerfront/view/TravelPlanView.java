package com.kodilla.tripplannerfront.view;

import com.kodilla.tripplannerfront.dto.FlightOfferDTO;
import com.kodilla.tripplannerfront.dto.HotelOfferDTO;
import com.kodilla.tripplannerfront.dto.TravelerDTO;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Route(value = "travel-plan", layout = MainLayout.class)
@PageTitle("Travel Plan")
public class TravelPlanView extends VerticalLayout {

    public TravelPlanView() {
        setWidthFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H2 title = new H2("Travel plan");
        add(title);

        // --- FLIGHT SECTION ---
        Grid<FlightOfferDTO> flightGrid = new Grid<>(FlightOfferDTO.class, false);
        flightGrid.setAllRowsVisible(true);
        flightGrid.setWidthFull();
        flightGrid.addColumn(FlightOfferDTO::from).setHeader("FROM");
        flightGrid.addColumn(FlightOfferDTO::to).setHeader("TO");
        flightGrid.addColumn(FlightOfferDTO::departureTime).setHeader("DEPARTURE");
        flightGrid.addColumn(FlightOfferDTO::arrivalTime).setHeader("ARRIVAL");
        flightGrid.addColumn(FlightOfferDTO::cost).setHeader("PRICE");

        flightGrid.setItems(getSelectedFlight()); // przykładowe dane
        add(flightGrid);

        Button changeFlightButton = new Button("Change Flight", e ->
                UI.getCurrent().navigate("results"));

        HorizontalLayout flightButtonRow = new HorizontalLayout(changeFlightButton);
        flightButtonRow.setWidthFull();
        flightButtonRow.setJustifyContentMode(JustifyContentMode.START);
        changeFlightButton.setWidth("160px");
        add(flightButtonRow);

        // --- HOTEL SECTION ---
        Grid<HotelOfferDTO> hotelGrid = new Grid<>(HotelOfferDTO.class, false);
        hotelGrid.setAllRowsVisible(true);
        hotelGrid.setWidthFull();
        hotelGrid.addColumn(HotelOfferDTO::name).setHeader("CITY");
        hotelGrid.addColumn(HotelOfferDTO::location).setHeader("HOTEL");
        hotelGrid.addColumn(HotelOfferDTO::startDate).setHeader("FROM");
        hotelGrid.addColumn(HotelOfferDTO::endDate).setHeader("TO");
        hotelGrid.addColumn(HotelOfferDTO::guests).setHeader("GUESTS");
        hotelGrid.addColumn(HotelOfferDTO::price).setHeader("PRICE");

        hotelGrid.setItems(getSelectedHotel());
        add(hotelGrid);

        Button changeHotelButton = new Button("Change Hotel", e ->
                UI.getCurrent().navigate("results"));

        HorizontalLayout hotelButtonRow = new HorizontalLayout(changeHotelButton);
        hotelButtonRow.setWidthFull();
        hotelButtonRow.setJustifyContentMode(JustifyContentMode.START);
        changeHotelButton.setWidth("160px");
        add(hotelButtonRow);

        // --- TRAVELERS SECTION ---
        Grid<TravelerDTO> travelerGrid = new Grid<>(TravelerDTO.class, false);
        travelerGrid.setAllRowsVisible(true);
        travelerGrid.setWidthFull();
        travelerGrid.addColumn(TravelerDTO::firstName).setHeader("FIRST NAME");
        travelerGrid.addColumn(TravelerDTO::lastName).setHeader("LAST NAME");
        travelerGrid.addColumn(TravelerDTO::gender).setHeader("GENDER");
        travelerGrid.addColumn(TravelerDTO::personType).setHeader("PERSON");
        travelerGrid.addColumn(TravelerDTO::baggageType).setHeader("BAGGAGE");

        travelerGrid.setItems(getTravelers());
        add(travelerGrid);

        Button changeTravelersButton = new Button("Change Travelers", e ->
                UI.getCurrent().navigate("travelers"));

        HorizontalLayout travelerButtonRow = new HorizontalLayout(changeTravelersButton);
        travelerButtonRow.setWidthFull();
        travelerButtonRow.setJustifyContentMode(JustifyContentMode.START);
        changeTravelersButton.setWidth("160px");
        add(travelerButtonRow);

        Button savePlanButton = new Button("Save", e -> {
            // tutaj logika zapisu planu podróży
        });

        HorizontalLayout saveButtonRow = new HorizontalLayout(savePlanButton);
        saveButtonRow.setWidthFull();
        saveButtonRow.setJustifyContentMode(JustifyContentMode.CENTER);

        add(saveButtonRow);
    }

    // Przykładowe metody – docelowo będą dane z backendu / service
    private List<FlightOfferDTO> getSelectedFlight() {
        return List.of(new FlightOfferDTO("Wizir",
                LocalDateTime.of(2025, 8, 1, 8, 0),
                "Warsaw",
                LocalDateTime.of(2025, 8, 1, 10, 0),
                "London",
                "123 zeta"));
    }

    private List<HotelOfferDTO> getSelectedHotel() {
        return List.of(new HotelOfferDTO("Hilton", "London",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 5),
                2, "500 zeta"));
    }

    private List<TravelerDTO> getTravelers() {
        return List.of(
                new TravelerDTO("John",
                        "Doe",
                        "Male",
                        "Adult",
                        "20kg"),
                new TravelerDTO("Jane",
                        "Doe",
                        "Female",
                        "Child",
                        "10kg")
        );
    }
}

