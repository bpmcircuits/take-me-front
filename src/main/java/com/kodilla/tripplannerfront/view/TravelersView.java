package com.kodilla.tripplannerfront.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "travelers", layout = MainLayout.class)
@PageTitle("Travelers")
public class TravelersView extends VerticalLayout {

    private List<Traveler> travelers = new ArrayList<>();
    private Grid<Traveler> travelerGrid = new Grid<>(Traveler.class);

    public TravelersView() {
        setWidthFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H2 title = new H2("Travelers");

        TextField firstNameField = new TextField();
        firstNameField.setPlaceholder("First name");

        TextField lastNameField = new TextField();
        lastNameField.setPlaceholder("Last name");

        ComboBox<String> genderBox = new ComboBox<>();
        genderBox.setPlaceholder("Gender");
        genderBox.setItems("Male", "Female", "Other");

        ComboBox<String> personTypeBox = new ComboBox<>();
        personTypeBox.setPlaceholder("Person type");
        personTypeBox.setItems("Adult", "Child", "Infant");

        ComboBox<String> baggageBox = new ComboBox<>();
        baggageBox.setPlaceholder("Baggage");
        baggageBox.setItems("None", "Small", "Medium", "Large");

        Button addButton = new Button("Add traveler");
        addButton.addClickListener(e -> {
            Traveler traveler = new Traveler(
                    firstNameField.getValue(),
                    lastNameField.getValue(),
                    genderBox.getValue(),
                    personTypeBox.getValue(),
                    baggageBox.getValue()
            );
            travelers.add(traveler);
            travelerGrid.setItems(travelers);

            // Wyczyść pola
            firstNameField.clear();
            lastNameField.clear();
            genderBox.clear();
            personTypeBox.clear();
            baggageBox.clear();
        });

        HorizontalLayout formLayout = new HorizontalLayout(
                firstNameField, lastNameField, genderBox, personTypeBox, baggageBox
        );
        formLayout.setAlignItems(Alignment.BASELINE);

        travelerGrid.setColumns("firstName", "lastName", "gender", "personType", "baggage");
        travelerGrid.getColumnByKey("firstName").setHeader("FIRST NAME");
        travelerGrid.getColumnByKey("lastName").setHeader("LAST NAME");
        travelerGrid.getColumnByKey("gender").setHeader("GENDER");
        travelerGrid.getColumnByKey("personType").setHeader("PERSON");
        travelerGrid.getColumnByKey("baggage").setHeader("BAGGAGE");

        Button deleteButton = new Button("Delete traveler", event -> {
            Traveler selected = travelerGrid.asSingleSelect().getValue();
            if (selected != null) {
                travelers.remove(selected);
                travelerGrid.setItems(travelers);
            }
        });

        add(title, formLayout, addButton, travelerGrid, deleteButton);
    }

    public static class Traveler {
        private String firstName;
        private String lastName;
        private String gender;
        private String personType;
        private String baggage;

        public Traveler(String firstName, String lastName, String gender, String personType, String baggage) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.personType = personType;
            this.baggage = baggage;
        }

        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getGender() { return gender; }
        public String getPersonType() { return personType; }
        public String getBaggage() { return baggage; }

        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setGender(String gender) { this.gender = gender; }
        public void setPersonType(String personType) { this.personType = personType; }
        public void setBaggage(String baggage) { this.baggage = baggage; }
    }
}
