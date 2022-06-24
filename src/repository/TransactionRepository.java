package repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Dessert;
import model.Drink;
import model.MainCourse;
import model.Menu;
import model.Transaction;
import model.TransactionDetail;

public class TransactionRepository {
	
	Connect con = Connect.getConnection();
	
	public ArrayList<Transaction> LoadTransaction() {
		String query = "SELECT * FROM TRANSACTION";
		
		ResultSet rs = con.executeQuery(query);
		
		ArrayList<Transaction> transactions = new ArrayList<>();
		try {
			while(rs.next()) {
				
				Integer ID = rs.getInt("ID");
				
				Transaction t = new Transaction(ID, rs.getString("CustomerName"), 
						rs.getDate("TransactionDate"), null, rs.getInt("TotalPrice"));	
				
				transactions.add(t);

			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Transaction t : transactions) {
			ArrayList<TransactionDetail> tds = new ArrayList<>();
			tds.addAll(GetTransactionDetail(t.getID(), "dessert"));
			tds.addAll(GetTransactionDetail(t.getID(), "drink"));
			tds.addAll(GetTransactionDetail(t.getID(), "maincourse"));
			
			t.setTransactionDetail(tds);
		}
		
		return transactions;
	}
	
	private ArrayList<TransactionDetail> GetTransactionDetail(Integer ID, String menuType) {
		ArrayList<TransactionDetail> tds = new ArrayList<>();
		
		String query = "SELECT * FROM transactiondetail td "
						+ "JOIN " + menuType + " m ON td.MenuID = m.ID "
						+ "WHERE td.TransactionID = " + ID;
		
	
		ResultSet rs = con.executeQuery(query);

		
		try {
			while(rs.next()) {
				Menu menu = null;
				if(menuType.equals("dessert")) {
					menu = new Dessert(0, rs.getString("Name"), 
							rs.getInt("Price"), rs.getString("Description"), 
							rs.getString("Size"), rs.getString("Topping"));
				}
				else if(menuType.equals("drink")) {
					menu = new Drink(0, rs.getString("Name"), rs.getInt("Price"),
							rs.getString("Description"), rs.getString("Size"),
							rs.getBoolean("IsCold"));
				}
				else {
					menu = new MainCourse(0, rs.getString("Name"), rs.getInt("Price"),
							rs.getString("Description"), rs.getString("Size"), rs.getString("Carbo"), 
							rs.getString("MeatType") );	
					
				}
				
			
				TransactionDetail td = new TransactionDetail(menu, rs.getInt("Quantity"), rs.getString("Size"));
				tds.add(td);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tds;
	}
	
	public void InsertTransaction(Transaction transaction) {
		String query = "INSERT INTO transaction VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		transaction.setID(GetLatestTransactionID() + 1);
		try {
			ps.setInt(1, transaction.getID());
			ps.setString(2, transaction.getCustomerName());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setInt(4, transaction.getTotalPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InsertTransactionDetail(transaction);
	}
	
	private void InsertTransactionDetail(Transaction transaction) {
		for(TransactionDetail td : transaction.getTransactionDetail()){
			String query = "INSERT INTO transactiondetail VALUES (?, ?, ?, ?)";
		
			PreparedStatement ps = con.prepareStatement(query);
			try {
				ps.setInt(1, transaction.getID());
				ps.setInt(2, td.getMenu().getID());
				ps.setInt(3, td.getQuantity());
				ps.setString(4, td.getMenu().getSize());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Integer GetLatestTransactionID() {
		String query = "SELECT ID FROM transaction ORDER BY ID DESC LIMIT 1";
		
		ResultSet rs = con.executeQuery(query);
		
		Integer ID = 0;
		
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
