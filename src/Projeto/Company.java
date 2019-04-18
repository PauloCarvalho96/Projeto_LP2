package Projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;

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


    public void registerProfessional(Date d,Professional p,Company c,double salary) {      //adiciona profissional a empresa
        this.professional.put(d,p);
        p.addCompanyHistoryToPro(c);
        p.setSalary(salary);
    }

    public void associateCompanyMeet(Meeting m) // Associa uma company a um meeting
    {
        this.meeting.add(m.getName());
    }

    public void associatePro(Company c, Professional p)     //associa um profissional a uma empresa
    {
        p.setCompany(c);
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

    public void removePro(Professional p)       //elimina profissional da empresa
    {
        for (Date d:professional.keys()) {
            if(professional.get(d).getName().contains(p.getName())) {
                professional.delete(d);
            }
        }
    }
    public int numberOfProfessionals(Company c){
        int i = 0;
        for (Date d:this.professional.keys()) {
            if(professional.get(d).getCompany()==c)
            {
                i++;
            }
        }
        return i;
    }

    //remove professional da company
    public void removeProfessionalCompany(SeparateChainingHashST_Projeto<Date,Professional> professionals,Professional p,Company c,Company c4)
    {
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p.getName()) && professionals.get(d).getCompany()==c)
            {
                c.removePro(p);
                professionals.get(d).setCompany(c4);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }
    }

    public void removeCompany(SeparateChainingHashST_Projeto<Date,Company> company, Company c,SeparateChainingHashST_Projeto<Date,Professional> professionals,Company c4)
    {
        for (Date d:company.keys()) {
            if(company.get(d)==c)
            {
                if(company.get(d).numberOfProfessionals(c)>0)   //se tiver funcionarios entao ficam todos desempregados
                {
                    for (Date di:professionals.keys()) {        //percorre os profissionais
                        if(professionals.get(di).getCompany()==c)    //se a empresa for a que se quer eliminar mete se o pro desempregado
                        {
                            removePro(professionals.get(di));
                            professionals.get(di).setCompany(c4);
                            professionals.get(di).setSalary(0.0);
                        }
                    }
                }
                company.delete(d);      //elimina a empresa
            }
        }
    }

    //imprime funcionarios sem trabalho
    public void printProWithoutCompany(SeparateChainingHashST_Projeto<Date,Professional> professionals, Company c4)
    {
        int i =0;
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getCompany().getName().contains(c4.getName()))
            {
                System.out.println(professionals.get(d));
                i++;
            }
        }
        System.out.println("Profissinais desempregados: "+i);
    }

    //imprime todas as empresas
    public void printAllCompanys(SeparateChainingHashST_Projeto<Date,Company> company)
    {
        for (Date d:company.keys()) {
            System.out.println(d+" "+company.get(d));
        }
    }
    public void searchCompanybynif(SeparateChainingHashST_Projeto<Date,Company> company,int n)
    {
        for (Date d:company.keys()) {
            if(company.get(d).getNif()==n)
            System.out.println("Company: "+company.get(d));
        }
    }

    public void searchCompanybyname(SeparateChainingHashST_Projeto<Date,Company> company,String n)
    {
        for (Date d:company.keys()) {
            if(company.get(d).getName()==n)
                System.out.println("Company: "+company.get(d));
        }
    }

    public void searchCompanybyphone(SeparateChainingHashST_Projeto<Date,Company> company,int p)
    {
        for (Date d:company.keys()) {
            if(company.get(d).getPhone()==p)
                System.out.println("Company: "+company.get(d));
        }
    }

    public void searchCompanybylocation(SeparateChainingHashST_Projeto<Date,Company> company,Location l)
    {
        for (Date d:company.keys()) {
            if(company.get(d).getLocation()==l)
                System.out.println("Company: "+company.get(d));
        }
    }

    @Override
    public String toString()
    {
        return "\nName: "+this.getName()+"\nPhone: "+this.getPhone()+"\nnif: "+this.getNif()+"\nlocation: "+this.getLocation()+
                "\nMeetings: "+this.getMeeting()+"\n---------------";
    }
}