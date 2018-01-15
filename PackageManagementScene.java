package com.syntel.Scenes;


import java.util.*;

import com.syntel.*;

public class PackageManagementScene extends Scene {
	
	private FoodItem fItem;
	private String userInput;
	private String name;
	private Float num;
	private int zip;
	private boolean valid;
	private PackageController controller;
	
	
	@Override
	public Scene transitionNext() {
		
		controller = new PackageController();
		fItem = new FoodItem();
		
		switch(selectedChoice) {
		
			//collect new food item fields from user
			case "Create New Food Item":
				
				System.out.println("Enter Name: ");
				userInput = scanner.nextLine();
				fItem.setName(userInput);
				
				System.out.println("Enter Description: ");
				userInput = scanner.nextLine();
				fItem.setDescription(userInput);
				
				valid = false;
				while(!valid) {
					try {
						System.out.println("Enter Price: ");
						num = scanner.nextFloat();
						scanner.nextLine();
						fItem.setPrice(num);
						valid = true;
					}catch(InputMismatchException e) {
						System.out.println("Please enter a number!");
						scanner.nextLine();
					}
				}
				
				
				System.out.println("Enter Type: ");
				userInput = scanner.nextLine();
				fItem.setType(userInput);
				
				System.out.println("Vegetarian? (yes/no): ");
				userInput = scanner.nextLine();
				fItem.setVeg(userInput);
				
				System.out.println("Image URL: ");
				userInput = scanner.nextLine();
				fItem.setImage(userInput);
				
				valid = false;
				while(!valid) {
					try {
						System.out.println("Zip Code: ");
						zip = scanner.nextInt();	
						scanner.nextLine();
						fItem.setZip(zip);							
						valid = true;
					}catch(InputMismatchException e) {
						System.out.println("Please enter a number!");
						scanner.nextLine();
					}
				}
				
				
				System.out.println("Start Time: ");
				userInput = scanner.nextLine();
				fItem.setBeginTime(userInput);				
				
				System.out.println("End Time: ");
				userInput = scanner.nextLine();
				fItem.setEndTime(userInput);
				
				System.out.println("Start Date: ");
				userInput = scanner.nextLine();
				fItem.setStartDate(userInput);
				
				System.out.println("End Date: ");
				userInput = scanner.nextLine();
				fItem.setEndDate(userInput);						
				
				controller.createNewItem(fItem);				
				
				System.out.println("Created: "+fItem);
				
				break;
				
			case "Update Existing Food Item":				
				System.out.print("Enter name of Food Item: ");
				name=scanner.nextLine();
				fItem.setName(name);
				controller.getFoodItem(fItem);	
				
				System.out.println("Retrieved Food Item: "+fItem);
				
				updateFood();						
				
				//to update the food item we first delete the old record then add a new one
				controller.deleteFoodItem(name);
				controller.createNewItem(fItem);	
				
				break;
				
			case "Delete Food Item":
				System.out.print("Enter name of Food Item: ");
				name = scanner.nextLine();
				controller.deleteFoodItem(name);
				break;				
						
			case "Back":
				return new HomeScene();			
				
		}		
				
		return new PackageManagementScene();
		
	}
	
	
	public void updateFood() {
		
		List<String> choices = new ArrayList<>();
		
		choices.add("Name");
		choices.add("Description");
		choices.add("Price");		
		choices.add("Type");
		choices.add("Veg (yes/no");
		choices.add("Zip");
		choices.add("Start Time");
		choices.add("End Time");
		choices.add("Start Date");
		choices.add("End Date");
		choices.add("Commit Changes");
		
		boolean commit = false;
		
		while(!commit) {
		
			do {
				System.out.println("SELCET FIELD TO EDIT");
				for(int i=0;i<choices.size();i++) {
					System.out.println("(" + (i) + ")" +" "+ choices.get(i));
				}
				
				selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);
				
			}while(selectedChoice == null);		
			
			switch(selectedChoice) {
				
				case "Name":
					System.out.print("Enter New Name: ");
					fItem.setName(scanner.nextLine());
					break;
				
				case "Description":
					System.out.print("Enter New Description: ");
					fItem.setDescription(scanner.nextLine());
					break;
					
				case "Price":
					
					valid = false;
					while(!valid) {
						try {
							System.out.print("Enter New Price: ");
							fItem.setPrice(scanner.nextFloat());
							valid = true;
							break;							
						}catch(InputMismatchException e) {
							System.out.println("Please enter a number!");
							scanner.nextLine();
						}
					}	
					
					
				case "Type":
					System.out.print("Enter New Type: ");
					fItem.setType(scanner.nextLine());
					break;
					
				case "Veg (yes/no":
					System.out.print("Enter New Veg (yes/no): ");
					fItem.setVeg(scanner.nextLine());
					break;
					
				case "Zip":
					valid = false;
					while(!valid) {
						try {
							System.out.print("Enter New Zip: ");
							fItem.setZip(scanner.nextInt());
							valid=true;
							break;													
						}catch(InputMismatchException e) {
							System.out.println("Please enter a number!");
							scanner.nextLine();
						}
					}	
					
				case "Start Time":
					System.out.print("Enter New Start Time: ");
					fItem.setBeginTime(scanner.nextLine());
					break;
					
				case "End Time":
					System.out.print("Enter New End Time: ");
					fItem.setEndTime(scanner.nextLine());
					break;
					
				case "Start Date":
					System.out.print("Enter New Start Date: ");
					fItem.setStartDate(scanner.nextLine());
					break;
					
				case "End Date":
					System.out.print("Enter New End Date: ");
					fItem.setEndDate(scanner.nextLine());
					break;
					
				case "Commit Changes":
					commit=true;
					break;				
					
			}
		}
	}
	
	@Override
	public void process() {
		
		List<String> choices = new ArrayList<>();
		
		choices.add("Create New Food Item");
		choices.add("Update Existing Food Item");
		choices.add("Delete Food Item");		
		choices.add("Back");
		
		do {
			for(int i=0;i<choices.size();i++) {
				System.out.println("(" + (i) + ")" +" "+ choices.get(i));
			}
			
			selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);
			
		}while(selectedChoice == null);		
			
		
		requestTransition = true;
		
		
	}
	
	
	
	
	

}
