import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "Romance")
public class Romance extends Book {

    private String argument;


    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}