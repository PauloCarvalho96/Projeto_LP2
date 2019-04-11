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


    public ArrayList<String> getProfessional() {
        return professional;
    }

    public void setProfessional(ArrayList<String> professional) {
        this.professional = professional;
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

    public ArrayList<String> getCompanys() {
        return companys;
    }

    public void setCompanys(ArrayList<String> companys) {
        this.companys = companys;
    }

    /**
     *
     * @element-type Professional
     */

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

    private ArrayList<String> professional = new ArrayList<>();
    private ArrayList<String> companys = new ArrayList<>();
    private Location location;
    private ArrayList<String> interestAreas = new ArrayList<>();
    private Date date;

    public void associateMeetCompany(Company c) // Associa um Meeting a uma Empresa
    {
        this.companys.add(c.getName());
    }

    public void associateMeetProfessional(Professional p)
    {
        this.professional.add(p.getName());
    }

    @Override
    public String toString()
    {
        return "\nName: "+this.getName()+"\nCompany: "+this.getCompanys()+"\nDuration: "+this.getDuration()+" minutes"+
                "\nLocation: "+this.getLocation()+"\nInterest Areas: "+this.getInterestAreas()
                +"\nProfessionals:"+this.getProfessional()+"\n--------------------";
    }
}