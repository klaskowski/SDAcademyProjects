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

    public Long getITableId() {
        return iTableId;
    }

    public void setITableId(Long id) {
        this.iTableId = id;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int table_no) {
        this.tableNo = table_no;
    }

    public Long getiTableId() {
        return iTableId;
    }

    public void setiTableId(Long iTableId) {
        this.iTableId = iTableId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
