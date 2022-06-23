package view;

import java.util.ArrayList;
import java.util.Arrays;

import factory.MenuFactory;
import helper.InputHelper;
import helper.TableHelper;
import model.Dessert;
import model.Drink;
import model.MainCourse;
import model.Menu;
import repository.MenuRepository;

public class FoodMenu {
	MenuRepository menuRepository = new MenuRepository();
	 
	public FoodMenu(){
		while(Run());
	}
	
	private boolean Run() {
		InputHelper.ClearScreen();
		PrintFoodMenu();
		int choice = InputHelper.InputInteger(">> ", 1, 4);
		
		InputHelper.ClearScreen();
		switch(choice){
			case 1 :
				InsertMenu();
				break;
			case 2:
				DeleteMenu();
				break;
			case 3:
				ViewMenu();
				break;
			case 4 :
				return false;
		}
		
		return true;
	}
	
	private void PrintMenu(ArrayList<Menu> menus) {
		TableHelper.PrintLine();
		
		TableHelper.PrintRow(new ArrayList<>(Arrays.asList(
					"No", "Name", "Price", 
					"Description", "Type","IsCold", 
					"Carbo", "MeatType", "Topping"))
				);
		
		TableHelper.PrintLine();
		
		int num = 1;
		
		for(Menu m : menus) {
			TableHelper.PrintRow(m.GetMenuDetailString(num++));
		}
		TableHelper.PrintLine();
	}

	private void ViewMenu(){
		ArrayList<Menu> listMenu = menuRepository.LoadMenu();
		
		if(checkListMenuIsEmpty(listMenu)) {
			return;
		}
		PrintMenu(listMenu);
		InputHelper.PressEnter();
	}
	
	private void DeleteMenu() {
		ArrayList<Menu> listMenu = menuRepository.LoadMenu();
		
		if(checkListMenuIsEmpty(listMenu)) {
			return;
		}
		PrintMenu(listMenu);
		
		int len = listMenu.size();
		int idx = InputHelper.InputInteger("Choose menu number to delete [1 - " + len + "]: ", 1, len);
		
		Menu menu = listMenu.get(idx-1);
		menuRepository.DeleteMenu(menu);
		
		System.out.println("Successfully delete menu !");
		InputHelper.PressEnter();
	}
	
	private boolean checkListMenuIsEmpty(ArrayList<Menu> listMenu){
		if(listMenu.isEmpty()) {
			System.out.println("There is no menu yet!");
			InputHelper.PressEnter();
			return true;
		}
		
		return false;
	}
	

	private void InsertMenu(){
		String choice = "";
		
		choice = InputHelper.InputStringWithCriteria
				("Choose Menu Type [Drink | Main Course | Dessert] (case sensitive): ", 
					new ArrayList<String>(Arrays.asList("Drink", "Main Course", "Dessert"))
				);
		
		String name, desc;
		Integer price;
		
		name = InputHelper.InputStringWithLen("Input Menu Name : ", 3, 50);
		price = InputHelper.InputInteger("Input Menu Price : ", 1, 1000000);
		desc = InputHelper.InputStringWithLen("Input Menu Description : ", 5, 100);
		
		Menu menu = MenuFactory.CreateMenu(name, price, desc, choice);
		
		if(choice.equals("Drink")){
			InsertDrink((Drink)menu);
		}
		else if(choice.equals("Main Course")){
			InsertMainCourse((MainCourse)menu);
		}
		else if(choice.equals("Dessert")){
			InsertDessert((Dessert)menu);
		}		
		
		System.out.println("Successfully insert menu !");
		InputHelper.PressEnter();
	}
	
	private void InsertDrink(Drink drink) {
		String IsCold;
		
		IsCold = InputHelper.InputStringWithCriteria
				("Do you want ice for your drink [Yes | No] (case sensitive) : ", 
					new ArrayList<String>(Arrays.asList("Yes", "No")));
		
		if(IsCold.equals("Yes")) 
			drink.setIsCold(true);
		else 
			drink.setIsCold(false);
		
		menuRepository.InsertDrink(drink);
	}
	
	private void InsertMainCourse(MainCourse mainCourse) {
		String carbo, meatType;
		
		carbo = InputHelper.InputStringWithCriteria
				("Choose your carbohidrat [Noodles | Rice Noodle | Kwetiau] (case sensitive) : ", 
					new ArrayList<String>(Arrays.asList("Noodles", "Rice Noodle" , "Kwetiau")));
					
		meatType = InputHelper.InputStringWithCriteria
				("Choose your meatball type [Chicken | Beef | Fish] (case sensitive) : ", 
					new ArrayList<String>(Arrays.asList("Beef", "Chicken" , "Fish")));
		
		mainCourse.setCarbo(carbo);
		mainCourse.setMeatBallType(meatType);
		menuRepository.InsertMainCourse(mainCourse);
	}
	
	private void InsertDessert(Dessert dessert) {
		String topping;
		
		topping = InputHelper.InputStringWithCriteria
				("Choose your topping [Sprinkles | Boba | Cheese] (case sensitive) : ",
					new ArrayList<String>(Arrays.asList("Sprinkles", "Boba" , "Cheese")));
	
		dessert.setTopping(topping);
		menuRepository.InsertDessert(dessert);
	}
	
	private void PrintFoodMenu(){
		System.out.println("Welcome To Food Menu!");
		System.out.println("======================");
		System.out.println("1. Create Menu");
		System.out.println("2. Delete Menu");
		System.out.println("3. View Menu");
		System.out.println("4. Exit");
	}
}
