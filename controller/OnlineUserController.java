package controller;


import com.syntel.Scenes.OnlineUserView;
import com.syntel.Models.OnlineUser;

public class OnlineUserController {
   
   private OnlineUser model;
   private OnlineUserView view;

   public OnlineUserController(OnlineUser model, OnlineUserView view){
      this.model = model;
      this.view = view;
   }

   public void setOnlineUserId(byte[] Id){
      model.setUserId(Id);		
   }

   public byte[] getOnlineUserId(){
      return model.getUserId();		
   }

   public void setFirstName(String FirstName){
      model.setFirstName(FirstName);		
   }

   public String getFirstName(){
      return model.getFirstName();		
   }
   
   public void setLastName(String LastName){
      model.setLastName(LastName);		
   }

   public String getLastName(){
      return model.getLastName();		
   }
   
   public void setEmail(String Email) {
        model.setEmail(Email);
    }
   
   public String getEmail() {
        return model.getEmail();
    }

   public void setPassword(String Password) {
        model.setPassword(Password);
    }

    public String getPassword() {
        return model.getPassword();
    }
    
    public void setPhone(String Phone) {
        model.setPhone(Phone);
    }
    
    public String getPhone() {
        return model.getPhone();
    }

    public void setAddressId(byte[] AddressId) {
        model.setAddressId(AddressId);
    }
    
    public byte[] getAddressId() {
        return model.getAddressId();
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
