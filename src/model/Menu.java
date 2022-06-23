package model;

import java.util.ArrayList;

public abstract class Menu {
	private Integer ID;
	private String Name;
	private Integer Price;
	private String Description;
	private Integer Portion;
	
	public Menu(Integer iD, String name, Integer price, String description, Integer portion) {
		ID = iD;
		Name = name;
		Price = price;
		Description = description;
		Portion = portion;
	}
	
	public abstract ArrayList<String> GetMenuDetailString(Integer num);

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public Integer getPrice() {
		return Price;
	}
	
	public void setPrice(Integer price) {
		Price = price;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public Integer getPortion() {
		return Portion;
	}
	
	public void setPortion(Integer portion) {
		Portion = portion;
	}
	
	
}
