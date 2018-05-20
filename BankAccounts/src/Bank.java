import java.util.Arrays;
import java.util.Scanner;

public class Bank {

    private int nrOfAccounts = 1;
    private int addedAccounts = 0;
    Account[] accounts = new Account[nrOfAccounts];



    public void addAccount(String name, String iban, double balance) {
        Account account = new Account(name, iban, balance);
        if(addedAccounts < nrOfAccounts-1){
            accounts[addedAccounts] = account;
            addedAccounts++;
        } else {
            accounts = Arrays.copyOf(accounts, nrOfAccounts * 2);
            accounts[addedAccounts] = account;
            addedAccounts++;
        }
    }

    public void displayAccounts(){
        System.out.println("The bank has a total of " + addedAccounts + " accounts:");
        for (int i = 0; i < addedAccounts; i++){
            Account account = accounts[i];
            System.out.print(i + ":");
            System.out.println(account);
        }
    }

    public void selectAccount(){
        AccountOperations operations = new AccountOperations();
        displayAccounts();
        System.out.println("Input account ID: ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        for (int i = 0; i < accounts.length; i++){
            if (option == i){
                Account account = accounts[i];
                System.out.println(account);
                operations.displayAccountMenu(account);
            }
        }
    }



}
