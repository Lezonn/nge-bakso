package view;

import helper.InputHelper;

/*
	Anggota Kelompok :
	1) Leonard Zonaphan - 2440035791
	2) Jonathan Wijaya  - 2440040066
	3) Karin Northus    - 2440062086
	4) Alvin Lie        - 2440028615

	- Tema Projek : Restoran Bakso, di mana menunya terdiri dari MainCourse, Dessert dan Drink.
	   Ketiga menu di atas merupakan child class dari sebuah abstract class "Menu". Dalam aplikasi
	   ini terdapat fitur untuk melakukan CRUD Menu ke dalam database. Selain itu, di aplikasi
	   ini juga bisa menambahkan dan melihat transaksi yang terjadi di restoran bakso.

	- Penggunaan Interface "Upgradeable" di-implements pada class MainCourse dan Dessert
	   Di mana fungsi interfacenya adalah untuk mengupgrade size dan harga ketika user memilih untuk 
	   upsize pada class MainCourse ataupun Dessert.
	   
	- Terdapat 5 packages pada project ini yaitu :
		1.) View : 
			-> Berisikan file Main, FoodMenu (CRUD Menu), dan TransactionMenu (CRUD Transaction)

		2.) Repository : 
			-> Berisikan file Connect (untuk connect dengan database)
			   
			-> Berisikan file MenuRepository, dimana terdapat function untuk insert, delete 
			   dan select data dari database. File ini berisikan query-query SQL database.
			 
			-> Berisikan file TransactionRepository, dimana terdapat function untuk insert, delete 
			   dan select data dari database. File ini berisikan query-query SQL database.
		
		3.) Model :
			-> Berisi class untuk menampung data dari entity-entity di database.
			-> Di setiap class entitas ini menerapkan encapsulation, di mana fieldnya private
			   dan di akses melalui getter dan setter.

		4.) Helper : 
			-> Berisikan function-function yang sering digunakan untuk merapikan code dalam projek ini,
			   seperti untuk membantu proses input beserta validasinya dan proses print dalam bentuk tabel.
		
		5.) Factory :
			-> Berisikan MenuFactory yang berguna untuk membantu pembuatan object Menu dalam
			   project ini.
	
	- Design Pattern
		1.) Singleton
			-> Penggunaanya pada packages Repository, file Connect, di mana pada file ini terdapat
			   penggunaan design pattern Singleton, sehingga pembuatan objek Connect hanya dilakukan sekali.
		2.) Factory
			-> Kami menggunakan design pattern factory di project ini untuk membantu pembuatan object
			   Menu yang memiliki 3 child class.
	
	- Database Connection
		-> Pertama buat database bernama "ngebakso" di phpmyadmin.
		-> Lalu di database yang telah dibuat, import file 'ngebakso.sql'.
		-> Dan yang terakhir pastikan di file Connect variabel DATABASE memiliki value ngebakso.

*/


public class Main {

	public Main() {
		while(Run());
	}
	
	private boolean Run() {
		InputHelper.ClearScreen();
		MainMenu();
		int input = InputHelper.InputInteger(">> ", 1, 3);
		
		InputHelper.ClearScreen();
		if(input == 1){
			new FoodMenu();	
		}
		else if(input == 2){
			new TransactionMenu();
		}
		else if(input == 3){
			return false;
		}
		return true;
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
