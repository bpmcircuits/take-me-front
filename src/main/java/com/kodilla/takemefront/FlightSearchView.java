package com.kodilla.takemefront;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/search")
public class FlightSearchView extends VerticalLayout {

    public FlightSearchView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        DatePicker departDate = new DatePicker("Depart");
        DatePicker returnDate = new DatePicker("Return");
        VerticalLayout datesLayout = new VerticalLayout(departDate, returnDate);
        datesLayout.setPadding(false);
        datesLayout.setSpacing(true);

        TextField fromField = new TextField("From");
        TextField toField = new TextField("To");
        VerticalLayout locationLayout = new VerticalLayout(fromField, toField);
        locationLayout.setPadding(false);
        locationLayout.setSpacing(true);

        ComboBox<String> travelers = new ComboBox<>();
        travelers.setLabel("Travelers");
        travelers.setItems("1", "2", "3", "4", "5+");

        Checkbox directFlights = new Checkbox("Direct flights");
        VerticalLayout filtersLayout = new VerticalLayout(directFlights, travelers);
        filtersLayout.setPadding(false);
        filtersLayout.setSpacing(true);

        HorizontalLayout formLayout = new HorizontalLayout(datesLayout, locationLayout, filtersLayout);
        formLayout.setSpacing(true);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.END);

        Button searchButton = new Button("Search");
        H1 heading = new H1("Plan your adventure");
        VerticalLayout content = new VerticalLayout(heading, formLayout, searchButton);
        content.setAlignItems(Alignment.CENTER);
        content.setPadding(true);
        content.setSpacing(true);
        content.getStyle().set("border", "1px solid #aaa").set("padding", "20px");

        add(content);

        Button loginButton = new Button("Log In");
        loginButton.addClickListener(e -> {
            UI.getCurrent().navigate("/login");
        });

        Button signupButton = new Button("Sign Up");
        signupButton.addClickListener(e -> {
            UI.getCurrent().navigate("/signup");
        });

        HorizontalLayout topRight = new HorizontalLayout(loginButton, signupButton);
        topRight.setJustifyContentMode(JustifyContentMode.END);
        topRight.setWidthFull();

        addComponentAsFirst(topRight);
    }
}
