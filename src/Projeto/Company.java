package Projeto;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;

public class Company {

    private String name;

    private int phone;

    private int nif;


    /**
     * Constructor
     */
    public Company(String name, int phone, int nif, Location location) {
        this.name = name;
        this.phone = phone;
        this.nif = nif;
        this.location = location;
    }


    public RedBlackBST<Date, Professional> getProfessional() {
        return professional;
    }

    public void setProfessional(RedBlackBST<Date, Professional> professional) {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     *
     * @element-type Meeting
     */
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    private RedBlackBST<Date,Professional> professional = new RedBlackBST<>();

    private Location location;

    private ArrayList<String> meeting = new ArrayList<>();


    public void registerProfessional(Date d,Professional p) {      //adiciona profissional a empresa
        this.professional.put(d,p);
    }

    public void associateCompanyMeet(Meeting m) // Associa uma company a um meeting
    {
        this.setMeeting(m.getInterestAreas());
    }

    public void associatePro(Company c, Professional p)     //associa um profissional a uma empresa
    {
        p.setCompany(c);
    }

    public void unregisterProfessional(Date d) {     //remove um profissional da empresa
        this.professional.delete(d);
    }

    public void printProForRegistrationDate()   //imprime os profissionais da empresa por data de registo
    {
        for (Date d:professional.keys()) {
            System.out.println(d+" "+professional.get(d));
        }
    }

    public ArrayList<String> getMeeting() {
        return meeting;
    }

    public void setMeeting(ArrayList<String> meeting) {
        this.meeting = meeting;
    }

    public void editProfessional(Date d, Date nd, Professional np)       //edita o profissional
    {
        for (Date di:professional.keys()) {
            if(di.compareTo(d)==0)
            {
                unregisterProfessional(d);
                registerProfessional(nd,np);
            }
            }
    }

    public Meeting searchMettings(int nif) {
        return null;
    }

    public Professional searchEmployer(int id) {
        return null;
    }

    public Integer numberEmployes(int nif) {
        return null;
    }

    public Professional olderProfessional(int nif,  Date d) {
        return null;
    }

    public Professional newestProfessional(int nif,  Date d) {
        return null;
    }

    public Professional highestSalary(int nif,  Professional p) {
        return null;
    }

    public String searchBySkill(String skill)       //procura profissionais com uma determinada skill na empresa
    {
        for (Date d:professional.keys()) {
            if(professional.get(d).getSkills().contains(skill))
            {
                System.out.println("Name: "+professional.get(d).getName()+"\nSkill: "+skill);
            }
        }
        return null;
    }

    public void removeFromCompany(Professional p)     //remove da empresa
    {
        p.setCompany(null);
        p.setSalary(0.0);
        p.setId(null);
    }

    @Override
    public String toString()
    {
        return "\nName: "+this.getName()+"\nPhone: "+this.getPhone()+"\nnif: "+this.getNif()+"\nlocation: "+this.getLocation()+
                "\nMeetings: "+this.getMeeting()+"\n---------------";
    }
}