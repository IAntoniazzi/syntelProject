
public class FoodItemView {
    public void printFoodItem(String Name, String Description, float Price,  String Type, boolean IsVeg, String Image, int Availability){
      System.out.println("Food Item: ");
      System.out.println(Name  + ": "+ Description);
      System.out.println("$" + Price+ " " + Type);
      if(IsVeg){
          System.out.println("This item is vegetarian");
      }
      System.out.println(Image);
      System.out.println("Available in: " + Availability;
   }
}
