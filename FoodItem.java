
public class FoodItem {
    private static int FoodItemId;
    private static String Name;
    private static String Description;
    private static float Price;
    private static String Type;
    private static boolean IsVeg;
    private static String Image;

    public static int getFoodItemId() {
        return FoodItemId;
    }

    public static void setFoodItemId(int FoodItemId) {
        FoodItem.FoodItemId = FoodItemId;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String Name) {
        FoodItem.Name = Name;
    }

    public static String getDescription() {
        return Description;
    }

    public static void setDescription(String Description) {
        FoodItem.Description = Description;
    }

    public static float getPrice() {
        return Price;
    }

    public static void setPrice(float Price) {
        FoodItem.Price = Price;
    }

    public static String getType() {
        return Type;
    }

    public static void setType(String Type) {
        FoodItem.Type = Type;
    }

    public static boolean isIsVeg() {
        return IsVeg;
    }

    public static void setIsVeg(boolean IsVeg) {
        FoodItem.IsVeg = IsVeg;
    }

    public static String getImage() {
        return Image;
    }

    public static void setImage(String Image) {
        FoodItem.Image = Image;
    }
    
}
