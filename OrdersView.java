
import java.util.ArrayList;


public class OrdersView {
    public void printOrders(int OrderId, int UserId, int AddressId, String PaymentMethod, String oDate, String dDate, String Time, float Price, ArrayList<FoodItem> Items){
      System.out.println("Order Numer: "+ OrderId);
      System.out.println("For User: " + UserId);
      System.out.println("To Address: " + AddressId);
      System.out.println("Payment Method: " + PaymentMethod);
      System.out.println("Ordered On: " + oDate);
      System.out.println("Scheduled for Delivery On: " + dDate + " at " + Time);
      System.out.println("Price: $" + Price);
      System.out.println("Items: ");
      for(int i=0; i<Items.size(); i++){
          System.out.println(Items.get(i));
      }
    }
      
      
}
