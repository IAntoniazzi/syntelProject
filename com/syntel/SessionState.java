package com.syntel;

import com.syntel.Models.Customer;
import com.syntel.Models.Order;

/**
 * This would be the held sessions state, maybe represented by
 * cookies of a user logging in
 */
public class SessionState {

    private SessionState() {}

    public static boolean loggedIn() {
        return customer != null;
    }

    public static Customer customer = null;
    
    public static Order ongoingOrder = null;

}
