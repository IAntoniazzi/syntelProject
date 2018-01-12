
public class FoodItem {
    private int FoodItemId;
    private String Name;
    private String Description;
    private float Price;
    private String Type;
    private boolean IsVeg;
    private String Image;
    private int Availability

    public FoodItem(int id, string name, string description, float price, string type, boolean veg; string image, int availability){
        this.FoodItemId = id;
        this.Name = name;
        this.Description = description;
        this.Price = price;
        this.Type = type;
        this.IsVeg = veg;
        this.Image = image;
        this.Availability = availability;
    }
    
    public int getFoodItemId() {
        return FoodItemId;
    }

    public void setFoodItemId(int FoodItemId) {
        this.FoodItemId = FoodItemId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public boolean getIsVeg() {
        return IsVeg;
    }

    public void setIsVeg(boolean IsVeg) {
        this.IsVeg = IsVeg;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    
    public int getAvailability(){
        return Availability;
    }
    
    public void setAvailability(int Availability){
        this.Availability = Availability;
    }
    
}


