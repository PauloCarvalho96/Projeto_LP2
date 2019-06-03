package Projeto;
import static Projeto.Fase2_JavaFX.GraphCreator.professionals;
import static Projeto.Fase2_JavaFX.GraphCreator.company;
import static Projeto.Fase2_JavaFX.GraphCreator.meetings;
import static Projeto.Fase2_JavaFX.GraphCreator.pontosDeEncontro;

public class PontosDeEncontro {
    private String name;
    private Location location;
    private Integer id;


    /**
     * Constructor
     */
    public PontosDeEncontro(String name, Location location, Integer id) {
        this.setName(name);
        this.setLocation(location);
        this.setId(id);
    }

    /**
     * Gets and Sets
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}