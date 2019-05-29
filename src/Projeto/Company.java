package Projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
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
        p.setCompany(c);
    }

    public void associateCompanyMeet(Meeting m) // Associa uma company a um meeting
    {
        this.meeting.add(m.getName());
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
    public void removeProfessionalCompany(SeparateChainingHashST_Projeto<Integer,Professional> professionals,Professional p,Company c,Company c4)
    {
        for (Integer d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p.getName()) && professionals.get(d).getCompany()==c)
            {
                c.removePro(p);
                professionals.get(d).setCompany(c4);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }
    }

    //remove empresa
    public void removeCompany(SeparateChainingHashST_Projeto<Integer,Company> company, Company c,SeparateChainingHashST_Projeto<Integer,Professional> professionals,Company c4)
    {
        for (Integer d:company.keys()) {
            if(company.get(d)==c)
            {
                if(company.get(d).numberOfProfessionals(c)>0)   //se tiver funcionarios entao ficam todos desempregados
                {
                    for (Integer di:professionals.keys()) {        //percorre os profissionais
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

    //edita empresa
    public void editCompanyPhone(SeparateChainingHashST_Projeto<Integer,Company> company,Company c,int nphone)
    {
        for (Integer d:company.keys()) {
            if(company.get(d)==c)
            {
                company.get(d).setPhone(nphone);
            }
        }
    }

    public void editCompanyNif(SeparateChainingHashST_Projeto<Integer,Company> company,Company c,int nNif)
    {
        for (Integer d:company.keys()) {
            if(company.get(d)==c)
            {
                company.get(d).setNif(nNif);
            }
        }
    }

    public void editCompanyLocation(SeparateChainingHashST_Projeto<Integer,Company> company, Company c,Location x)
    {
        for (Integer d:company.keys()) {
            if(company.get(d)==c)
            {
                company.get(d).setLocation(x);
            }
        }
    }

    public void editCompanyName(SeparateChainingHashST_Projeto<Integer,Company> company, Company c,String nName)
    {
        for (Integer d:company.keys()) {
            if(company.get(d)==c)
            {
                company.get(d).setName(nName);
            }
        }
    }

    //imprime funcionarios sem trabalho
    public void printProWithoutCompany(SeparateChainingHashST_Projeto<Integer,Professional> professionals, Company c4)
    {
        int i =0;
        for (Integer d:professionals.keys()) {
            if(professionals.get(d).getCompany().getName().contains(c4.getName()))
            {
                System.out.println(professionals.get(d));
                i++;
            }
        }
        System.out.println("Profissinais desempregados: "+i);
    }

    //imprime todas as empresas
    public void printAllCompanys(SeparateChainingHashST_Projeto<Integer,Company> company)
    {
        for (Integer d:company.keys()) {
            System.out.println(d+" "+company.get(d));
        }
    }
    public void searchCompanybynif(SeparateChainingHashST_Projeto<Integer,Company> company,int n)
    {
        for (Integer d:company.keys()) {
            if(company.get(d).getNif()==n)
            System.out.println("Company: "+company.get(d));
        }
    }

    public void searchCompanybyname(SeparateChainingHashST_Projeto<Integer,Company> company,String n)
    {
        for (Integer d:company.keys()) {
            if(company.get(d).getName().equals(n))
                System.out.println("Company: "+company.get(d));
        }
    }

    public void searchCompanybyphone(SeparateChainingHashST_Projeto<Integer,Company> company,int p)
    {
        for (Integer d:company.keys()) {
            if(company.get(d).getPhone()==p)
                System.out.println("Company: "+company.get(d));
        }
    }

    public void searchCompanybylocation(SeparateChainingHashST_Projeto<Integer,Company> company,Location l)
    {
        for (Integer d:company.keys()) {
            if(company.get(d).getLocation()==l)
                System.out.println("Company: "+company.get(d));
        }
    }

    /**
     * SAVE FILES
     */
    public void writeCompanysToTXT(SeparateChainingHashST_Projeto<Integer,Company> company, String path)
    {
        Out out = new Out(path);   //abre ficheiro
        for (Integer d:company.keys()) {
            out.print("\n");
            out.print(d);
            out.print(";");
            out.print(company.get(d).getName());
            out.print(";");
            out.print(company.get(d).getPhone());
            out.print(";");
            out.print(company.get(d).getNif());
            out.print(";");
            out.print(company.get(d).getLocation());
            out.print(";");
            out.print(company.get(d).getMeeting());
        }
    }

    /**
     * FILES (LOAD)
     */
    public void loadCompanyToST(SeparateChainingHashST_Projeto<Integer,Company> company, String path)
    {
        In in = new In(path);
        in.readLine();
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String[] d = texto[0].split("/");
            String[] l = texto[4].split(",");
//            Date date = new Date(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]),0,0);
            String name = texto[1];
            Integer phone = Integer.parseInt(texto[2]);
            Integer nif = Integer.parseInt(texto[3]);
            Location x = new Location(Double.parseDouble(l[0]),Double.parseDouble(l[1]));
            Meeting m = new Meeting(texto[5],0,null,null,null);
            Company c = new Company(name,phone,nif,x);
            company.put(nif,c);
            c.associateCompanyMeet(m);
        }
    }

    @Override
    public String toString()
    {
        return "\nName: "+this.getName()+"\nPhone: "+this.getPhone()+"\nnif: "+this.getNif()+"\nlocation: "+this.getLocation()+
                "\nMeetings: "+this.getMeeting()+"\n---------------";
    }
}