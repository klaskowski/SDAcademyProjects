import java.util.Scanner;

public class AccountOperations {
    Scanner sc = new Scanner(System.in);

    private double calculateCommission(double amount, double commission) {
        return amount * commission / 100;
    }

    public double calculateInterest(double amount, double interest) {
        return amount * interest / 100;
    }

    private double deposit(double balance) {
        System.out.println("Input amount: ");
        double amount = sc.nextDouble();
        return balance + amount;
    }

    private double withdraw(double balance, double commission) {
        System.out.println("Input amount");
        double amount = sc.nextDouble();
        double commissionValue = calculateCommission(amount, commission);
        return balance - amount - commissionValue;
    }

    public void displayAccountMenu(Account account) {
        int option = -1;
        displayAccountOptions();
        option = readAccountOption();
        processAccountOperation(option, account);
        while (option != 0) {
            displayAccountMenu(account);
        }
    }

    private void displayAccountOptions() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("0. Exit");
    }

    private int readAccountOption() {
        System.out.println("Input option: ");
        return sc.nextInt();
    }

    private void processAccountOperation(int option, Account account) {
        switch (option) {
            case 1:
                account.setBalance(deposit(account.getBalance()));
                System.out.println(account);
                break;
            case 2:
                account.setBalance(withdraw(account.getBalance(), account.getCommission()));
                System.out.println(account);
                break;
            case 0:
            default:
                break;
        }
    }
}
