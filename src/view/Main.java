package view;

import helper.InputHelper;

public class Main {

	public Main() {
		
		int input;
		boolean isRun = true;
		
		do{
			MainMenu();
			input = InputHelper.InputInteger(">> ", 1, 3);
			
			if(input == 1){
				new FoodMenu();	
			}
			else if(input == 2){
				new TransactionMenu();
			}
			else if(input == 3){
				isRun = false;
			}
		}while(isRun);
			
	}

	public static void main(String[] args) {
		new Main();
	}
	
	private void MainMenu(){
		System.out.println("Welcome To Nge-Bakso !");
		System.out.println("======================");
		System.out.println("1. Food Menu");
		System.out.println("2. Transaction Menu");
		System.out.println("3. Exit");
	}
}
