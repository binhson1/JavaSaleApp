/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vhbs.repository.impl;

import com.vhbs.hibernateapp.HibernateUtils;
import com.vhbs.hibernateapp.pojo.Product;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
    public List<Product> getP(Map<String, String> params){
        try (Session s = HibernateUtils.getFactory().openSession())
        {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q  = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            String kw = params.get("q");
            if(kw != null && !kw.isEmpty()){
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                q.where(p1);
            }
            
            String price = params.get("price");
            if(kw != null && !kw.isEmpty()){
                Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(price));
                q.where(p2);
            }
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }        
    }
    
    public Product getProduct(int id){
        try(Session s = HibernateUtils.getFactory().openSession()){
            return s.get(Product.class,id);
        }
    }
}
