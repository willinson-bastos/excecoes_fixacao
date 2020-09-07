package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountLimitException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
	
			System.out.println();
			System.out.print("Enter the amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
			
		}
		catch(RuntimeException e){
			System.out.println("Unexpected error. ");
		}
		catch(AccountLimitException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		sc.close();
	}

}
