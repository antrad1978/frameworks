import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	private static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
    	
    	Controller controller = (Controller) context
				.getBean("controller");
		
		DatabaseService service=(DatabaseService) context.getBean("service");

		controller.apply();
    }
}
