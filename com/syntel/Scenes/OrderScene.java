/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.Scenes;

import com.syntel.Models.Order;
import com.syntel.SessionState;
import java.util.ArrayList;
import java.util.List;

public class OrderScene extends Scene {

    private enum State {
        Address,
        Date,
        Time,
        Payment,
        Receipt
    }

    private State state;

    // Both of these fields would be more complex classes later on
    private String address;
    private String paymentInfo;
    private String deliveryDate;
    private int deliveryTime;
    private Order order;

    public OrderScene() {
        deliveryTime = -1;
        state = State.Address;
        order = SessionState.ongoingOrder;
    }

    @Override
    public Scene transitionNext() {
        switch (selectedChoice) {
            case "Back":
                return new FoodScene();

            case "Finish":
                //TODO: Finalize the order and put into the database
                //TODO: get the user id from the customer in the session state
                //TODO: if the address chosen is the default address than do not create a new address
                //  just use the address id of the customer's address
                //TODO: need to finalize the food items to be added to the order items table
                order.setDeliveryAddress(address);
                order.setDeliveryDate(deliveryDate);
                order.setDeliveryTime(deliveryTime);
                //DatabaseAction.addOrder(SessionState.customer, order);
                return new HomeScene();
        }

        return this;
    }

    @Override
    public void process() {

        List<String> choices;

        switch (state) {
            case Address:
                choices = new ArrayList<>();
                if (address == null) {
                    choices.add("Use default address");
                    choices.add("Use new address");
                } else {
                    choices.add("Unset address");
                    choices.add("Next");
                }
                choices.add("Back");

                do {
                    // Display all choices
                    for (int i = 0; i < choices.size(); i++) {
                        System.out.println("(" + i + ")" + " " + choices.get(i));
                    }

                    // Match user input with choice
                    selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

                } while (selectedChoice == null);

                switch (selectedChoice) {

                    case "Back":
                        requestTransition = true;
                        break;

                    case "Use default address":
                        //TODO: get the address of the user from the session state
                        //TODO: make sure all food items are available for the address zip code area
                        break;

                    case "Use new address":
                        //TODO: make sure the new address is in an area that all the food on the order are available in
                        System.out.println("Type new address: ");
                        address = scanner.nextLine();
                        if (address.length() == 0) {
                            address = null;
                        }
                        break;

                    case "Unset address":
                        address = null;
                        break;

                    case "Next":
                        state = State.Date;
                        selectedChoice = null;
                        break;
                }
                break;

            case Date:
                choices = new ArrayList<>();

                if (deliveryDate == null) {
                    choices.add("Set date of delivery");
                } else {
                    choices.add("Unset date");
                    choices.add("Next");
                }
                choices.add("Back");

                do {
                    // Display all choices
                    for (int i = 0; i < choices.size(); i++) {
                        System.out.println("(" + i + ")" + " " + choices.get(i));
                    }

                    // Match user input with choice
                    selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

                } while (selectedChoice == null);

                switch (selectedChoice) {

                    case "Back":
                        requestTransition = true;
                        break;

                    case "Unset date":
                        deliveryDate = null;
                        break;

                    case "Set date of delivery":
                        //TODO: convert delivery date to an actual date and compare it to current date
                        System.out.println("Type delivery date: ");
                        deliveryDate = scanner.nextLine();
                        if (deliveryDate.length() == 0) {
                            deliveryDate = null;
                        }
                        break;

                    case "Next":
                        state = State.Time;
                        selectedChoice = null;
                        break;
                }
                break;

            case Time:
                choices = new ArrayList<>();

                if (deliveryTime == -1) {
                    choices.add("Set time of delivery");
                } else {
                    choices.add("Unset time");
                    choices.add("Begin Payment");
                }
                choices.add("Back");

                do {
                    // Display all choices
                    for (int i = 0; i < choices.size(); i++) {
                        System.out.println("(" + i + ")" + " " + choices.get(i));
                    }

                    // Match user input with choice
                    selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

                } while (selectedChoice == null);

                switch (selectedChoice) {

                    case "Back":
                        requestTransition = true;
                        break;

                    case "Unset time":
                        deliveryDate = null;
                        break;

                    case "Set time of delivery":
                        System.out.println("(Note: post the 24 hour time e.g. 22 = 10pm)");
                        System.out.println("Type delivery time: ");
                        try {
                            deliveryTime = Integer.parseInt( scanner.nextLine() );
                            if (deliveryTime < 0 || deliveryTime > 23)
                                deliveryTime = -1;
                        } catch (Exception e) {
                            deliveryTime = -1;
                        }
                        break;

                    case "Begin Payment":
                        state = State.Payment;
                        selectedChoice = null;
                        break;
                }
                break;

            case Payment:

                choices = new ArrayList<>();
                if (paymentInfo == null) {
                    choices.add("Cash");
                    choices.add("Card");
                } else {
                    choices.add("Unset payment");
                    choices.add("Finish");
                }
                choices.add("Back");

                do {
                    // Display all choices
                    for (int i = 0; i < choices.size(); i++) {
                        System.out.println("(" + i + ")" + " " + choices.get(i));
                    }

                    // Match user input with choice
                    selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

                } while (selectedChoice == null);

                switch (selectedChoice) {

                    case "Back":
                        requestTransition = true;
                        break;

                    case "Cash":
                        //TODO: fix this
                        //paymentInfo = SessionState.customer.getPaymentInfo();
                        // fix this when we have more concrete classes
                        //if (paymentInfo == null) {
                        //    paymentInfo = "";
                        //}
                        selectedChoice = null;
                        break;

                    case "Card":
                        //TODO: fix this,just using payment method not doing anything with credit cards
                        System.out.println("Type new payment information: ");
                        //paymentInfo = scanner.nextLine();
                        //if (paymentInfo.length() == 0) {
                        //    paymentInfo = null;
                        //}
                        selectedChoice = null;
                        break;

                    case "Unset payment":
                        paymentInfo = null;
                        break;

                    case "Finish":
                        state = State.Receipt;
                        break;
                }
                break;

            case Receipt:
                //TODO: print out the receipt to a file and to the console
                System.out.println("Payment finished.");
                //on transition method will do the heavy lifting for actually creating the order
                requestTransition = true;
        }
    }
}
