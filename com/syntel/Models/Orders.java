package com.syntel.Models;


import java.util.ArrayList;


public class Orders {
     private int OrderId;
    private int UserId;
    private int AddressId;
    private String PaymentMethod;
    private String OrderDate;
    private String DeliveryDate;
    private String Time;
    private float Price;
    private ArrayList<FoodItem> Items; 
     
    public Orders(int orderId, int userId, int addressId, String payment, String oDate, float price, String dDate, String dTime){
         this.OrderId = orderId;
         this.UserId = userId;
         this.AddressId = addressId;
         this.PaymentMethod = payment;
         this.OrderDate = oDate;
         this.DeliveryDate = dDate;
         this.Time = dTime;
         this.Price = price;
    }
     
    
    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }
    
    public String getOrderDate() {
        return OrderDate;
    }
     
    public String getDeliveryDate() {
         return DeliveryDate;
    }
    
    public void setDeliveryDate(String DeliveryDate) {
         this.DeliveryDate = DeliveryDate;
    }
    
     public void setOrderDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public ArrayList<FoodItem> getItems() {
        return Items;
    }

    public void setItems(ArrayList<FoodItem> Items) {
        this.Items = Items;
    }
    
    public void addItem(FoodItem Item){
        //this.setItems(this.getItems().add(Item));
        this.getItems().add(Item);
    }
    
    public void removeItem(FoodItem Item){
        //this.setItems(this.getItems().remove(Item)); 
        this.getItems().remove(Item);
    }


}
