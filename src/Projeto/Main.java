package Projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
        SeparateChainingHashST_Projeto<Date,Company> company = new SeparateChainingHashST_Projeto<>();
        SeparateChainingHashST_Projeto<Date,Professional> professionals = new SeparateChainingHashST_Projeto<>();
        RedBlackBST<Date,Meeting> meetings = new RedBlackBST<>();

        Date d1r = new Date (10,5,2010,0,0);
        Date d2r = new Date (15,4,1900,0,0);
        Date d3r = new Date (7,10,1999,0,0);
        Date d4r = new Date (1,4,1900,0,0);
        Date d5r = new Date (23,10,2005,0,0);
        Date dc1 = new Date (3,5,2000,0,0);
        Date dc2 = new Date (1,5,2001,0,10);
        Date dm1 = new Date(7,12,2018,5,45);

        Location l1 = new Location(10,10);
        Location l2 = new Location(1,1);
        Location l3 = new Location(4,5);
        Location l4 = new Location(50,30);

        ArrayList<String> skillsP1 = new ArrayList<>();
        skillsP1.add("Programacao C");
        skillsP1.add("Programacao JAVA");
        ArrayList<String> skillsP2 = new ArrayList<>();
        skillsP2.add("Fotografia");
        skillsP2.add("Video");

        Professional p1 = new Professional("Paulo",23,"Masculino",skillsP1,l1,null,0.0);
        Professional p2 = new Professional("Sheila",69,"Feminino",skillsP2,l1,null,0.0);
        Professional p3 = new Professional("Jota",32,"Masculino",skillsP1,l1,null,0.0);
        Professional p4 = new Professional("Artur",99,"Masculino",skillsP2,l1,null,0.0);
        Professional p5 = new Professional("Pedro",20,"Masculino",skillsP1,l1,null,0.0);

        Company c1 = new Company("UFP",252252525,190190190,l2);
        Company c2 = new Company("PR MOTORS",123456789,423567437,l3);

        company.put(dc1,c1);
        company.put(dc2,c2);
        professionals.put(d1r,p1);
        professionals.put(d2r,p2);
        professionals.put(d3r,p3);
        professionals.put(d4r,p4);
        professionals.put(d5r,p5);

        p1.setId("1");
        p2.setId("2");
        p3.setId("3");
        p4.setId("4");
        p5.setId("5");
        p1.setSalary(1000.0);
        p2.setSalary(5000.0);
        p3.setSalary(3000.0);
        p4.setSalary(2000.0);
        p5.setSalary(8000.0);
        c1.registerProfessional(d1r,p1);
        c1.associatePro(c1,p1);
        c1.registerProfessional(d2r,p2);
        c1.associatePro(c1,p2);
        c1.registerProfessional(d3r,p3);
        c1.associatePro(c1,p3);
        c2.registerProfessional(d4r,p4);
        c2.associatePro(c2,p4);
        c2.registerProfessional(d5r,p5);
        c2.associatePro(c2,p5);

        //c1.removeFromCompany(p1);
        //c1.printProForRegistrationDate();
        //c1.unregisterProfessional(d1r);
        //c1.printProForRegistrationDate();
        //c1.editProfessional(d1r,d4r,p4);
        //c1.searchBySkill("Video");
        //c1.printProForRegistrationDate();
        //c2.printProForRegistrationDate();

        //for (Date d:professionals.keys()) {
          //  System.out.println(d+" "+professionals.get(d));
        //}

        //for (Date d:company.keys()) {
          //  System.out.println(d+" "+company.get(d));
        //}

        ArrayList<String> interestAreas1 = new ArrayList<>();
        interestAreas1.add("Programacao");
        interestAreas1.add("POO");
        interestAreas1.add("APPS");

        Meeting m1 = new Meeting("Palestra JAVA",60,l4,interestAreas1,dm1);

        meetings.put(dm1,m1);
        c1.associateMeet(m1);       //associa company a meeting
        m1.associateMeetCompany(c1);    //associa meeting a company

        //for (Date d:meetings.keys()) {
          //  System.out.println(d+" "+meetings.get(d));
        //}

        for (Date d:company.keys()) {
          System.out.println(d+" "+company.get(d));
        }

    }
}
