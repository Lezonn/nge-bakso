package factory;

import model.Dessert;
import model.Drink;
import model.MainCourse;
import model.Menu;

public class MenuFactory {
	
	public static Menu CreateMenu(String name, Integer price, String desc, String size, String type) {
		if(type.equalsIgnoreCase("Drink")) {
			return new Drink(0, name, price, desc, size, null);
		}
		else if(type.equalsIgnoreCase("Main Course")) {
			return new MainCourse(0, name, price, desc, size, null, null); 
		}
		else if(type.equalsIgnoreCase("Dessert")) {
			return new Dessert(0, name, price, desc, size, null);
		}
		return null;
	}
	
}
