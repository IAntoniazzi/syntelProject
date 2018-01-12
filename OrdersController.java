
import java.util.ArrayList;


public class OrdersController {
     private OrdersModel model;
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
   
   public void setDate(String Date){
      model.setDate(Date);		
   }

   public String getDate(){
      return model.getDate();		
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
    
    public void setItems(ArrayList<Integer> Items) {
        model.setItems(Items);
    }
    
    public ArrayList<Integer> getItems() {
        return model.getItems();
    }

    public void addItem(int ItemId) {
        model.addItem(ItemId);
    }
    
    public void removeItem(int ItemId){
        model.removeItem(ItemId);
    }
 

    public void setIsAdmin(boolean IsAdmin) {
        model.setIsAdmin(IsAdmin);
    }

    public boolean getIsAdmin() {
        return model.getIsAdmin();
    }
    
    public void setIsBanned(boolean IsBanned) {
        model.setIsBanned(IsBanned);
    }

    public boolean getIsBanned() {
        return model.getIsBanned();
    }
 
}
