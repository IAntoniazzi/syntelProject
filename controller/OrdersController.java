package controller;


import com.syntel.Scenes.OrdersView;
import com.syntel.Models.Orders;
import java.util.ArrayList;
import model.FoodItem;


public class OrdersController {
    private Orders model;
    private OrdersView view;

   public OrdersController(Orders model, OrdersView view){
      this.model = model;
      this.view = view;
   }

   public void setOrdersId(byte[] Id){
      model.setOrderId(Id);		
   }

   public byte[] getOrdersId(){
      return model.getOrderId();		
   }

  
   public void setAddressId(byte[] Id){
      model.setAddressId(Id);		
   }

   public byte[] getAddressId(){
      return model.getAddressId();		
   }
   
   public void setPaymentMethod(String PaymentMethod){
      model.setPaymentMethod(PaymentMethod);		
   }

   public String getPaymentMethod(){
      return model.getPaymentMethod();		
   }
   
   public void setOrderDate(String Date){
      model.setOrderDate(Date);		
   }

   public String getOrderDate(){
      return model.getOrderDate();		
   }
     
   public void setDeliveryDate(String Date){
        model.setDeliveryDate(Date);
   }
     
    public String getDeliveryDate(){
        return model.getDeliveryDate();
   }
   
   public void setTime(String Time) {
        model.setTime(Time);
    }
   
   public String getTime() {
        return model.getTime();
    }

   public void setPrice(float Price) {
        model.setPrice(Price);
    }

    public float getPrice() {
        return model.getPrice();
    }
    
    public void setItems(ArrayList<FoodItem> Items) {
        model.setItems(Items);
    }
    
    public ArrayList<FoodItem> getItems() {
        return model.getItems();
    }

    public void addItem(FoodItem Item) {
        model.addItem(Item);
    }
    
    public void removeItem(FoodItem Item){
        model.removeItem(Item);
    }
  
}
