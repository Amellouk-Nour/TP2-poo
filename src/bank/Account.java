package bank;

import static java.util.UUID.randomUUID;
import java.util.Scanner;

public class Account {
	private String number;
	private String name;
	private Double balance;
	
	public Account(String name, double balance) {
		if (name == null) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Veuillez donner un nom au compte: ");
			this.name = scanner.nextLine();
		}
		this.balance = balance;
		this.number = randomUUID().toString();
	}
	public Account() {
		this(null,0);
	}
	public Account(Account original) {
		this.name = original.name;
		this.balance = original.balance;
		this.number = randomUUID().toString();

	}
	
	
	public static void main(String [] args) {
		Account acc1 = new Account(null, 10);
        System.out.println("Account 1 number: " + acc1.number);
        System.out.println("Account 1 name: " + acc1.name);
        System.out.println("Account 1 balance: " + acc1.balance);

        // Test du constructeur sans argument
        Account acc2 = new Account();
        System.out.println("Account 2 number: " + acc2.number);
        System.out.println("Account 2 name: " + acc2.name);
        System.out.println("Account 2 balance: " + acc2.balance);

        // Test du constructeur par copie
        Account acc3 = new Account(acc1);
        System.out.println("Account 3 number: " + acc3.number);
        System.out.println("Account 3 name: " + acc3.name);
        System.out.println("Account 3 balance: " + acc3.balance);
		
	}
}
