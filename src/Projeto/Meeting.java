package Projeto;

import java.util.ArrayList;

public class Meeting {

    private String name;

    private int duration;

    /**
     * Constructor
     */
    public Meeting(String name, int duration, Location location, ArrayList<String> interestAreas, Date date) {
        this.setName(name);
        this.setDuration(duration);
        this.setLocation(location);
        this.setInterestAreas(interestAreas);
        this.setDate(date);
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     *
     * @element-type Professional
     */
    public ArrayList<Professional> getProfessional() {
        return professional;
    }

    public void setProfessional(ArrayList<Professional> professional) {
        this.professional = professional;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @element-type InterestAreas
     */
    public ArrayList<String> getInterestAreas() {
        return interestAreas;
    }

    public void setInterestAreas(ArrayList<String> interestAreas) {
        this.interestAreas = interestAreas;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private ArrayList<Professional> professional = new ArrayList<>();
    private Company company;
    private Location location;
    private ArrayList<String> interestAreas = new ArrayList<>();
    private Date date;
}