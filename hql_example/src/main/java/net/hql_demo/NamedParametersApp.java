package net.hql_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import net.hql_demo.entity.Employee;

import javax.persistence.Query;
import java.util.List;

public class NamedParametersApp {
    public static void main(String args[]) {

        
        Configuration conf = new Configuration();

        conf.configure("hibernate.cfg.xml");
 
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
   
        Session session = factory.getCurrentSession();

       String employeeFirstName="Steven";
       String employeeLastName="King";

        session.beginTransaction();

 

        String namedParametersString = "select e.firstName, e.lastName, e.salary from Employee e where e.firstName=:firstName and e.lastName=:lastName";
        Query namedParametersQuery = session.createQuery(namedParametersString);
        namedParametersQuery.setParameter("firstName",employeeFirstName);
        namedParametersQuery.setParameter("lastName",employeeLastName);



        List<Object[]> result = namedParametersQuery.getResultList();

        session.getTransaction().commit();

        for(Object[] values :result ){
            System.out.println("first name "+ values[0] + " last name "+ values[1]+ " Salary "+values[2]);
        }
    }
}
