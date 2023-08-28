package net.hql_demo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.*;
import javax.persistence.*;

import net.hql_demo.entity.Employee;
import net.hql_demo.utils.HibernateUtils;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.List;

public class CriteriaTest {
    public static void main(String args[]) {
    	
    	Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);       
        SessionFactory factory = conf.buildSessionFactory();  
        Session session = factory.openSession();    
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
    	Root<Employee> root = query.from(Employee.class);    	
    	query.select(root);
    	query.where(builder.equal(root.get("idEmployee"),1));
    	Query q = session.createQuery(query);
    	List<Employee> empList = q.getResultList();
    	empList.forEach(System.out::println);  	
    	
    	
    	CriteriaQuery<Employee> query1 = builder.createQuery(Employee.class);
    	Root<Employee> root1 = query1.from(Employee.class);
    	query1.multiselect(builder.sum(root1.get("salary")));
    	Employee result = session.createQuery(query1).getSingleResult();
    	BigDecimal sum = (BigDecimal) result.get(0);
    	System.out.println("Sum = " + sum);
    	
    }
}
