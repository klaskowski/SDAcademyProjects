package ro.sda.oop.school.bank;

public class Account {

    private Double money = 0.00;
    protected String iban;

    public Account(){

    }

    public Account(String iban){
        this.iban = iban;
    }

    public Account(String iban, Double money){
        this.iban = iban;
        this.money = money;
    }

    public void addMoney(Double sum) {
        System.out.println("Adding " + sum + ":");
        money += sum;
    }

    public void spendMoney(Double sum) {
        if (sum <= money) {
            System.out.println("Spending " + sum + ":");
            money -= sum;
        } else {
            System.out.println("You don't have that much!");
        }
    }

    public void showMoney() {
        System.out.println("Balance: " + money);
    }

}
