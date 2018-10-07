package com.ewaiter.dao;

import com.ewaiter.model.*;
import com.ewaiter.utils.HibernateUtil;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends GenericDao<Order> {


    public void createOrder(int tableNumber, Long waiterId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "select iT.id, iT.tableNo from iTable iT where iT.tableNo = " + tableNumber;
        iTable table = (iTable)session.createQuery(query);
        query = "select w.waiterId, w.name from waiter w where w.waiterId = " + waiterId;

        Waiter waiter = session.createQuery(query);

        Order order = new Order();
        order.setiTable(table);
        order.setWaiter(waiter);
        order.setStatus(String.valueOf(OrderStatus.OPEN));
        order.setProducts(new ArrayList<Product>());
        if(canOpenOrder(order)) {
            Bill bill = new Bill();
            bill.setCost(0.0);
            order.setBill(bill);
            createEntity(order);
        } else {
            System.out.println("Table already has order open");

        }
    }

    private boolean canOpenOrder(Order order){
        if(order.getiTable().equals(null)){
            return true;
        } else {
            return false;
        }
    }

    public void addProductToOrder(List<Product> products, Order order){
        if(isOrderValid(order)) {
            order.setProducts(products);
            updateEntity(order);
        }
    }

    private boolean isOrderValid(Order order){
        if(order.getStatus().equals(String.valueOf(OrderStatus.OPEN))){
            return true;
        } else {
            return false;
        }
    }


}
