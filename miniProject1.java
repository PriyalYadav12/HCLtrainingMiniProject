import java.io.*;
import java.util.*;

abstract class BankAccount {
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited in Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited in Current Account");
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -5000) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}

public class BankManagementSystem {

    static void saveToFile(BankAccount acc) {
        try (FileWriter fw = new FileWriter("bankdata.txt", true)) {
            fw.write(acc.accountNumber + "," + acc.accountHolder + "," + acc.balance + "\n");
        } catch (IOException e) {
            System.out.println("File write error");
        }
    }

    static void saveToFile(String message) {
        try (FileWriter fw = new FileWriter("banklog.txt", true)) {
            fw.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Log file error");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null; // Runtime Polymorphism

        while (true) {
            System.out.println("\n----- BANK MANAGEMENT SYSTEM -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.print("Account Type (1-Savings, 2-Current): ");
                        int type = sc.nextInt();

                        if (type == 1)
                            account = new SavingsAccount(accNo, name, bal);
                        else
                            account = new CurrentAccount(accNo, name, bal);

                        saveToFile(account);
                        saveToFile("Account created for " + name);
                        System.out.println("Account created successfully");
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        account.deposit(sc.nextDouble());
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 4:
                        account.showBalance();
                        break;

                    case 5:
                        account.showAccountDetails();
                        break;

                    case 6:
                        System.out.println("Thank you for using Bank Management System");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                sc.nextLine(); 
            }
        }
    }
}
