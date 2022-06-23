package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Dessert extends Menu implements Upgradeable {
    private String Topping;
    
	public Dessert(Integer iD, String name, Integer price, String description, Integer portion, String topping) {
		super(iD, name, price, description, portion);
		Topping = topping;
	}

	public String getTopping() {
		return Topping;
	}

	public void setTopping(String topping) {
		Topping = topping;
	}

	public void increasePrice(Integer price){
		price += 20000;
	}

	public void increasePortion(Integer portion){
		portion += 1;
	}

	@Override
	public void increasePrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increasePortion() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<String> GetMenuDetailString(Integer num) {
		return new ArrayList<String>(Arrays.asList(
				num.toString(), this.getName(), this.getPrice().toString(), 
				this.getDescription(), "Dessert", "-" , "-", "-", this.getTopping())
			);
	}
}
