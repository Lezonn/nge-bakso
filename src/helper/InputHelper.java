package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Dessert;
import model.MainCourse;
import model.Menu;
import model.TransactionDetail;
import model.Upgradeable;

public class InputHelper {
	private static Scanner scan = new Scanner(System.in);

	public static Integer InputInteger(String msg, int low, int high) {
		int input = 0;
		
		do {
			try {
				System.out.print(msg);
				input = scan.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			scan.nextLine();
		} while(input < low || input > high);
		
		return input;
	}
	
	public static String InputStringWithLen(String msg, int low, int high) {
		String input = "";
		
		do {
			System.out.print(msg);
			input = scan.nextLine();
		} while(input.length() < low || input.length() > high);
		
		return input;
	}
	
	public static String InputStringWithCriteria(String msg, ArrayList<String> criteria) {
		String input = "";
		boolean loop = true;
		int critLen = criteria.size();
		
		do
		{
			loop = true;
			System.out.print(msg);
			input = scan.nextLine();

			for (int i = 0; i < critLen; i++)
			{
				if (input.equals(criteria.get(i)))
				{
					loop = false;
					break;
				}
			}

		} while (loop);
		
		return input;
	}
	
	public static ArrayList<TransactionDetail> InputForCreateTransaction(ArrayList<Menu> listMenu){
		ArrayList<TransactionDetail> listMenuTransaction = new ArrayList<>();
		
		Integer choice = -1;
		
		
		
		do{
			int len = listMenu.size();
			
			if(len == 0) {
				break;
			}
			PrintMenuHelper.PrintMenu(listMenu);
			
			
			choice = InputInteger("Input menu number [1 - " + len + " | '0' to finish] : ", 0, len);
			
			if(choice == 0) {
				break;
			}
			
			int qty = InputIntegerMoreThanZero("Input quantity must be greater than 0 : ");
			
			Menu menu = listMenu.get(choice-1);
			
			String input;
			if(listMenu.get(choice-1) instanceof MainCourse || listMenu.get(choice-1) instanceof Dessert){
				input = InputStringWithCriteria
				("Do you want to upgrade your size to large [Yes | No] (case sensitive) : ", 
					new ArrayList<String>(Arrays.asList("Yes", "No")));
				 
					if(input.equals("Yes")){
						((Upgradeable) menu).UpSize();
						((Upgradeable) menu).IncreasePrice();
					}
			}
			
			TransactionDetail temp = new TransactionDetail(menu, qty, menu.getSize());
			
			listMenuTransaction.add(temp);
			listMenu.remove(choice - 1);

		}while(choice != 0);
		
		return listMenuTransaction;
	}
	
	public static Integer InputIntegerMoreThanZero(String msg) {
		int input = 0;
		
		do {
			try {
				System.out.print(msg);
				input = scan.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			scan.nextLine();
		} while(input <= 0);
		
		return input;
	}
	
	public static void ClearScreen() {
		for(int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}
	
	public static void PressEnter() {
		System.out.println("Press Enter to continue..");
		scan.nextLine();
	}
}
