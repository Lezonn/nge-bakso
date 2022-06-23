package model;

import java.util.ArrayList;
import java.util.Arrays;

public class MainCourse extends Menu implements Upgradeable {
    private String Carbo;
    private String MeatBallType;

	public MainCourse(Integer iD, String name, Integer price, String description, Integer portion, String carbo,
			String meatBallType) {
		super(iD, name, price, description, portion);
		Carbo = carbo;
		MeatBallType = meatBallType;
	}

	public String getCarbo() {
		return Carbo;
	}

	public void setCarbo(String carbo) {
		Carbo = carbo;
	}

	public String getMeatBallType() {
		return MeatBallType;
	}

	public void setMeatBallType(String meatBallType) {
		MeatBallType = meatBallType;
	}

	public void increasePrice(Integer price){
		price += 15000;
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
				this.getDescription(),"Main Course", "-", 
				this.getCarbo(), this.getMeatBallType(), "-")
			);
	}
}
