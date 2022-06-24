package model;

import java.util.ArrayList;
import java.util.Arrays;

public class MainCourse extends Menu implements Upgradeable {
    private String Carbo;
    private String MeatBallType;

	public MainCourse(Integer iD, String name, Integer price, String description, String size, String carbo,
			String meatBallType) {
		super(iD, name, price, description, size);
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


	@Override
	public void IncreasePrice() {
		Integer upgrade = this.getPrice() / 2;
		this.setPrice(this.getPrice() + upgrade);
	}

	@Override
	public void UpSize() {
		this.setSize("Sharing");
		
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
