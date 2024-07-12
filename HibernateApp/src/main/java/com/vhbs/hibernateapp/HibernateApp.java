/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.vhbs.hibernateapp;

import com.vhbs.hibernateapp.pojo.Cart;
import com.vhbs.hibernateapp.pojo.Category;
import com.vhbs.repository.impl.CategoryRepositoryImpl;
import com.vhbs.repository.impl.ProductRepositoryImpl;
import com.vhbs.repository.impl.StatsRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateApp {

    public static void main(String[] args) {
          StatsRepositoryImpl s = new StatsRepositoryImpl();
//          s.statsRevenueByProdutc().forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));
          
          s.statsRevenueByPeriod(2020, "MONTH").forEach(o -> System.out.printf("%s: %d\n", o[0], o[1]));
            
        
//        CategoryRepositoryImpl cate = new CategoryRepositoryImpl();
//        cate.getCates().forEach(e -> System.out.println(e.getClass().getName()));
//        List<Cart> c = new ArrayList<>();        
//        Map<String, String> params = new HashMap<>();
//        params.put("price", "28000000");
//        
//        ProductRepositoryImpl s= new ProductRepositoryImpl();
//        s.getP(params).forEach(p -> System.out.printf("%s - %.1f\n", p.getName(), p.getPrice()));
    }
}
