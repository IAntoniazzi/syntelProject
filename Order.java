/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;

/**
 *
 * @author syntel
 */
public class Order {
    private static int OrderId;
    private static int UserId;
    private static int AddressId;
    private static String PaymentMethod;
    private static String Date;
    private static String Time;
    private static float Price;
    private static ArrayList<FoodItem> Items;
    
    public static int getOrderId() {
        return OrderId;
    }

    public static void setOrderId(int OrderId) {
        Order.OrderId = OrderId;
    }

    public static int getUserId() {
        return UserId;
    }

    public static void setUserId(int UserId) {
        Order.UserId = UserId;
    }

    public static int getAddressId() {
        return AddressId;
    }

    public static void setAddressId(int AddressId) {
        Order.AddressId = AddressId;
    }

    public static String getPaymentMethod() {
        return PaymentMethod;
    }

    public static void setPaymentMethod(String PaymentMethod) {
        Order.PaymentMethod = PaymentMethod;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String Date) {
        Order.Date = Date;
    }

    public static String getTime() {
        return Time;
    }

    public static void setTime(String Time) {
        Order.Time = Time;
    }

    public static float getPrice() {
        return Price;
    }

    public static void setPrice(float Price) {
        Order.Price = Price;
    }

    public static ArrayList<FoodItem> getItems() {
        return Items;
    }

    public static void setItems(ArrayList<FoodItem> Items) {
        Order.Items = Items;
    }
    
    public static void addItem(int ItemId){
        Order.setItems(Order.getItems().add(getFoodItem(ItemId)));  //requires a global method getFoodItem() to get a food item object from an id#
    }
    
    public static void removeItem(int ItemId){
        Order.setItems(Order.getItems().remove(getFoodItem(ItemId))); ////requires a global method getFoodItem() to get a food item object from an id#
    }


}
