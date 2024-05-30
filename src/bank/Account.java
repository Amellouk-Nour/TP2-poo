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
			scanner.close();
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
	
	
	public void deposit(final Double amount) {
		if(amount>0) {
			this.balance += amount ;
		}
	}
	
	public void  withdraw(final double amount) {
		if(amount > 0) {
			this.balance -= amount ;
		}
	}
	
	public void transfer(Double amount, Account other) {
		if(amount>0) {
			this.withdraw(amount);
			other.deposit(amount);
		}
		
	}
	@Override
	public String toString() {
		return "Account{number: "+number+", nameOwner: "+ name + " }";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Account) {
			Account acc = (Account) obj ;
			return this.name.equals(acc.name) && this.number.equals(acc.number) ;
		}
		return false;
	}
	
	public void setName(String name) {
		this.name = name ;
	}
	
	public void setBalnce(Double balance) throws Exception {
		if(balance<0) {
			throw new Exception("opération impossible");
		}
		this.balance = balance ;
	}
	
	public String getName() {
		return this.name;
	}
	public Double getBalance() {
		return this.balance;
	}
	
	
}
