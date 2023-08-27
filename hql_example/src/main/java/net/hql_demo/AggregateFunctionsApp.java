package net.hql_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import net.hql_demo.entity.Employee;

import javax.persistence.Query;
import java.util.List;

public class AggregateFunctionsApp {
    public static void main(String args[]) {
        Configuration conf = new Configuration(); 
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String avg = "select avg(e.salary) from Employee as e";
        String sum = "select sum(e.salary) from Employee as e";
        String count = "select count(e) from Employee as e";
        Query query = session.createQuery(avg);
        double result = (double) query.getSingleResult();
        Query query2 = session.createQuery(sum);
        double result2= (long) query2.getSingleResult();
        Query query3 = session.createQuery(count);
        long result3 = (long) query3.getSingleResult();
        session.getTransaction().commit();

        System.out.println("avg salary = " + result);
        System.out.println("sum salary = " + result2);
        System.out.println("count = " + result3);
    }
}
