package ro.sda.oop.school.goschool;

public class Person {
    public String name;
    protected Integer age;
    private String cnp;
    String address;


    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
        System.out.println("Constructed person");
    }

    public void sayName(){
        System.out.println("My name is " + name);
    }

    public void sayAge() {
        System.out.println("My age is " + age);
    }

    public void changeName(String name){
        this.name = name;
    }
    public void showPerson(){
        System.out.println("Person");
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.cnp);
        System.out.println(this.address);
    }

    public void showPerson2(){
        System.out.println("Person");
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.cnp);
        System.out.println(this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cnp='" + cnp + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
