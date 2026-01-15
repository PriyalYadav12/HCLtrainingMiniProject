package assignments.mini_projects.Day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        service.loadExistingAccount();

        if (!service.hasAccount()) {
            System.out.println("Create Account");
            System.out.print("Account No: ");
            int acc = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Initial Balance: ");
            double bal = sc.nextDouble();

            System.out.println("1. Savings Account\n2. Current Account");
            int choice = sc.nextInt();

            BankAccount account;
            if (choice == 1)
                account = new SavingsAccount(acc, name, bal);
            else
                account = new CurrentAccount(acc, name, bal);

            service.createAccount(account);
        }

        int option;
        do {
            System.out.println("\n1 Deposit\n2 Withdraw\n3 Balance\n4 Details\n5 Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Amount: ");
                    service.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Amount: ");
                    service.withdraw(sc.nextDouble());
                    break;
                case 3:
                    service.showBalance();
                    break;
                case 4:
                    service.showDetails();
                    break;
                case 5:
                    System.out.println("Thank you");
            }
        } while (option != 5);

        sc.close();
    }
}
