package com.ewaiter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "itable")
public class iTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iTableId;

    private int tableNo;

    @OneToMany(mappedBy = "iTable")
    private List<Order> orders;

    public Long getiTableId() {
        return iTableId;
    }

    public void setiTableId(Long iTableId) {
        this.iTableId = iTableId;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
