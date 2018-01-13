package com.syntel.Scenes;

import com.syntel.DatabaseAction;
import static com.syntel.Scenes.Scene.matchInputWithChoice;
import com.syntel.SessionState;
import java.util.ArrayList;
import java.util.List;

public class RegisterScene extends Scene {

    String email;
    String password;
    boolean registering;
    
    @Override
    public Scene transitionNext() {
        
        if (registering) {
            boolean successful = DatabaseAction.createCustomer(email, password);
            
            if (!successful) {
                System.out.println("Registration was unsuccessful.");
                return this;
            }
            
            // log them in after success
            SessionState.customer = DatabaseAction.getCustomer(email, password);
        }

        return new HomeScene();
    }

    @Override
    public void process() {

        registering = false;

        // Create choices
        List<String> choices = new ArrayList<>();
        choices.add(email == null ? "Set email" : "Unset email") ;
        choices.add(password == null ? "Set password" : "Unset password") ;
        if (email != null && password != null)
            choices.add("Attempt register");
        choices.add("Back");

        do {
            // Display all choices
            for (int i = 0; i < choices.size(); i++)
                System.out.println("(" + i + ")" + " " + choices.get(i));

            // Match user input with choice
            selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

        } while (selectedChoice == null);


        switch (selectedChoice) {
            case "Set email":
                System.out.print("Email: ");
                email = scanner.nextLine();
                if (email.length() == 0)
                    email = null;
                break;

            case "Unset email":
                email = null;
                break;

            case "Set password":
                System.out.print("Password: ");
                password = scanner.nextLine();
                if (password.length() == 0)
                    password = null;
                break;

            case "Unset password":
                password = null;
                break;

            case "Attempt register":
                registering = true;

            case "Back":
                requestTransition = true;
                break;
        }
    }
}
