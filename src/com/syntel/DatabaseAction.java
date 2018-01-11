package com.syntel;

import com.syntel.Models.Customer;
import com.syntel.Models.FoodItem;
import com.syntel.Models.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * This would be the 'server' (a scene) requesting for a database resource,
 * connect all db queries here
 */
public class DatabaseAction {

    private DatabaseAction() {}

    public static boolean customerExists(String email){
        //returns true if customer already exists
    }
    
    public static Customer getCustomer(String email, String password) {
        if(customerExists(email){
        // attempt a login
        }
        return new Customer();
    }
    
    public static boolean createCustomer(String email, String password) {
        if(!customerExists(email){
            //insert customer into table
        }
        else{
            //redirect to login
        }
        return true;  //on success
    }

    public static List<Order> getOrders(Customer customer) {
        // all orders that the customer has already ordered
        
        return new ArrayList<>();
    }

    public static List<FoodItem> getFood(Customer customer) {
        // get all food that would be available for customer,
        // discriminating on their location

        ArrayList<FoodItem> food = new ArrayList<>();

        food.add(new FoodItem("Food 1"));
        food.add(new FoodItem("Food 2"));
        food.add(new FoodItem("Food 3"));

        return food;
    }

    /**
     * The user can alter an ongoing order by:
     *   extending delivery,
     *   modify meal options,
     *   modifying the delivery address.
     */
    public static boolean alterOrderOption(Customer customer, Order order, int id) {
        return true;
    }

    /**
     * The administrators set specials for the day
     */
    public static List<Package> getTodaysSpecials() {
        return new ArrayList<>();
    }

}
