public class Account {
    private String name;
    private String iban;
    private double balance;
    private double commission;

    public Account(String name, String iban, double balance){
        this.name = name;
        this.iban = iban;
        this.balance = balance;
        commission = 5.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public String toString() {
        return name + "(" + iban + "): $" + balance;
    }
}
