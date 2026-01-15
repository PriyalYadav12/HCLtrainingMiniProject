package assignments.mini_projects.Day3;

public class BankService {

    private BankAccount account;

    public void createAccount(BankAccount account) {
        this.account = account;
        FileUtil.saveAccount(account);
    }

    public void deposit(double amount) {
        account.deposit(amount);
        FileUtil.saveAccount(account);
    }


    public void withdraw(int amount) {
        account.withdraw(amount);
        FileUtil.saveAccount(account);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
        FileUtil.saveAccount(account);
    }

    public void showBalance() {
        System.out.println("Balance: " + account.getBalance());
    }

    public void showDetails() {
        account.displayDetails();
    }

    public void loadExistingAccount() {
        account = FileUtil.loadAccount();
    }

    public boolean hasAccount() {
        return account != null;
    }
}
