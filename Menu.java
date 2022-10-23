package SimpleBankingApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Menu {
	public static void options() {
		Scanner sc=new Scanner(System.in);
			 int option1=0;
			
			 do {
				System.out.println("***  Choose One Option  ***");
				System.out.println("1. Create Account");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Check Balance");
				System.out.println("5. Display Account Holder Details");
				System.out.println("6. Close The Account");
				System.out.println("7. Exit");
				System.out.println("**".repeat(30));
				
				option1=sc.nextInt();
				
				switch(option1) {
				case 1:
					Accounts.createaccount();
					break;
					
				case 2:
					Accounts.deposit();
					break;
				case 3:
					Accounts.withdraw();
					break;
				case 4:
					Accounts.checkBalance();
					break;
				case 5:
					Accounts.diplayAccountholerDetails();
					break;
					
				case 6:
					Accounts.closeAccount();
					break;
				case 7:
					System.out.println("***   THANK YOU   ***");
					System.out.println("-".repeat(30));
					System.exit(0);
				}
				
				
			}while(option1<=7); 
	}
	

}