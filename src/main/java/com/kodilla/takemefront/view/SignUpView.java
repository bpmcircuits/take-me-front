package com.kodilla.takemefront.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("signup")
public class SignUpView extends VerticalLayout {

    public SignUpView() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();

        H1 title = new H1("Create Your Account");
        title.getStyle().set("font-weight", "bold");

        Paragraph subtitle = new Paragraph("Sign up by entering your email address and password.");

        TextField email = new TextField("Email address");
        email.setPlaceholder("email@address.com");
        email.setPrefixComponent(new Icon(VaadinIcon.ENVELOPE));

        PasswordField password = new PasswordField("Password");
        password.setPrefixComponent(new Icon(VaadinIcon.LOCK));

        Button createAccount = new Button("Create Account");
        createAccount.setWidthFull();
        createAccount.getStyle()
                .set("background-color", "#333")
                .set("color", "white")
                .set("font-weight", "bold");

        createAccount.addClickListener(e -> {
            // 🚀 Przejście po rejestracji (np. na ekran główny lub logowania)
            //UI.getCurrent().navigate("home");
        });

        // Linki z polityką
        Span terms = new Span("By creating an account, you are agree to the ");
        Anchor termsLink = new Anchor("#", "Terms of Service");
        Anchor privacyLink = new Anchor("#", "Privacy Policy");
        Span andText = new Span(" and ");
        Paragraph legal = new Paragraph(terms, termsLink, andText, privacyLink);
        legal.getStyle().set("font-size", "small");

        // Link do logowania
        HorizontalLayout loginLayout = new HorizontalLayout(
                new Span("Already have an account?"),
                new Anchor("/login", "Log in here")
        );
        loginLayout.getStyle().set("font-size", "small");

        VerticalLayout formLayout = new VerticalLayout(
                title, subtitle,
                email, password,
                createAccount,
                legal,
                loginLayout
        );
        formLayout.setWidth("350px");
        formLayout.setPadding(true);
        formLayout.setSpacing(true);
        formLayout.getStyle().set("border-radius", "15px");

        add(formLayout);
    }
}

