import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    static SessionFactory factory = null;
    public static void main( String[] args ) {
        try{
            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).addAnnotatedClass(Person.class).buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        Long id = null;
        try{
            tx = session.beginTransaction();
            Person person = new Person();
            person.setName( "John Doe" );
            person.setId(13L);

            Book book = new Book();
            book.setId(24L);
            book.setIsbn("53452345");
            //person.getBooks().add(book);
            book.setAuthor( person );
            session.save(person);
            session.save(book);
            tx.commit();
        }catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}