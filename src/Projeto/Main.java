package Projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
        SeparateChainingHashST_Projeto<Date,Company> company = new SeparateChainingHashST_Projeto<>();      //Date é data de registo da empresa
        SeparateChainingHashST_Projeto<Date,Professional> professionals = new SeparateChainingHashST_Projeto<>();   //Date é data de nascimento do profissional
        RedBlackBST<Date,Meeting> meetings = new RedBlackBST<>();       //Date é data de criação do meeting

        //datas de nascimento
        Date bdp1 = new Date(21,3,1996,1,0);
        Date bdp2 = new Date(10,3,1940,2,0);
        Date bdp3 = new Date(5,5,1994,3,0);
        Date bdp4 = new Date(4,7,1991,4,0);
        Date bdp5 = new Date(3,10,1993,5,0);

        //datas de registo
        Date d1r = new Date (10,5,2010,0,0);
        Date d2r = new Date (15,4,1900,0,0);
        Date d3r = new Date (7,10,1999,0,0);
        Date d4r = new Date (1,4,1900,0,0);
        Date d5r = new Date (23,10,2005,0,0);

        //datas de registo de empresas
        Date dc1 = new Date (3,5,2000,0,0);
        Date dc2 = new Date (1,5,2001,0,10);

        //datas dos meetings
        Date dm1 = new Date(7,12,2018,5,45);
        Date dm2 = new Date(6,4,2017,3,30);

        //data de entrada e saida de empresa
        Date d1in = new Date(1,1,2001,1,1);
        Date d1out = new Date(5,3,1998,0,0);

        //localizaçoes
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

        Professional p1 = new Professional("Paulo","Masculino",bdp1,skillsP1,l1);
        Professional p2 = new Professional("Sheila","Feminino",bdp2,skillsP2,l1);
        Professional p3 = new Professional("Jota","Masculino",bdp3,skillsP1,l1);
        Professional p4 = new Professional("Artur","Masculino",bdp4,skillsP2,l1);
        Professional p5 = new Professional("Pedro","Masculino",bdp5,skillsP1,l1);

        Company c1 = new Company("UFP",252252525,190190190,l2);
        Company c2 = new Company("PR MOTORS",123456789,423567437,l3);
        ///// Desempregado //////
        Company c3 =new Company("Desempregado",0,0,null);

        company.put(dc1,c1);
        company.put(dc2,c2);
        professionals.put(bdp1,p1);
        professionals.put(bdp2,p2);
        professionals.put(bdp3,p3);
        professionals.put(bdp4,p4);
        professionals.put(bdp5,p5);

        c1.registerProfessional(d1r,p1,c1);
        c1.associatePro(c1,p1);
        p1.setSalary(1000.0);

        c1.registerProfessional(d2r,p2,c1);
        c1.associatePro(c1,p2);
        p2.setSalary(5000.0);

        c1.registerProfessional(d3r,p3,c1);
        c1.associatePro(c1,p3);
        p3.setSalary(3000.0);

        c2.registerProfessional(d4r,p4,c2);
        c2.associatePro(c2,p4);
        p4.setSalary(2000.0);

        c2.registerProfessional(d5r,p5,c2);
        c2.associatePro(c2,p5);
        p5.setSalary(8000.0);

        //c1.printProForRegistrationDate();
        //c1.printProForRegistrationDate();

        //c1.searchBySkill("Video");
        //c1.printProForRegistrationDate();
        //c2.printProForRegistrationDate();

        ArrayList<String> interestAreas1 = new ArrayList<>();
        interestAreas1.add("Programacao");
        interestAreas1.add("POO");
        interestAreas1.add("APPS");

        ArrayList<String> interestAreas2 = new ArrayList<>();
        interestAreas2.add("Aprender C");

        Meeting m1 = new Meeting("Palestra JAVA",60,l4,interestAreas1,dm1);
        Meeting m2 = new Meeting("Palestra C",180,l2,interestAreas2,dm2);

        meetings.put(dm1,m1);
        meetings.put(dm2,m2);

        c1.associateCompanyMeet(m1);    //associa company a meeting
        c1.associateCompanyMeet(m2);

        m1.associateMeetCompany(c1);    //associa meeting a company
        m2.associateMeetCompany(c2);

        p1.associateProfessionalMeet(m1);   //associa profissional a meet
        p2.associateProfessionalMeet(m2);

        m1.associateMeetProfessional(p1);   //associa meet a profissional
        m1.associateMeetProfessional(p2);

        //company history // FALTAM AS DATAS !!!!!!!!!!!!!!!!!!!!!!!!

        //remove o profissional p1 da empresa c1
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p1.getName()) && professionals.get(d).getCompany()==c1)
            {
                c1.removePro(p1);

                professionals.get(d).setCompany(c3);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }

        //c1.printProForRegistrationDate();

        // Caso fique desempregado
        //p1.dissociateProCompany(p1,c3);     //passa a funçao o profissional e a company desempregado com todos os profissionais desempregados
        //p2.dissociateProCompany(p2,c3);

        // Caso mude de empresa
        //p1.changeCompany(p1,c2);
        //p1.setSalary(2000);


        //for (Date d:meetings.keys()) {                    //imprime todos os meetings
          //  System.out.println(d+" "+meetings.get(d));
       //}

//        for (Date d:company.keys()) {                     //imprime todas as companys
//        System.out.println(d+" "+company.get(d));
//        }

        for (Date d:professionals.keys()) {               //imprime todos os professionals
          System.out.println(d+" "+professionals.get(d));
        }
    }
}
