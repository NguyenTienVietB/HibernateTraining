package net.hql_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import net.hql_demo.entity.Employee;

import javax.persistence.Query;
import java.util.List;

public class SelectApp {
    public  static  void main(String args[]){
    	     
        Configuration conf = new Configuration();     
        conf.configure("hibernate.cfg.xml");     
        conf.addAnnotatedClass(Employee.class);     
        SessionFactory factory=conf.buildSessionFactory();      
        Session session = factory.getCurrentSession();
        session.beginTransaction();     
        String select ="select firstName, lastName from Employee";

        Query query=session.createQuery(select);
        List<Object[]> result= query.getResultList();
        session.getTransaction().commit();
        for(Object[] values : result){
            System.out.println("first name " + values[0] + " last name "+values[1]);
        }

        
        factory.close();
    }
}
