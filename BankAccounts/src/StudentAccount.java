import java.util.Scanner;

public class StudentAccount extends Account {

    private double commission;
    private double interest = 0.5;
    AccountOperations operations;

    public StudentAccount(String name, String iban, double balance) {
        super(name, iban, balance);
        commission = 0.0;
    }

    @Override
    public double getCommission() {
        return commission;
    }

    public void getLoan(StudentAccount studentAccount){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input loan amount: ");
        double amount = sc.nextDouble();
        studentAccount.setBalance(studentAccount.getBalance() + amount + operations.calculateInterest(amount, interest));
        System.out.println("You have to return " + amount + " + interest" + interest);
    }
}
