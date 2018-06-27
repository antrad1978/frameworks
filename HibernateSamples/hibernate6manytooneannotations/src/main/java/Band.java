import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Band")
public class Band {

    @Id
    @GeneratedValue
    private Long id;

    public Band() {
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}