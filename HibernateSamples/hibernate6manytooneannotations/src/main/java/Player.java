import javax.persistence.*;

@Entity(name = "Player")
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`name`")
    private String name;

    @ManyToOne
    @JoinColumn(name = "band_id",
            foreignKey = @ForeignKey(name = "BAND_ID_FK")
    )
    private Band band;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }
}