package Projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Meeting implements Serializable {
    private String name;
    private int duration;
    private ArrayList<String> professional = new ArrayList<>();
    private ArrayList<String> companys = new ArrayList<>();
    private Location location;
    private ArrayList<String> interestAreas = new ArrayList<>();
    private Date date;

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


    public void associateMeetCompany(Company c) // Associa um Meeting a uma Empresa
    {
        this.companys.add(c.getName());
    }

    public void associateMeetProfessional(Professional p)
    {
        this.professional.add(p.getName());
    }

    //imprime todos os meetings
    public void printAllMeetings(RedBlackBST<Date,Meeting> meetings)
    {
        for (Date d:meetings.keys()) {
            System.out.println(d+" "+meetings.get(d));
        }
    }

    public void searchMeetingsbyDates(RedBlackBST<Date,Meeting> meetings,Date d1)
    {
        for (Date d:meetings.keys()) {
            if(meetings.get(d).getDate() == d1) {
                System.out.println(d+" "+meetings.get(d));
            }
        }
    }

    public void searchMeetingsBetweenToDates(RedBlackBST<Date,Meeting> meetings,Date d1,Date d2)
    {
        for (Date d:meetings.keys()) {
            if(meetings.get(d).getDate().afterDate(d1) && meetings.get(d).getDate().beforeDate(d2)) {

                System.out.println(d+" "+meetings.get(d));
            }
        }
    }

    public void searchMeetingsWithNParticipants(RedBlackBST<Date,Meeting> meetings, int n)
    {
        int i=1;
        for (Date d:meetings.keys()) {
            i++;
            if(i>=n){
                System.out.println(d+" "+meetings.get(d));
            }
        }
    }

    /**
     * SAVE FILES
     */
    public void write_meet_to_txt_JAVAFX(RedBlackBST<Date,Meeting> meetings, String path)
    {
        Out out = new Out(path);
        for (Date d:meetings.keys()) {
            out.print("\n");
            out.print(meetings.get(d).getName()+";"+meetings.get(d).getDate()+";"+meetings.get(d).getDuration());
        }
        out.close();
    }

    public void writeMeetingsToTXT(RedBlackBST<Date,Meeting> meetings,String path)
    {
        Out out = new Out(path);   //abre ficheiro
        for (Date d:meetings.keys()) {
            out.print("\n");
            out.print(d);
            out.print(";");
            out.print(meetings.get(d).getName());
            out.print(";");
            out.print(meetings.get(d).getCompanys());
            out.print(";");
            out.print(meetings.get(d).getDuration());
            out.print(";");
            out.print(meetings.get(d).getLocation());
            out.print(";");
            out.print(meetings.get(d).getInterestAreas());
            out.print(";");
            out.print(meetings.get(d).getProfessional());
        }
    }

    /**
     * FILES (LOAD)
     */
    public void loadMeetingsToST(RedBlackBST<Date,Meeting> meetings,String path)
    {
        In in = new In(path);
        in.readLine();
        while (!in.isEmpty()) {
            ArrayList<String> areas = new ArrayList<>();
            String[] texto = in.readLine().split(";");
            String[] d = texto[0].split("/");
            String[] l = texto[4].split(",");
            Date date = new Date(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]),0,0);
            String name = texto[1];
            Company co = new Company(texto[2],0,0,null);
            Integer dur = Integer.parseInt(texto[3]);
            Location x = new Location(Double.parseDouble(l[0]),Double.parseDouble(l[1]));
            areas.add(texto[5]);
            Professional p = new Professional(texto[6],null,null,null,null,null);

            Meeting m = new Meeting(name,dur,x,areas,date);
            meetings.put(date,m);
            m.associateMeetCompany(co);
            m.associateMeetProfessional(p);
        }
    }

    @Override
    public String toString()
    {
        return "\nName: "+this.getName()+"\nCompany: "+this.getCompanys()+"\nDuration: "+this.getDuration()+" minutes"+
                "\nLocation: "+this.getLocation()+"\nInterest Areas: "+this.getInterestAreas()
                +"\nProfessionals:"+this.getProfessional()+"\n--------------------";
    }
}