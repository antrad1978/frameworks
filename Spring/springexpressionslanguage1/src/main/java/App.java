import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
    	
    	Album album = (Album) context
				.getBean("controller");
		
		Category category=(Category) context.getBean("category");

		System.out.println(album.getCategory().getName());
    }
}
