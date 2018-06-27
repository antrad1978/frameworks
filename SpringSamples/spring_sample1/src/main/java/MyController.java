import java.util.logging.Logger;

public class MyController implements Controller{
    private static Logger logger = Logger
            .getLogger(MyController.class.toString());

    private DatabaseService dbService;

    public MyController() {
        logger.info("initializing");
    }

    public void setDbService(DatabaseService dbService) {
        logger.info("Setting dbService property");
        this.dbService = dbService;
    }

    public void apply() {
        System.out.println("Apply My");
    }
}
