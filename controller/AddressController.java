package controller;

import com.syntel.Scenes.AddressView;
import model.Address;


public class AddressController {
   private Address model;
   private AddressView view;

   public AddressController(Address model, AddressView view){
      this.model = model;
      this.view = view;
   }

   public void setAddressId(int Id){
      model.setAddressId(Id);		
   }

   public int getAddressId(){
      return model.getAddressId();		
   }

   public void setStreet(String Street){
      model.setStreet(Street);		
   }

   public String getStreet(){
      return model.getStreet();		
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

}
