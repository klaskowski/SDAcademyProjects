package com.ewaiter.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billId;

    @OneToOne
    private Order order;

    @Column
    private Double cost;

    @Column
    private String paymentMethod;

    public long getBillId() {
        return billId;
    }

    public void setBillId(long id) {
        this.billId = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
