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
        Date bdp6 = new Date(21,5,2000,12,0);

        //datas de registo
        Date d1r = new Date (10,5,2010,0,0);
        Date d2r = new Date (15,4,1900,0,0);
        Date d3r = new Date (7,10,1999,0,0);
        Date d4r = new Date (1,4,1900,0,0);
        Date d5r = new Date (23,10,2005,0,0);
        Date d6r = new Date (25,23,2009,4,6);

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
        Professional p6 = new Professional("Catarina","Feminino",bdp6,skillsP2,l2);

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

        c2.registerProfessional(d6r,p6,c2);
        c2.associatePro(c2,p6);
        p5.setSalary(10000.0);

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

        /** Company History **/
        ArrayList<CompanyHistory> professionalHp1 = new ArrayList<>();     //historico de profissional p1
        ArrayList<CompanyHistory> professionalHp2 = new ArrayList<>();     //historico de profissional p2
        ArrayList<CompanyHistory> professionalHp3 = new ArrayList<>();     //historico de profissional p3
        ArrayList<CompanyHistory> professionalHp4 = new ArrayList<>();     //historico de profissional p4
        ArrayList<CompanyHistory> professionalHp5 = new ArrayList<>();     //historico de profissional p5

        //datas de saida das empresas
        Date d1s = new Date (12,4,2015,10,0);
        Date d2s = new Date (17,4,2019,9,0);

        //remove o profissional p1 da empresa c1
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p1.getName()) && professionals.get(d).getCompany()==c1)
            {
                c1.removePro(p1);
                professionals.get(d).setCompany(c3);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }
        CompanyHistory p1h1 = new CompanyHistory(d1r,d1s,p1,c1);

        //regista na empresa c2
        c2.registerProfessional(d1r,p1,c2);
        c2.associatePro(c2,p1);
        p1.setSalary(1000.0);

        //remove da empresa c2 e mete a desempregado
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p1.getName()) && professionals.get(d).getCompany()==c2)
            {
                c2.removePro(p1);
                professionals.get(d).setCompany(c3);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }
        //CompanyHistory p1h2 = new CompanyHistory(d1s,d2s,p1,c2);

        //adiciona ao historico de empresas
        //professionalHp1.add(p1h1);
        //professionalHp1.add(p1h2);

        //imprime historico de empresas de p1
        //for (CompanyHistory h:professionalHp1) {
            //System.out.println(h);
          //  System.out.println("Experiencia: "+h.YearsExperience(h.getIn(),h.getOut())+" anos");
        //}

        //c1.printProForRegistrationDate();
        //c2.printProForRegistrationDate();

        //imprime todos os profissionais desempregados
//        for (Date d:professionals.keys()) {
//            if(professionals.get(d).getCompany().getName().contains(c3.getName()))
//            {
//                System.out.println(professionals.get(d));
//            }
//        }

        //imprime todos os meetings
//        for (Date d:meetings.keys()) {                    //imprime todos os meetings
//            System.out.println(d+" "+meetings.get(d));
//       }

          //imprime todas as empresas
//        for (Date d:company.keys()) {                     //imprime todas as companys
//        System.out.println(d+" "+company.get(d));
//        }

        //imprime o numero de funcionários de uma empresa
        c2.numberOfProfessionals();

          //imprime todos os profissionais
//        for (Date d:professionals.keys()) {               //imprime todos os professionals
//          System.out.println(d+" "+professionals.get(d));
//        }
    }
}
