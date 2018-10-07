package ro.sda.model;

public class Student {

    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 50) {
            throw new IllegalArgumentException("Name to long!!");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 50) {
            throw new IllegalArgumentException("Name to long!!");
        } else {
            this.lastName = lastName;
        }
    }
}
