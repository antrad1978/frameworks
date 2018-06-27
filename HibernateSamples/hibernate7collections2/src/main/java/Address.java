import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String type;

    @Column(name = "`number`")
    private String number;

    public Address() {
    }

    public Address(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
