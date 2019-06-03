package Projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;

import java.io.Serializable;
import java.util.ArrayList;
import static Projeto.Fase2_JavaFX.GraphCreator.professionals;
import static Projeto.Fase2_JavaFX.GraphCreator.company;
import static Projeto.Fase2_JavaFX.GraphCreator.meetings;
import static Projeto.Fase2_JavaFX.GraphCreator.pontosDeEncontro;

public class Professional extends Person implements Serializable {
    private double salary;

    private Date registration;

    private Company company;

    private String company_name;

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
                "\nNIF:"+getNif()+"\nSkills: "+this.getSkills()+ "\nLocation: "+this.getLocation()+"\nSalary: "+this.getSalary()+"\nMeetings: "+this.getMeet()+
                "\nCompany History: "+this.getCompanyHistory()+"\n--------------------";
    }

    /**
     * Constructor
     */

    public Professional(String name,String gender,Date birth, ArrayList<String> skills, Location location,Integer nif) {
        super(name,gender,birth,nif);
        this.setSkills(skills);
        this.setLocation(location);
    }

    /**
     * Gets and Sets
     */

    public double getSalary() {
        return salary;
    }

    public String getCompany_name() {
        return getCompany().getName();
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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

    public void searchProfessionalBySalary(int s)
    {
        for (Integer d : professionals.keys()) {
            if (professionals.get(d).getSalary() == s) {
                System.out.println("" + professionals.get(d));
            }
        }

    }

    public void searchProfessionalByLocation(Location l)
    {
        for (Integer d : professionals.keys()) {
            if (professionals.get(d).getLocation() == l) {
                System.out.println("" + professionals.get(d));
            }
        }
    }

    public void printAllProfessionals()
    {
        for (Integer d:professionals.keys()) {
            System.out.println(d+" "+professionals.get(d));
        }
    }

    public void searchProfessionalByName(String n)
    {
        for (Integer d : professionals.keys()) {
            if (professionals.get(d).getName().equals(n)) {
                System.out.println("" + professionals.get(d));
            }
        }
    }

    public void searchProfessionalByNif(Integer n)
    {
        for (Integer d : professionals.keys()) {
            if (professionals.get(d).getNif().equals(n)) {
                System.out.println("" + professionals.get(d));
            }
        }
    }

    /**
     * SAVE FILES
     */
    public void writeProfessionalsToTXT(String path)
    {
        Out out = new Out(path);   //abre ficheiro
        for (Integer d:professionals.keys()) {
            out.print("\n");
            out.print(d);
            out.print(";");
            out.print(professionals.get(d).getCompany().getName());
            out.print(";");
            out.print(professionals.get(d).getName());
            out.print(";");
            out.print(professionals.get(d).getBirth_date());
            out.print(";");
            out.print(professionals.get(d).getGender());
            out.print(";");
            out.print(professionals.get(d).getSkills());
            out.print(";");
            out.print(professionals.get(d).getLocation());
            out.print(";");
            out.print(professionals.get(d).getSalary());
            out.print(";");
            out.print(professionals.get(d).getMeet());
            out.print(";");
            out.print(professionals.get(d).getCompanyHistory());
        }
        out.close();
    }

    /**
     * FILES (LOAD)
     */
    public void loadProfessionalsToST(String path)
    {
        In in = new In(path);
        in.readLine();
        while (!in.isEmpty()) {
            ArrayList<String> areas = new ArrayList<>();
            String[] texto = in.readLine().split(";");
            String[] d = texto[0].split("/");
            String[] d2 = texto[3].split("/");
            String[] l = texto[6].split(",");
            Date date_key = new Date(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]),0,0);
            String CompanyName = texto[1];
            String name = texto[2];
            Date date_birth = new Date(Integer.parseInt(d2[0]),Integer.parseInt(d2[1]),Integer.parseInt(d2[2]),0,0);
            String gender = texto[4];
            areas.add(texto[5]);
            Location x = new Location(Double.parseDouble(l[0]),Double.parseDouble(l[1]));
            Double salary = Double.parseDouble(texto[7]);
            String meets = texto[8];
            String ch = texto[9];
            Meeting m = new Meeting(meets,0,null,null,null);
            Professional p = new Professional(name,gender,date_birth,areas,x,null);
            Company c2 = new Company(ch,0,0,null);
            Company c = new Company(CompanyName,0,0,null);
//            professionals.put(,p);
            p.setCompany(c);
            p.setSalary(salary);
            p.associateProfessionalMeet(m);
            p.addCompanyHistoryToPro(c2);
        }
        in.close();
    }
}