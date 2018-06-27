import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

public class App {
    static SessionFactory factory = null;
    public static void main( String[] args ) {
        try{
            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Contact.class).addAnnotatedClass(Name.class).buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = session.beginTransaction();
            Contact employee = new Contact();
            employee.setId(1);
            Name name=new Name();
            name.setFirst("tonio");
            name.setLast("last");
            name.setMiddle("middle");
            employee.setName(name);
            employee.setStarred(true);
            employee.setWebsite(new URL("http://www.liberot.it"));
            employee.setNotes("");
            id = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}


