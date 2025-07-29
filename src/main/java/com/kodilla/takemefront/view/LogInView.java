package com.kodilla.takemefront.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LogInView extends VerticalLayout {

    public LogInView() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();

        H1 title = new H1("Log in");
        title.getStyle().set("font-weight", "bold");

        Paragraph subtitle = new Paragraph("Log in by entering your email address and password.");

        TextField email = new TextField("Email address");
        email.setPlaceholder("email@address.com");
        email.setPrefixComponent(new Icon(VaadinIcon.ENVELOPE));

        PasswordField password = new PasswordField("Password");
        password.setPrefixComponent(new Icon(VaadinIcon.LOCK));

        Anchor forgotPassword = new Anchor("/forgot-password", "Forgot password?");
        forgotPassword.getStyle().set("font-size", "small");


        Button loginButton = new Button("Log in");
        loginButton.setWidthFull();
        loginButton.getStyle().set("background-color", "#333").set("color", "white");

        Checkbox rememberMe = new Checkbox("Remember me");

        HorizontalLayout rememberLayout = new HorizontalLayout(rememberMe);
        rememberLayout.setJustifyContentMode(JustifyContentMode.START);
        rememberLayout.setWidthFull();

        HorizontalLayout signupLayout = new HorizontalLayout(
                new Span("Don't have an account?"),
                new Anchor("/signup", "Sign up here")
        );
        signupLayout.getStyle().set("font-size", "small");

        loginButton.addClickListener(e -> {
            // 🔁 Po kliknięciu przekieruj na stronę główną
            //UI.getCurrent().navigate("home");
        });

        // Cały formularz
        VerticalLayout formLayout = new VerticalLayout(
                title, subtitle,
                email, password,
                forgotPassword,
                loginButton,
                rememberLayout,
                new Hr(),
                signupLayout
        );
        formLayout.setWidth("350px");
        formLayout.setPadding(true);
        formLayout.setSpacing(true);
        formLayout.getStyle().set("border-radius", "15px");

        add(formLayout);
    }
}
