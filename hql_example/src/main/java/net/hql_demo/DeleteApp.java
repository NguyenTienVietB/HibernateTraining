package net.hql_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import net.hql_demo.entity.Employee;

import javax.persistence.Query;

public class DeleteApp {
    public static void main(String args[]) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);       
        SessionFactory factory = conf.buildSessionFactory();  
        Session session = factory.getCurrentSession();    
        int idEmployee=4;
        session.beginTransaction();
        String delete = "delete Employee e  where e.idEmployee=:idEmployee";
        Query query = session.createQuery(delete);
        query.setParameter("idEmployee",idEmployee);     
        int count = query.executeUpdate();
        session.getTransaction().commit();

    }
}
