/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vhbs.repository.impl;

import com.vhbs.hibernateapp.HibernateUtils;
import com.vhbs.hibernateapp.pojo.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class UserRepositoryImpl {
    public User getUserByUserName(String username){
        try (Session s = HibernateUtils.getFactory().openSession()){
            Query q =s.createNamedQuery(("User.findByUsername"));
            q.setParameter("username",username);
            return (User) q.getSingleResult();
        }
    }
}
