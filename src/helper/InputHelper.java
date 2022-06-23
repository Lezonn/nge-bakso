package helper;

import java.util.ArrayList;
import java.util.Scanner;

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
