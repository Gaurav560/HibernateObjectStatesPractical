package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args) {

        // creating session object

        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionfactory = con.buildSessionFactory(reg);
        System.out.println(sessionfactory);
        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();


        Laptop l = new Laptop();
        l.setLid(52);
        l.setBrand("Lenovo");
        l.setPrice(700);
        session.persist(l);
        l.setPrice(650);



  //session.remove(l);

             tx.commit();
        session.evict(l);
        l.setPrice(4565654);

    }
}
