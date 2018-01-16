package com.syntel.Scenes;


public class OnlineUserView {
    public void printOnlineUser(String FirstName, String LastName, String Email,  int AddressId, boolean IsAdmin, boolean IsBanned){
      System.out.println("Online User: ");
      System.out.println(FirstName  + " "+ LastName);
      System.out.println(Email + " " + "AddressId");
      if(IsAdmin){
          System.out.println("This user is an administrator");
      }
      if(IsBanned){
          System.out.println("This user is banned");
      }
   }
}
