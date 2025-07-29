package com.kodilla.takemefront.component;

import com.kodilla.takemefront.dto.FlightOrderDTO;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.math.BigDecimal;
import java.util.List;

@Tag("div")
public class PriceBoxComponent extends Component {

    private List<FlightOrderDTO> items;

    public PriceBoxComponent(List<FlightOrderDTO> items) {
        this.items = items;
    }

    public Component createPriceBox() {
        VerticalLayout box = new VerticalLayout();
        box.getStyle().set("border", "1px solid #ccc").set("padding", "1rem");
        box.setWidth("300px");

        for (FlightOrderDTO item : items) {
            HorizontalLayout row = new HorizontalLayout(new Span(item.label()), new Span(String.valueOf(item.value())));
            row.setWidthFull();
            row.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
            box.add(row);
        }

        BigDecimal totalAmount = items.stream()
                .map(FlightOrderDTO::value)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        HorizontalLayout totalRow = new HorizontalLayout(new Span("Total (PLN)"),
                new Span(String.valueOf(totalAmount)));
        totalRow.getStyle().set("font-weight", "bold");
        totalRow.setWidthFull();
        totalRow.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        box.add(totalRow);
        return box;
    }
}
