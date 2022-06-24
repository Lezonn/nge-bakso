package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Dessert extends Menu implements Upgradeable {
    private String Topping;
    
	public Dessert(Integer iD, String name, Integer price, String description, String size, String topping) {
		super(iD, name, price, description, size);
		Topping = topping;
	}

	public String getTopping() {
		return Topping;
	}

	public void setTopping(String topping) {
		Topping = topping;
	}

	@Override
	public void IncreasePrice() {
        Integer upgrade = this.getPrice() / 2;
		this.setPrice(this.getPrice() + upgrade);
		
	}

	@Override
	public void UpSize() {
		this.setSize("Large");
		
	}
	
	@Override
	public ArrayList<String> GetMenuDetailString(Integer num) {
		return new ArrayList<String>(Arrays.asList(
				num.toString(), this.getName(), this.getPrice().toString(), 
				this.getDescription(), "Dessert", "-" , "-", "-", this.getTopping())
			);
	}
}
