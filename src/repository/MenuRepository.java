package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Dessert;
import model.Drink;
import model.MainCourse;
import model.Menu;

public class MenuRepository {
	Connect con = Connect.getConnection();
	
	public void InsertDrink(Drink drink) {
		String query = "INSERT INTO drink VALUES (?, ?, ?, ?, ?, ?)";
				
		PreparedStatement ps = con.prepareStatement(query);
		Integer ID = GetLatestId() + 1;
		try {
			ps.setInt(1, ID);
			ps.setString(2, drink.getName());
			ps.setInt(3, drink.getPrice());
			ps.setString(4, drink.getDescription());
			ps.setInt(5, drink.getPortion());
			ps.setBoolean(6, drink.getIsCold());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void InsertMainCourse(MainCourse mainCourse) {
		String query = "INSERT INTO maincourse VALUES (?, ?, ?, ?, ?, ?, ?)";
				
		PreparedStatement ps = con.prepareStatement(query);
		
		Integer ID = GetLatestId() + 1;
		try {
			ps.setInt(1, ID);
			ps.setString(2, mainCourse.getName());
			ps.setInt(3, mainCourse.getPrice());
			ps.setString(4, mainCourse.getDescription());
			ps.setInt(5, mainCourse.getPortion());
			ps.setString(6, mainCourse.getCarbo());
			ps.setString(7, mainCourse.getMeatBallType());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InsertDessert(Dessert dessert){
		String query = "INSERT INTO dessert VALUES (?, ?, ?, ?, ?, ?)";
				
		PreparedStatement ps = con.prepareStatement(query);
		Integer ID = GetLatestId() + 1;
		try {
			ps.setInt(1, ID);
			ps.setString(2, dessert.getName());
			ps.setInt(3, dessert.getPrice());
			ps.setString(4, dessert.getDescription());
			ps.setInt(5, dessert.getPortion());
			ps.setString(6, dessert.getTopping());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Menu> LoadMenu(){
		ArrayList<Menu> menus = new ArrayList<>();
		
		menus.addAll(LoadDrinks());
		menus.addAll(LoadMainCourse());
		menus.addAll(LoadDessert());
		
		return menus;
	}
	
	private ArrayList<Drink> LoadDrinks() {
		
		ArrayList<Drink> drink = new ArrayList<>();
		String query = "SELECT * FROM drink";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = null;
		
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				drink.add(new Drink(
						rs.getInt("ID"), 
						rs.getString("Name"), 
						rs.getInt("Price"),
						rs.getString("Description"), 
						rs.getInt("Portion"), 
						rs.getBoolean("IsCold")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return drink;
	}
	
	private ArrayList<MainCourse> LoadMainCourse() {
		ArrayList<MainCourse> maincourses = new ArrayList<MainCourse>();
		
		String query = "SELECT * FROM maincourse";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = null;
		
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				maincourses.add(new MainCourse(
						rs.getInt("ID"), 
						rs.getString("Name"), 
						rs.getInt("Price"),
						rs.getString("Description"), 
						rs.getInt("Portion"),
						rs.getString("Carbo"),
						rs.getString("MeatType")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maincourses;
	}
	
	private ArrayList<Dessert> LoadDessert() {
		ArrayList<Dessert> desserts = new ArrayList<Dessert>();
		
		String query = "SELECT * FROM dessert";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = null;
		
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				desserts.add(new Dessert(
						rs.getInt("ID"), 
						rs.getString("Name"), 
						rs.getInt("Price"),
						rs.getString("Description"), 
						rs.getInt("Portion"),
						rs.getString("Topping")
				)
				
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return desserts;
	}
	
	public void DeleteMenu(Menu menu){
		String query = "";
		
		if(menu instanceof Drink) {
			query = "DELETE FROM drink WHERE Name = ?";
		}
		else if(menu instanceof MainCourse) {
			query = "DELETE FROM maincourse WHERE NAME = ?";
		}
		else if(menu instanceof Dessert) {
			query = "DELETE FROM dessert WHERE NAME = ?";
		}
		
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, menu.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Integer GetLatestId() {
		Integer ID = 0;
		String queryDrink = "SELECT ID From drink "
				+ "UNION ALL "
				+ "SELECT ID From maincourse "
				+ "UNION ALL "
				+ "SELECT ID From dessert "
				+ "ORDER BY ID DESC LIMIT 1";
		
		ResultSet rs = con.executeQuery(queryDrink);
		
		try {
			while(rs.next()) {
				ID = rs.getInt("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ID;
	}
}
