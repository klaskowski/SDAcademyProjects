package ro.sda.oop.school.bank;

import ro.sda.oop.school.goschool.Person;

public class BankOperator extends Person {
    public BankOperator(String name, Integer age){
        super(name, age);
        System.out.println("Constructed bankoperator");
    }
    public void changeIban(Account a, String iban){
        a.iban = iban;
    }
    public void showPerson(){
        System.out.println("Bank Operator");
        System.out.println(this.name);
        System.out.println(this.age);
    }

    public void showPerson2(){
        System.out.println("Bank Operator");
        super.showPerson2();
    }

    @Override
    public String toString() {
        return "BankOperator{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
                '}';
    }
}
