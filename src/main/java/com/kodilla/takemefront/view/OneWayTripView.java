package com.kodilla.takemefront.view;

import com.kodilla.takemefront.component.PriceBoxComponent;
import com.kodilla.takemefront.service.OrderService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Map;

@Route("trip-summary/one-way")
public class OneWayTripView extends VerticalLayout {

    private OrderService orderService = OrderService.getInstance();
    private PriceBoxComponent priceBox = new PriceBoxComponent(orderService.getOrder());

    public OneWayTripView() {
        setWidthFull();
        setPadding(true);
        setSpacing(false);

        H2 title = new H2("Katowice ⇌ Milan one way");

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidthFull();
        mainLayout.setAlignItems(Alignment.START);
        mainLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);

        VerticalLayout tripDetails = new VerticalLayout();
        tripDetails.setWidth("100%");
        tripDetails.setMaxWidth("700px");
        tripDetails.setPadding(false);
        tripDetails.setSpacing(false);

        tripDetails.add(createTripBox("Katowice ⇌ Milan", "18:25", "Sun, 3 Aug", "Katowice : KTW", "Milan : BGY", "Ryanair FR 3412 operated by Malta Air AL 3412"));

        mainLayout.add(tripDetails, priceBox.createPriceBox());
        add(title, mainLayout);
    }

    private Component createTripBox(String title, String time, String date, String from, String to, String flight) {
        VerticalLayout box = new VerticalLayout();
        box.getStyle().set("border", "1px solid #ccc").set("padding", "1rem").set("margin-bottom", "1rem");
        box.setWidthFull();

        Span header = new Span(title);
        header.getStyle().set("font-weight", "bold");

        HorizontalLayout line = new HorizontalLayout(
                new Span(time + " " + date),
                new Span(flight),
                new Span(time + " " + date)
        );
        line.setWidthFull();
        line.setJustifyContentMode(JustifyContentMode.BETWEEN);

        HorizontalLayout cities = new HorizontalLayout(
                new Span(from),
                new Span("→"),
                new Span(to)
        );
        cities.setWidthFull();
        cities.setJustifyContentMode(JustifyContentMode.BETWEEN);

        box.add(header, line, cities);
        return box;
    }
}
