package model;

public class TransactionDetail {
	private Menu menu;
	private Integer quantity;
	private String size;
	
	public TransactionDetail(Menu menu, Integer quantity, String size) {
		super();
		this.menu = menu;
		this.quantity = quantity;
		this.size = size;
	}

	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
}
