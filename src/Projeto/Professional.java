package Projeto;

import java.util.ArrayList;

public class Professional extends Person {

    private double salary;

    private Date registration;

    private String id;

    private Company company;

    private int numberSkills=0; //////////////////////////////////

    private ArrayList<String> skills = new ArrayList<>();

    @Override
    public String toString()
    {
        return "name:"+this.getName()+"\nage: "+this.getAge()+"\nsexo :"+this.getGender()+"\nSkills: "+this.getSkills()+"\nNumber Skills: "+this.getNumberSkills()+"\n";

    }

    /**
     * Constructor
     */
    public Professional(String name, int age, String gender, Date registration, ArrayList<String> skills, Location location) {
        super(name, age, gender);
        this.setRegistration(registration);
        this.setSkills(skills);
        this.setLocation(location);
    }

    /**
     * Gets and Sets
     */

    public double getSalary() {
        return salary;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public int getNumberSkills() { /////////////////////////////////////////////////////////////////77
        return numberSkills;
    }

    public void setNumberSkills(int numberSkills) { //////////////////////////////////////////7
        this.numberSkills = numberSkills;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @element-type Meeting
     */
    public ArrayList<Meeting> getMeet() {
        return meet;
    }

    public void setMeet(ArrayList<Meeting> meet) {
        this.meet = meet;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    /**
     *
     * @element-type CompanyHistory
     */
    public ArrayList<CompanyHistory> getCompanyHistory() {
        return companyHistory;
    }

    public void setCompanyHistory(ArrayList<CompanyHistory> companyHistory) {
        this.companyHistory = companyHistory;
    }

    /**
     *
     * @element-type InterestAreas
     */
    public ArrayList<InterestAreas> getInterestAreas() {
        return interestAreas;
    }

    public void setInterestAreas(ArrayList<InterestAreas> interestAreas) {
        this.interestAreas = interestAreas;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private ArrayList<Meeting> meet = new ArrayList<>();
    private Person person;
    private Employment employment;
    private Date date;
    private ArrayList<CompanyHistory> companyHistory = new ArrayList<>();
    private ArrayList<InterestAreas> interestAreas = new ArrayList<>();
    private Location location;

    public int numberOfSkills(String s) { //////////////// ESTA MAL, NAO SEI COMO FAZER !!!!!!!!!!!!!!!!!!!!!
        for (String si:this.getSkills()) {
            if(si.contains(s))
            {
                this.numberSkills++;
            }
        }
        return 0;
    }

    public Meeting searchMeetings(Professional p) {
        return null;
    }

}