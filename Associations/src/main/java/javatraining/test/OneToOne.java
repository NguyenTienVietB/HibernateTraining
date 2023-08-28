package javatraining.test;

import javatraining.model.oneToOne.*;
import javatraining.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOne {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Create entities
            Person person = new Person("John Doe");

            // Save entities
            session.persist(person);

            transaction.commit();
            System.out.println("Entities saved successfully!");
        }
    }
}
