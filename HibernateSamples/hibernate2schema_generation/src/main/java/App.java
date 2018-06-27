import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    static SessionFactory factory = null;
    public static void main( String[] args ) {
        try{
            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).addAnnotatedClass(Person.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).addAnnotatedClass(Customer.class).buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = session.beginTransaction();
            /*Book book = new Book();
            book.setId( 1L );
            book.setTitle( "High-Performance Java Persistence" );
            book.setIsbn( "11-11-2016" );
            id = (Integer) session.save(book);*/

            Student s1=new Student();
            s1.setId(1L);
            s1.setName("me");
            Course course=new Course();
            course.setId(2L);
            course.setName("Hibernate");
            session.save(course);
            session.save(s1);
            s1.getCourses().add(course);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}