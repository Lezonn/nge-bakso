package view;

import java.util.ArrayList;
import java.util.Arrays;

import helper.InputHelper;
import helper.TableHelper;
import model.Dessert;
import model.Drink;
import model.MainCourse;
import model.Menu;
import model.Transaction;
import model.TransactionDetail;
import repository.MenuRepository;
import repository.TransactionRepository;

public class TransactionMenu {
	
	MenuRepository menuRepository = new MenuRepository();
	TransactionRepository transactionRepository = new TransactionRepository();
	
	public TransactionMenu(){
		while(Run());
	}
	
	private boolean Run() {
		InputHelper.ClearScreen();
		PrintTransactionMenu();
		
		int choice = InputHelper.InputInteger(">> ", 1, 3);
		
		InputHelper.ClearScreen();
		switch(choice){
			case 1 :
				CreateTransaction();
				break;
			case 2:
				ViewTransaction();
				break;
			case 3 :
				return false;
		}
		
		return true;
	}
	

	private void ViewTransaction(){
		ArrayList<Transaction> listTransactions = transactionRepository.LoadTransaction();
		
		if(listTransactions.isEmpty()){
			System.out.println("There Are No Transactions");
			InputHelper.PressEnter();
			return;
		}
		
		TableHelper.PrintLine();
		
		TableHelper.PrintRow(new ArrayList<>(Arrays.asList(
					"No", "Customer Name", 
					"Transaction Date", "Total Price"))
				);
		
		TableHelper.PrintLine();
		
		Integer num = 1;
			
		for(Transaction t : listTransactions) {
			TableHelper.PrintRow(new ArrayList<String>(
						Arrays.asList(num.toString(), t.getCustomerName(), 
								t.getTransactionDate().toString(), t.getTotalPrice().toString()))
					);
			num++;
		}
		TableHelper.PrintLine();
		int size = listTransactions.size();
		int index = InputHelper.InputInteger("Choose transaction number to see detail: ", 1, size);
		
		System.out.println();
		ViewTransactionDetail(listTransactions.get(index - 1));
		
		InputHelper.PressEnter();
	}
	
	private void ViewTransactionDetail(Transaction t) {
		System.out.println("Transaction Details");
		System.out.println("=================================================");
		
		for(TransactionDetail td : t.getTransactionDetail()){
			System.out.printf("Menu Name          : %s\n", td.getMenu().getName());
			System.out.printf("Menu Price         : %d\n", td.getMenu().getPrice());
			System.out.printf("Menu Quantity      : %d\n", td.getQuantity());
			System.out.printf("Menu Size          : %s\n", td.getSize());
			
			
			if(td.getMenu() instanceof Drink){
				String IsCold = ((Drink) td.getMenu()).getIsCold() == true ? "Yes" : "No";
				System.out.println("Is Cold            : " + IsCold);
			}
			else if(td.getMenu() instanceof MainCourse){
				System.out.println("Carbo              : " + ((MainCourse)td.getMenu()).getCarbo());
				System.out.println("Meat Ball Type     : " + ((MainCourse)td.getMenu()).getMeatBallType());
			}
			else if(td.getMenu() instanceof Dessert){
				System.out.println("Topping            : " + ((Dessert)td.getMenu()).getTopping());
			}
			
			System.out.println();
		}
	}
	
	private void CreateTransaction(){
		
		ArrayList<Menu> listMenu = menuRepository.LoadMenu();
		
		if(checkListMenuIsEmpty(listMenu)) {
			return;
		}

		ArrayList<TransactionDetail> td = InputHelper.InputForCreateTransaction(listMenu);
		
		if(td.isEmpty()) {
			System.out.println("Transaction cancelled");
			InputHelper.PressEnter();
			return;
		}
		
		
		String customerName = InputHelper.InputStringWithLen("Input customer name: ", 3, 50);
		
		Transaction Transaction = new Transaction(0, customerName, null, td, 0);
		Transaction.CountTotalPrice();
		
		transactionRepository.InsertTransaction(Transaction);
		
		System.out.println("Transaction was successfully created");
		InputHelper.PressEnter();
	}

	private boolean checkListMenuIsEmpty(ArrayList<Menu> listMenu){
		if(listMenu.isEmpty()) {
			System.out.println("There is no menu yet!");
			InputHelper.PressEnter();
			return true;
		}
		
		return false;
	}
	
	private void PrintTransactionMenu(){
		System.out.println("Welcome To Transaction Menu!");
		System.out.println("======================");
		System.out.println("1. Create Transaction");
		System.out.println("2. View Transaction");
		System.out.println("3. Exit");
	}
}
