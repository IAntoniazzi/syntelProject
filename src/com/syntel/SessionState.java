package com.syntel;

import com.syntel.Models.Customer;
import com.syntel.Models.FoodItem;
import java.util.List;

/**
 * This would be the held sessions state, maybe represented by
 * headers/cookies sent to server
 */
public class SessionState {

    private SessionState() {}

    public static boolean loggedIn() {
        return customer != null;
    }

    public static Customer customer = null;
    
    public static List<FoodItem> addedItems = null;

}
