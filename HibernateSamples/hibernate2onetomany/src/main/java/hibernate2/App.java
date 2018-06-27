package hibernate2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate2.App;
import hibernate2.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory;
	
    public static void main( String[] args )
    {
    	try{
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    	Session session = factory.openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           Employee employee = new Employee(); 
           employee.setFirstName("Tonio");
           employee.setLastName("Tonio");
           employee.setSalary(42342);
           Job job1=new Job();
           job1.setDescription("job1");
           Job job2=new Job();
           job2.setDescription("job2");
           List<Job> jobs=new ArrayList<Job>();
           jobs.add(job1);
           jobs.add(job2);
           employee.setJobs(jobs);
           session.save(employee);
           tx.commit();
        }catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
      }
}
