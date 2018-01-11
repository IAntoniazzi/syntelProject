package com.syntel.Scenes;

import com.syntel.DatabaseAction;
import com.syntel.Models.Order;
import com.syntel.SessionState;
import com.syntel.Models.FoodItem;

import java.util.ArrayList;
import java.util.List;




public class FoodScene extends Scene {

    private enum State {
        Options,
        AddFood,
        RemoveFood,
    }
    
    private List<FoodItem> retrievedFoods;
    private List<FoodItem> addedItems;
    private List<Package> todaysSpecials;
    private State state;

    FoodScene() {
        state = State.Options;
        retrievedFoods = DatabaseAction.getFood(SessionState.customer);
        // mix todaysSpecial orders with retrievedFoods?
        todaysSpecials = DatabaseAction.getTodaysSpecials();
        addedItems = new ArrayList<>();
    }

    @Override
    public Scene transitionNext() {

        switch (selectedChoice) {
            case "Go back home":
                return new HomeScene();
        }

        return this;
    }

    @Override
    public void process() {

        FoodItem food;

        switch (this.state) {

            case Options:
                System.out.println("There are currently " + addedItems.size() + " items added.");

                List<String> choices = new ArrayList<>();
                choices.add("Add");
                if (addedItems.size() > 0) {
                    choices.add("Remove");
                    choices.add("Show selection");
                }
                choices.add("Go back home");

                do {

                    // Display all choices
                    for (int i = 0; i < choices.size(); i++)
                        System.out.println("(" + i + ")" + " " + choices.get(i));

                    // Match user input with choice
                    selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

                } while (selectedChoice == null);

                if (selectedChoice.equals("Go back home")) {
                    requestTransition = true;
                }

                else {

                    switch (selectedChoice) {
                        case "Remove":
                            state = State.RemoveFood;
                            break;

                        case "Add":
                            state = State.AddFood;
                            break;

                        case "Show selection":
                            System.out.println("Current items: ");
                            for (FoodItem f : addedItems)
                                System.out.println(f);
                            System.out.println();
                            break;
                    }
                }

                break;

            case AddFood:
                System.out.println("Add a food: ");

                for (int i = 0; i < retrievedFoods.size(); i++)
                    System.out.println("(" + i + ")" + " " + retrievedFoods.get(i));

                food = matchInputWithChoice(scanner.nextLine(), retrievedFoods);

                if (food != null)
                    addedItems.add(food);

                state = State.Options;
                break;

            case RemoveFood:
                System.out.println("Remove a food: ");

                for (int i = 0; i < addedItems.size(); i++)
                    System.out.println("(" + i + ")" + " " + addedItems.get(i));

                food = matchInputWithChoice(scanner.nextLine(), addedItems);

                if (food != null)
                    addedItems.remove(food);

                state = State.Options;
                break;
        }

    }

}
