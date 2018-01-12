
public class AddressController {
   private AddressModel model;
   private AddressView view;

   public AddressController(AddressModel model, AddressView view){
      this.model = model;
      this.view = view;
   }

   public void setAddressId(int Id){
      model.setAddressId(Id);		
   }

   public int getAddressId(){
      return model.getAddressId();		
   }

   public void setStreet1(String Street1){
      model.setStreet1(Street1);		
   }

   public String getStreet1(){
      return model.getStreet1();		
   }
   
   public void setStreet2(String Street2) {
        model.setStreet2(Street2);
    }
   
   public String getStreet2() {
        return model.getStreet2();
    }

    public  void setCity(String City) {
        model.setCity(City);
    }
    
    public  String getCity() {
        return model.getCity();
    }

    public void setState(String State) {
        model.setState(State);
    }


    public String getState() {
        return model.getState();
    }


    public void setZip(String Zip) {
        model.setZip(Zip);
    }

    public String getZip() {
        return model.getZip();
    }

    public void setIsDeliverable(boolean IsDeliverable) {
        model.setIsDeliverable(IsDeliverable);
    }
    
    public boolean IsDeliverable() {
        return model.getIsDeliverable();
    }

}
