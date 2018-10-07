package ro.sda.hypermarket.core.entity;


import org.apache.commons.lang3.StringUtils;
import ro.sda.hypermarket.commons.util.Validator;
import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "employees", schema = "hypermarket")
public class Employee extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "employee_code", nullable = false, unique = true, length = 4)
    private String code;

    @Column(name = "employee_position", nullable = false)
    private String position;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "cnp", nullable = false, unique = true, length = 13)
    private String cnp;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no", nullable = false, unique = true, length = 10)
    private String phoneNo;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        if(Validator.validateCode(code)) {
            this.code = code;
        } else{
            throw new IllegalArgumentException("Invalid code!");
        }
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCnp() {
        return this.cnp;
    }

    public void setCnp(String cnp) {
        if(Validator.validateCnp(cnp)) {
            this.cnp = cnp;
        } else {
            throw new IllegalArgumentException("Invalid CNP");
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(Validator.validateEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Wrong Email");
        }
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        if(Validator.validatePhoneNo(phoneNo)) {
            this.phoneNo = phoneNo;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.getFirstName(), employee.getFirstName()) &&
                Objects.equals(this.getLastName(), employee.getLastName()) &&
                Objects.equals(this.getCode(), employee.getCode()) &&
                Objects.equals(this.getPosition(), employee.getPosition()) &&
                Objects.equals(this.getBirthDate(), employee.getBirthDate()) &&
                Objects.equals(this.getCnp(), employee.getCnp()) &&
                Objects.equals(this.getAddress(), employee.getAddress()) &&
                Objects.equals(this.getEmail(), employee.getEmail()) &&
                Objects.equals(this.getPhoneNo(), employee.getPhoneNo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getFirstName(), this.getLastName(), this.getCode(), this.getPosition(), this.getBirthDate(), this.getCnp(), this.getAddress(), this.getEmail(), this.getPhoneNo());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", code='" + code + '\'' +
                ", position='" + position + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", cnp='" + cnp + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
