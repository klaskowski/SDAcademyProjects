package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.commons.util.Validator;
import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "suppliers", schema = "hypermarket")

public class Supplier extends BaseEntity {
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "bank_account", nullable = false, unique = true, length = 34)
    private String bankAccount;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(Validator.validateEmail(email)) {
            this.email = email;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(this.getName(), supplier.getName()) &&
                Objects.equals(this.getBankAccount(), supplier.getBankAccount()) &&
                Objects.equals(this.getEmail(), supplier.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getName(), this.getBankAccount(), this.getEmail());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
