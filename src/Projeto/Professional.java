package Projeto;

import java.util.ArrayList;

public class Professional extends Person {

    private double salary;

    private Date registration;

    private Company company;

    private ArrayList<String> meet = new ArrayList<>();
    private Person person;
    private Date date;
    private Location location;
    private ArrayList<String> companyHistory = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();           //skills do profissional

    @Override
    public String toString()
    {
        return "\nEmpresa: "+this.getCompany().getName()+"\nname:"+this.getName()+"\nBirth Date: "+this.getBirth_date()+"\nsexo :"+this.getGender()+
                "\nSkills: "+this.getSkills()+ "\nLocation: "+this.getLocation()+"\nSalary: "+this.getSalary()+"\nMeetings: "+this.getMeet()+
                "\nCompany History: "+this.getCompanyHistory()+"\n--------------------";
    }
    /**
     * Constructor
     */

    public Professional(String name,String gender,Date birth, ArrayList<String> skills, Location location) {
        super(name,gender,birth);
        this.setSkills(skills);
        this.setLocation(location);
    }

    /**
     * Gets and Sets
     */


    public double getSalary() {
        return salary;
    }

    public ArrayList<String> getCompanyHistory() {
        return companyHistory;
    }

    public void setCompanyHistory(ArrayList<String> companyHistory) {
        this.companyHistory = companyHistory;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getMeet() {
        return meet;
    }

    public void setMeet(ArrayList<String> meet) {
        this.meet = meet;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Meeting searchMeetings(Professional p) {
        return null;
    }

    public void associateProfessionalMeet(Meeting m) // Associa o professional ao Meet
    {
        this.getMeet().add(m.getName());
    }

    public void addCompanyHistoryToPro(Company c)
    {
        this.companyHistory.add(c.getName());
    }

}