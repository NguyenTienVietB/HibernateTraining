package com.javatraining;


import com.javatraining.model.User;
import com.javatraining.utils.HibernateUtils;


import org.hibernate.*;

public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session1 = sessionFactory.openSession();
             Session session2 = sessionFactory.openSession();) {

            User cat1_1st = session1.get(User.class, 1L);
            System.out.println("Session 1 at 1st time: " + cat1_1st.getName());

            User cat1_2nd = session1.get(User.class, 1L);
            System.out.println("Session 1 at 2nd time: " + cat1_2nd.getName());

            User cat2 = session2.get(User.class, 1L);
            System.out.println("Session 2: " + cat2.getName());
        }
    }

    }