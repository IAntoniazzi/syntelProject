
import java.util.ArrayList;


public class Orders {
     private int OrderId;
    private int UserId;
    private int AddressId;
    private String PaymentMethod;
    private String Date;
    private String Time;
    private float Price;
    private ArrayList<Integer> Items;  //array of FoodItemIds
    
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
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
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

    public ArrayList<Integer> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Integer> Items) {
        this.Items = Items;
    }
    
    public void addItem(int ItemId){
        this.setItems(this.getItems().add(ItemId));
    }
    
    public void removeItem(int ItemId){
        this.setItems(this.getItems().remove(ItemId)); 
    }


}
