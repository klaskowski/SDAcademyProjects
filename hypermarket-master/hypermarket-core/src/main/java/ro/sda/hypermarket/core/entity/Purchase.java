package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchases", schema = "hypermarket")
public class Purchase extends BaseEntity {

    @Column(name = "receipt_no", nullable = false)
    private int receiptNo;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    public int getReceiptNo() {
        return this.receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return this.getReceiptNo() == purchase.getReceiptNo() &&
                Double.compare(purchase.getTotalPrice(), this.getTotalPrice()) == 0 &&
                Objects.equals(this.getEmployee(), purchase.getEmployee()) &&
                Objects.equals(this.getClient(), purchase.getClient()) &&
                Objects.equals(this.getPurchaseDate(), purchase.getPurchaseDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getReceiptNo(), this.getEmployee(), this.getClient(), this.getPurchaseDate(), this.getTotalPrice());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "receiptNo=" + receiptNo +
                ", employee=" + employee +
                ", client=" + client +
                ", purchaseDate=" + purchaseDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
