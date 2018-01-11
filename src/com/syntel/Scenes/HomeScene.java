package com.syntel.Scenes;

import com.syntel.SessionState;

import java.util.ArrayList;
import java.util.List;

public class HomeScene extends Scene {

    private final boolean loggedIn;
    private final boolean admin;

    public HomeScene() {
        loggedIn = SessionState.loggedIn();
        admin = loggedIn ? SessionState.customer.isAdmin() : false;
    }

    @Override
    public Scene transitionNext() {

        switch (selectedChoice) {

            case "Login":
                return new LoginScene();

            case "Register":
                return new RegisterScene();

            case "Logout":
                SessionState.customer = null;
                return new HomeScene();

            case "View available foods":
                return new FoodScene();

            case "View ongoing orders":
                break;

            // Implement scenes for these
            case "Todays management":
            case "User management":
            case "Area management":
            case "Package management":
            case "Order management":
                break;
        }

        return new HomeScene();
    }

    @Override
    public void process() {

        // Create choices
        List<String> choices = new ArrayList<>();
        if (!loggedIn) {
            choices.add("Login");
            choices.add("Register");
        } else {
            choices.add("Logout");
            choices.add("View available foods");
            choices.add("View ongoing orders");
        }

        if (admin) {
            choices.add("Todays management");
            choices.add("User management");
            choices.add("Area management");
            choices.add("Package management");
            choices.add("Order management");
        }

        do {
            // Display all choices
            for (int i = 0; i < choices.size(); i++)
                System.out.println("(" + i + ")" + " " + choices.get(i));

            // Match user input with choice
            selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

        } while (selectedChoice == null);

        requestTransition = true;
    }
}
