package com.ewaiter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "waiter")
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waiterId;

    @Column
    private String name;

    @OneToMany(mappedBy = "waiter")
    private List<Order> orders;

    public Long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
