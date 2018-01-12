
import java.util.ArrayList;


public class OrdersView {
    public void printOrders(int OrderId, int UserId, int AddressId, String PaymentMethod, String Date, String Time, float Price, ArrayList<Integer> Items){
      System.out.println("Order Numer: "+ OrderId);
      System.out.println("For User: " + UserId);
      System.out.println("To Address: " + AddressId);
      System.out.println("Payment Method: " + PaymentMethod);
      System.out.println("On: " + Date + " at " + Time);
      System.out.println("Price: $" + Price);
      System.out.println("Items: ");
      for(int i=0; i<Items.size(); i++){
          System.out.println(Items.get(i));
      }
    }
      
      
}
