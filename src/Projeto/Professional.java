package Projeto;

import java.util.ArrayList;

public class Professional extends Person {

    private double salary;

    private Date registration;

    private String id;

    private Company company;

    private ArrayList<String> skills = new ArrayList<>();           //skills do profissional
    private ArrayList<String> companyHistory = new ArrayList<>();   //historico de empresas


    @Override
    public String toString()
    {
        return "\nEmpresa: "+this.getCompany().getName()+"\nname:"+this.getName()+"\nage: "+this.getAge()+"\nsexo :"+this.getGender()+
                "\nSkills: "+this.getSkills()+ "\nLocation: "+this.getLocation()+"\nSalary: "+this.getSalary()+"\nID: "+
                this.getId()+"\nMeetings: "+this.getMeet()+"\nCompany History: "+"\n--------------------";
    }
    /**
     * Constructor
     */

    public Professional(String name, int age, String gender, ArrayList<String> skills, Location location, String id,double salary,ArrayList<String> companyHistory) {
        super(name, age, gender);
        this.setSkills(skills);
        this.setLocation(location);
        this.setSalary(salary);
        this.setId(id);
        this.setCompanyHistory(companyHistory);
    }

    /**
     * Gets and Sets
     */

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<String> getCompanyHistory() {
        return companyHistory;
    }

    public void setCompanyHistory(ArrayList<String> companyHistory) {
        this.companyHistory = companyHistory;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    private ArrayList<String> meet = new ArrayList<>();
    private Person person;
    private Date date;
    private Location location;

    public Meeting searchMeetings(Professional p) {
        return null;
    }

    public void associateProfessionalMeet(Meeting m) // Associa o professional ao Meet
    {
        this.meet.add(m.getName());
    }
}