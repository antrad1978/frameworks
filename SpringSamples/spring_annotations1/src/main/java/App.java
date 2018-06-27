import com.samples.Book;
import com.samples.Service;
import com.samples.Formatter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main( String[] args ) {
        System.out.println("Start");
        try {
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            Service service = (Service) context.getBean(Service.class);

            Formatter formatter = (Formatter) context.getBean("formatter");
            formatter.format();

            Book book = (Book) context.getBean(Book.class);
            System.out.println(book.getName());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
