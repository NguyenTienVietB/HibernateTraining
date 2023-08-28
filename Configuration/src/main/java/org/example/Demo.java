package org.example;

import org.hibernate.Session;
import org.example.pojo.User;

public class Demo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//            Query<User> query = session.createQuery("FROM User");
//            List<User> users = query.list();
//            users.forEach(c ->System.out.println(c.getName()));
            session.getTransaction().begin();
            User p = new User();
            p.setName("Thu");
            p.setAccount("Thuthut@gmail.com");
            p.setPassword("123456");
            session.save(p);
            session.getTransaction().commit();


        session.close();
    }
}
