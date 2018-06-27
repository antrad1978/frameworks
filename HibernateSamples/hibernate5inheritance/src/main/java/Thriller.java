import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "Thriller")
public class Thriller extends Book {

    private int killers;


    public int getKillers() {
        return killers;
    }

    public void setKillers(int killers) {
        this.killers = killers;
    }
}