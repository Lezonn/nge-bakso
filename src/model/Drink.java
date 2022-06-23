package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Drink extends Menu {
    private Boolean IsCold;

	public Drink(Integer iD, String name, Integer price, String description, Integer portion, Boolean isCold) {
		super(iD, name, price, description, portion);
		IsCold = isCold;
	}

	public Boolean getIsCold() {
		return IsCold;
	}

	public void setIsCold(Boolean iscold) {
		IsCold = iscold;
	}
    
	@Override
	public ArrayList<String> GetMenuDetailString(Integer num) {
		return new ArrayList<String>(Arrays.asList(
				num.toString(), this.getName(), this.getPrice().toString(), 
				this.getDescription(), "Drink",
				this.IsCold == true ? "Yes" : "No", "-", 
				"-", "-")
			);
	}
}
