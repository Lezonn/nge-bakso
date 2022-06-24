# Nge-bakso
-  Tema Projek : Restoran Bakso, di mana menunya terdiri dari MainCourse, Dessert dan Drink.
   Ketiga menu di atas merupakan child class dari sebuah abstract class "Menu". Dalam aplikasi
   ini terdapat fitur untuk melakukan CRUD Menu ke dalam database. Selain itu, di aplikasi
   ini juga bisa menambahkan dan melihat transaksi yang terjadi di restoran bakso.

- Penggunaan Interface "Upgradeable" di-implements pada class MainCourse dan Dessert
   Di mana fungsi interfacenya adalah untuk mengupgrade size dan harga ketika user memilih untuk 
   upsize pada class MainCourse ataupun Dessert.
	   
- Terdapat 5 packages pada project ini yaitu :
	- View <br>
    -> Berisikan file Main, FoodMenu (CRUD Menu), dan TransactionMenu (CRUD Transaction)

	- Repository <br>
			-> Berisikan file Connect (untuk connect dengan database)<br>
      -> Berisikan file MenuRepository, dimana terdapat function untuk insert, delete 
			   dan select data dari database. File ini berisikan query-query SQL database.<br>
			-> Berisikan file TransactionRepository, dimana terdapat function untuk insert, delete
			   dan select data dari database. File ini berisikan query-query SQL database.<br>
		
	- Model <br>
			-> Berisi class untuk menampung data dari entity-entity di database.<br>
			-> Di setiap class entitas ini menerapkan encapsulation, di mana fieldnya private
			   dan di akses melalui getter dan setter.<br>

	- Helper  <br>
			-> Berisikan function-function yang sering digunakan untuk merapikan code dalam projek ini,
			   seperti untuk membantu proses input beserta validasinya dan proses print dalam bentuk tabel.
		
	- Factory <br>
			-> Berisikan MenuFactory yang berguna untuk membantu pembuatan object Menu dalam
			   project ini.
	
- Design Pattern
	- Singleton <br>
			-> Penggunaanya pada packages Repository, file Connect, di mana pada file ini terdapat
			   penggunaan design pattern Singleton, sehingga pembuatan objek Connect hanya dilakukan sekali.
	- Factory <br>
			-> Kami menggunakan design pattern factory di project ini untuk membantu pembuatan object
			   Menu yang memiliki 3 child class.
         
## Tools
- Eclipse IDE 2020-06
- JAVA 8
- XAMPP
- MySql

## Authors
| Name                            | NIM        | Class                               |
| :-----------------------------  | :--------- | :---------------------------------- |
| Leonard Zonaphan                | 2440035791 | Object Oriented Programming - LG01  |
| Jonathan Wijaya                 | 2440040066 | Object Oriented Programming - LG01  |
| Karin Northus                   | 2440062086 | Object Oriented Programming - LG01  |
| Alvin Lie                       | 2440028615 | Object Oriented Programming - LG01  |
