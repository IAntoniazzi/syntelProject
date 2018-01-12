package com.syntel.Scenes;

import java.util.ArrayList;
import java.util.List;

import com.syntel.DatabaseAction;

public class UserManagementScene extends Scene {
	
	private String email;
	private boolean delete = false;
	private boolean ban = false;
	private boolean unban = false;
	private boolean changePwd = false;
	
	
	@Override
	public Scene transitionNext() {
		
		System.out.println("Email entered: "+email);
		
		switch(selectedChoice) {
		
			case "Delete User":
				System.out.println("Deleteing user!");
				break;
				
			case "Ban User":
				System.out.println("Banning user!");
				break;
				
			case "Unban User":
				System.out.println("Unbanning user!");
				break;
				
			case "Change User Password":
				System.out.println("Changing pwd!");
				break;
			case "Back":
				return new HomeScene();
				
				
		}
		
				
		return new UserManagementScene();
		
	}
	
	
	@Override
	public void process() {
		List<String> choices = new ArrayList<>();
		
		choices.add("Delete User");
		choices.add("Ban User");
		choices.add("Unban User");
		choices.add("Change User Password");
		choices.add("Back");
		
		do {
			for(int i=0;i<choices.size();i++) {
				System.out.println("(" + (i) + ")" +" "+ choices.get(i));
			}
			
			selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);
			
		}while(selectedChoice == null);
		
		if(!selectedChoice.equals("Back")){
			System.out.print("Enter User Email Address: ");				
			email = scanner.nextLine();	
		}
		
		
		requestTransition = true;
		
		
	}

}
