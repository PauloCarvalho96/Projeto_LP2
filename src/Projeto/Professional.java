package Projeto;

import java.util.ArrayList;

public class Professional extends Person {

    private double salary;

    private Date registration;

    private String id;

    private Company company;

    /**
     * Constructor
     */
    public Professional(String name, int age, String gender, Date date, Date date1, Location location) {
        super(name, age, gender, date);
        this.setDate(date1);
        this.setLocation(location);
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

    /**
     *
     * @element-type Skill
     */
    public ArrayList<Professional> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<Professional> skill) {
        this.skill = skill;
    }

    /**
     *
     * @element-type Meeting
     */
    public ArrayList<Professional> getMeet() {
        return meet;
    }

    public void setMeet(ArrayList<Professional> meet) {
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
    public ArrayList<Professional> getCompanyHistory() {
        return companyHistory;
    }

    public void setCompanyHistory(ArrayList<Professional> companyHistory) {
        this.companyHistory = companyHistory;
    }

    /**
     *
     * @element-type InterestAreas
     */
    public ArrayList<Professional> getInterestAreas() {
        return interestAreas;
    }

    public void setInterestAreas(ArrayList<Professional> interestAreas) {
        this.interestAreas = interestAreas;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private ArrayList<Professional> skill = new ArrayList<>();
    private ArrayList<Professional> meet = new ArrayList<>();
    private ArrayList<Professional> person = new ArrayList<>();
    private Employment employment;
    private Date date;
    private ArrayList<Professional> companyHistory = new ArrayList<>();
    private ArrayList<Professional> interestAreas = new ArrayList<>();
    private Location location;

    public int numberOfSkills(Professional p) {
        for (Professional pi:this.person) {
            if(pi.getName().compareTo(p.getName())==0)
            {
                for (Professional s:this.skill) {
                    if(s.getSkill().c)
                }
            }

        }
        return 0;
    }

    public Meeting searchMeetings(Professional p) {
        return null;
    }

}