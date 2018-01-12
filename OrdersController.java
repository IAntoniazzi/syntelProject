
import java.util.ArrayList;


public class OrdersController {
     private Orders model;
   private OrdersView view;

   public OrdersController(OrdersModel model, OrdersView view){
      this.model = model;
      this.view = view;
   }

   public void setOrdersId(int Id){
      model.setOrdersId(Id);		
   }

   public int getOrdersId(){
      return model.getOrdersId();		
   }

  
   public void setAddressId(int Id){
      model.setAddressId(Id);		
   }

   public int getAddressId(){
      return model.getaddressId();		
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
