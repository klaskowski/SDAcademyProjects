package com.ewaiter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany
    @JoinTable(name = "order_product",
    joinColumns = {
            @JoinColumn (referencedColumnName = "orderId")
    },
    inverseJoinColumns = {
            @JoinColumn(referencedColumnName = "productId")
    })
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "iTableId")
    private iTable iTable;

    @ManyToOne
    @JoinColumn(name = "waiterId")
    private Waiter waiter;

    @Column
    private String status;

    @OneToOne(mappedBy = "order")
    private Bill bill;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public iTable getTable() {
        return iTable;
    }

    public void setTable(iTable table) {
        this.iTable = iTable;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.ewaiter.model.iTable getiTable() {
        return iTable;
    }

    public void setiTable(com.ewaiter.model.iTable iTable) {
        this.iTable = iTable;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
