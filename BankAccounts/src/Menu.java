import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Bank bank = new Bank();

    public void displayMenu() {
        int option = -1;
        displayOptions();
        option = readOption();
        processOption(option);
        while (option != 0) {
            displayMenu();
        }
    }

    private void displayOptions() {
        System.out.println("1. Add regular account");
        System.out.println("2. Add student account");
        System.out.println("3. Display accounts");
        System.out.println("4. Select account");
        System.out.println("0. Exit");
    }

    private int readOption() {
        System.out.println("Input option: ");
        return sc.nextInt();
    }

    private void processOption(int option, Account account) {

        switch (option) {
            case 1:
                readAccount(account);
                break;
            case 2:
                readAccount(studentAccount);
                break;
            case 3:
                bank.displayAccounts();
                break;
            case 4:
                bank.selectAccount();
                break;
            default:
                break;
        }
    }

    private void readAccount(Account account) {
        System.out.print("Enter account name: ");
        String name = sc.nextLine();
        System.out.print("Enter account IBAN: ");
        String iban = sc.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = sc.nextDouble();
        bank.addAccount(name, iban, balance);
    }


}
