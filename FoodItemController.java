
public class FoodItemController {
    private FoodItem model;
   private FoodItemView view;

   public FoodItemController(FoodItemModel model, FoodItemView view){
      this.model = model;
      this.view = view;
   }

   public void setFoodItemId(int Id){
      model.setFoodItemId(Id);		
   }

   public int getFoodItemId(){
      return model.getFoodItemId();		
   }

   public void setName(String Name){
      model.setName(Name);		
   }

   public String getName(){
      return model.getName();		
   }
   
   public void setDescription(String Description) {
        model.setDescription(Description);
    }
   
   public String getDescription() {
        return model.getDescription();
    }

    public  void setPrice(float Price) {
        model.setPrice(Price);
    }
    
    public float getPrice() {
        return model.getPrice();
    }

    public void setType(String Type) {
        model.setType(Type);
    }


    public String getType() {
        return model.getType();
    }


    public void setIsVeg(boolean IsVeg) {
        model.setIsVeg(IsVeg);
    }

    public boolean getIsVeg() {
        return model.getIsVeg();
    }

    public void setImage(String Image) {
        model.setImage(Image);
    }
    
    public String getImage() {
        return model.getImage();
    }
 
}
