import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Address")
public class Address{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Address() {
    }

    public Address(String provider) {
        this.setName(provider);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}