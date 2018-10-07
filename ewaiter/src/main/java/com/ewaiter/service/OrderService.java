package com.ewaiter.service;

import com.ewaiter.dao.OrderDao;
import com.ewaiter.model.Order;
import com.ewaiter.model.Product;
import com.ewaiter.model.iTable;

import java.util.List;

public class OrderService {

    OrderDao orderDao;

    public OrderService(){
        orderDao = new OrderDao();
    }

    public void createOrder(int tableNo , Long waiterId){

        orderDao.createOrder(tableNo, waiterId);
    }

    public void addProductToOrder(List<Product> products, Order order){
        orderDao.addProductToOrder(products, order);
    }


}
