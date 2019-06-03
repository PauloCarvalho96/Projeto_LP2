package Projeto;

import java.io.Serializable;
import static Projeto.Fase2_JavaFX.GraphCreator.professionals;
import static Projeto.Fase2_JavaFX.GraphCreator.company;
import static Projeto.Fase2_JavaFX.GraphCreator.meetings;
import static Projeto.Fase2_JavaFX.GraphCreator.pontosDeEncontro;

public class Location implements Serializable {

    private double x;

    private double y;

    private Company location;
    private Professional location_p;

    @Override
    public String toString()
    {
        return this.getX()+","+this.getY();
    }

    /**
     * Constructor
     */
    public Location(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     *Gets and Sets
     */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Company getLocation() {
        return location;
    }

    public void setLocation(Company location) {
        this.location = location;
    }

    public Professional getLocation_p() {
        return location_p;
    }

    public void setLocation_p(Professional location_p) {
        this.location_p = location_p;
    }

    public double distance(Location l) {
        return 0.0;
    }

}