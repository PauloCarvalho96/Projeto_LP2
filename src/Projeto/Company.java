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
        this.setName(name);
        this.setPhone(phone);
        this.setNif(nif);
        this.setLocation(location);
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
    public ArrayList<Company> getMeet() {
        return meet;
    }

    public void setMeet(ArrayList<Company> meet) {
        this.meet = meet;
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

    public Projeto.GestaoDeEmpresas getGestaoDeEmpresas() {
        return GestaoDeEmpresas;
    }

    public void setGestaoDeEmpresas(Projeto.GestaoDeEmpresas gestaoDeEmpresas) {
        GestaoDeEmpresas = gestaoDeEmpresas;
    }

    private RedBlackBST<Date,Professional> professional = new RedBlackBST<>();

    private ArrayList<Company> meet = new ArrayList<>();
    private Location location;
    private GestaoDeEmpresas GestaoDeEmpresas;

    public void registerProfessional(Date d,Professional p) {      //adiciona profissional a empresa
        this.professional.put(d,p);
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

    public void editProfessional(Date d, Date nd,Professional np)       //edita o profissional
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

}