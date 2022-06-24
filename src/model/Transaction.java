package model;

import java.sql.Date;
import java.util.ArrayList;

public class Transaction {
	private Integer ID;
	private String CustomerName;
	private Date TransactionDate; 
	private ArrayList<TransactionDetail> transactionDetail;
	private Integer TotalPrice;
	
	public Transaction(Integer iD, String customerName, Date transactionDate,
			ArrayList<TransactionDetail> transactionDetail, Integer TotalPrice) {
		ID = iD;
		CustomerName = customerName;
		TransactionDate = transactionDate;
		this.transactionDetail = transactionDetail;
		this.TotalPrice = TotalPrice;
	}

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String getCustomerName() {
		return CustomerName;
	}
	
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	public Date getTransactionDate() {
		return TransactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}

	public ArrayList<TransactionDetail> getTransactionDetail() {
		return transactionDetail;
	}

	public void setTransactionDetail(ArrayList<TransactionDetail> transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	public Integer getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		TotalPrice = totalPrice;
	}
	
	public void CountTotalPrice() {
		for(TransactionDetail td : transactionDetail) {
			TotalPrice += (td.getMenu().getPrice() * td.getQuantity());
		}
	}
}
