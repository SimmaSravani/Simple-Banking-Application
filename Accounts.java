package SimpleBankingApplication;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Accounts {
	static Scanner sc=new Scanner(System.in);
	static int balance, accno;
	public static void createaccount() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Sravani@123");
			 Statement st=con.createStatement();
			 Scanner sc=new Scanner(System.in);
			 System.out.println("*** Enter Account Details ***");
			 System.out.println("Enter Account Number");
			 accno=sc.nextInt();
			 System.out.println("Enter First Name");
			 String firstn=sc.next();
			 System.out.println("Enter Last Name");
			 String lastn=sc.next();
			 System.out.println("Enter Gender (f/m)");
			 String gender=sc.next();
			 System.out.println("Enter Age");
			 int age=sc.nextInt();
			 System.out.println("Enter Phone Number");
			 String phonen=sc.next();
			 System.out.println("Enter Address");
			 String address=sc.next();
			 System.out.println("Enter Amount");
			 balance=sc.nextInt();
			 String sql="insert into bankaccounts2 values("+accno+",'"+firstn+"','"+lastn+"','"+gender+"',"+age+",'"+phonen+"',"+balance+",'"+address+"')";
			 st.executeUpdate(sql);
			 System.out.println("Yours Account Created Successfully");
			 System.out.println("**".repeat(30));
			 
			 
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
				
		 catch(Exception e) {
			 System.out.println(e);
			 System.out.println("**".repeat(30));
		 }
	
		
	}
	
	public static void deposit() {
		int acc, bal=0;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Sravani@123");
			 Statement st=con.createStatement();
			 Scanner sc=new Scanner(System.in);
			 
			 System.out.println("Enter Account Number ");
			 acc=sc.nextInt();
			 System.out.println("Enter Deposit Amount");
			 bal=sc.nextInt();
			 if(bal<=0) {
				 System.out.println("Deposited Amount Should be Greater than 0 ");
				 System.out.println("**".repeat(30));
			     
			 }
			 else {
				 String sql="select balance from bankaccounts2 where accno="+acc+" "; 
				 ResultSet rs=st.executeQuery(sql);
				  if(rs.next()){
					 int prevbalance=rs.getInt("balance");
					
					 int currentbal=prevbalance+bal;
					 String innewbal="update bankaccounts2 set balance="+currentbal+" where accno="+acc+" ";
					 st.executeUpdate(innewbal);
					 System.out.println("Deposit Sccussfully");
					 System.out.println("Your Current Balance is : "+ currentbal); 
				 }
				  else {
						 System.out.println("Account Number Incorrect");
						 
					 }
			 }
			 System.out.println("-".repeat(30));
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
		
		 catch(Exception e) {
			 System.out.println(e);
			 System.out.println("**".repeat(30));
			 
		 }
			
	}
	
	public static void withdraw() {
	    int acct;
		int witha;
	
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Sravani@123");
			 Statement st=con.createStatement();
			 System.out.println("Enter Account Number ");
			 acct=sc.nextInt();
			 System.out.println("Enter Withdraw  Amount");
			 witha=sc.nextInt();
			 if(witha<=0) {
				 System.out.println("Deposited Amount Should be Greater than 0 ");
			     
			 }
			 else {
				 String sql="select balance from bankaccounts2 where accno="+acct+" "; 
				 ResultSet rs=st.executeQuery(sql);
				  if(rs.next()){
					 int prevbalance=rs.getInt("balance");
					 if(prevbalance<witha) {
						 System.out.println("Your Amount not Sufficent to Withdraw");
						 
					 }
					 else {
						 int currentbal=prevbalance-witha;
						 String updatedbal="update bankaccounts2 set balance="+currentbal+" where accno="+acct+" ";
						 st.executeUpdate(updatedbal);
						 System.out.println("Withdraw Sccussfully");
						 System.out.println("Your Current Balance is : "+ currentbal);
						 
						 
					 } 
				 }
				  else {
						 System.out.println("Account Number Incorrect");
						 
					 }
 
			 }
			 System.out.println("-".repeat(30));
			 }
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
		catch(Exception e) {
				 System.out.println(e);
				 
			 }	 		 
	}	
	
	
	public static void checkBalance() {
	       int viewbal;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Sravani@123");
			 Statement st=con.createStatement();
			 System.out.println("Enter Account Number ");
			 accno=sc.nextInt();
			 String sql="select * from bankaccounts2 where accno="+accno+" "; 
			 ResultSet rs=st.executeQuery(sql);
			 if(rs.next()) {
				 System.out.println("Name     : "+( rs.getString(2)+" "+rs.getString(3))+"\n"+"Balance  :"+" "+rs.getString(7));
				 
			 }
			 System.out.println("-".repeat(30));
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void diplayAccountholerDetails() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Sravani@123");
			 Statement st=con.createStatement();
			 System.out.println("Enter Account Number ");
			 accno=sc.nextInt();
			 String sql="select * from bankaccounts2 where accno="+accno+" "; 
			 ResultSet rs=st.executeQuery(sql);
			 if(rs.next()) {
				 System.out.println("Account Number  : "+rs.getString(1)+"\n"+"Name"+" ".repeat(12)+": "+(rs.getString(2)+" "+rs.getString(3))+"\n"+"Gender"+" ".repeat(10)+": "+rs.getString(4)+"\n"+"Age"+" ".repeat(13)+": "+rs.getString(5)+"\n"+"Phone Number"+" ".repeat(4)+": "+rs.getString(6)+"\n"+"Balance"+" ".repeat(9)+": "+rs.getString(7)+"\n"+"Address"+" ".repeat(9)+": "+rs.getString(8)+" ");
				 
			 } 
			 else {
				 System.out.println("Your Account Not Found");
			 }
			 System.out.println("-".repeat(30));
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void closeAccount() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Sravani@123");
			 Statement st=con.createStatement();
			 System.out.println("Enter Account Number ");
			 accno=sc.nextInt();
			 String sqls="select firstn from bankaccounts2 where accno="+accno+" "; 
			 ResultSet getname=st.executeQuery(sqls);
			 if(getname.next()) {
				 String s="delete from bankaccounts2 where accno="+accno+" ";
				  st.executeUpdate(s);
				  System.out.println("Your Account Closed Successfully");
	 
			 }
			 System.out.println("-".repeat(30));
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}