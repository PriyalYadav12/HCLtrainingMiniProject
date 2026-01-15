package assignments.mini_projects.Day3;

import java.io.Serializable;

public abstract class BankAccount implements Serializable {
    private int accountNo;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNo, String holderName, double balance) {
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract void withdraw(double amount);

    public void displayDetails() {
        System.out.println("Account No : " + accountNo);
        System.out.println("Name       : " + holderName);
        System.out.println("Balance    : " + balance);
    }
}
