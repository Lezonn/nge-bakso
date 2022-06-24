package helper;

import java.util.ArrayList;
import java.util.Arrays;

import model.Menu;

public class PrintMenuHelper {
	public static void PrintMenu(ArrayList<Menu> menus) {
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
}
