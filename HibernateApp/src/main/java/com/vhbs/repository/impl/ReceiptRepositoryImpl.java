/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vhbs.repository.impl;

import com.vhbs.hibernateapp.HibernateUtils;
import com.vhbs.hibernateapp.pojo.Cart;
import com.vhbs.hibernateapp.pojo.OrderDetail;
import com.vhbs.hibernateapp.pojo.SaleOrder;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ReceiptRepositoryImpl {
    private static final UserRepositoryImpl u = new UserRepositoryImpl();
    private static final ProductRepositoryImpl p = new ProductRepositoryImpl();
    public void AddReceipt(List<Cart> carts){
        if (carts != null){
            try (Session s = HibernateUtils.getFactory().openSession()){
                SaleOrder order = new SaleOrder();
                order.setUserId(u.getUserByUserName("dhthanh"));
                order.setCreatedDate(new Date());
                s.save(order);
                for (var c: carts){
                    OrderDetail d =new OrderDetail();
                    d.setUnitPrice(c.getUnitPrice());
                    d.setQuantity(c.getQuantity());
                    d.setProductId(p.getProduct(c.getId()));
                    d.setOrderId(order);      
                    s.save(d);
                }
            }
        }
    }
}
