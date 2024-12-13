package com.atm;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

class ATM{
	float balance;
	int PIN=1232;
	
	public void checkPin() {
		System.out.println("ENTER YOUR PIN NUMBER : ");
		Scanner sc=new Scanner(System.in);
		int pin=sc.nextInt();
		if(PIN==pin) {
			menu();
		}else {
			System.out.println("ENTER VALID PIN");
			checkPin();
//			menu();
		}
	}
	public void menu() {
		System.out.println("ENTER YOUR CHOICE : ");
		System.out.println("1.CHECK A/C BALANCE");
		System.out.println("2.WITHDRAW MONEY");
		System.out.println("3.DEPOSITE MONEY");
		System.out.println("4.EXIT");
		
		Scanner sc=new Scanner(System.in);
		int opt=sc.nextInt();		
		
		if(opt==1) {
			checkBalance();
		}
		else if(opt==2) {
			withdrawMoney();
		}
		else if(opt==3) {
			depositeMoney();
		}
		else if(opt==4) {
			return;
		}
		else {
			System.out.println("PLEASE ENTER VALID OPTION ");
		}
	}
	public void checkBalance() {
		System.out.println("Balance : "+balance);
		menu();
	}
	public void withdrawMoney() {
		System.out.println("Enter Amount To Withdraw : ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		if(amount>balance) {
			System.out.println("INSUFFICIENT BALANCE");
		}else {
			balance=balance-amount;
			System.out.println("MONEY WITHDRAWAL IS SUCCESSFUL");
		}
		menu();
	}
	public void depositeMoney() {
		System.out.println("ENTER THE AMOUNT");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		balance=balance + amount;
		System.out.println("MONEY DEPOSITE IS SUCCESSFUL");
		menu();
	}
} 
public class ATMMachine {
      public static void main(String[] args) {
		//Connection con=DriverClass.getConnection();
		
		ATM obj=new ATM();
		obj.checkPin();		
	}
}
