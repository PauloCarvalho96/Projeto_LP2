/**
 * Projeto realizado por:
 *
 * ************************
 * Paulo Carvalho nº37113 *
 * Pedro Pinheiro nº36763 *
 **************************
 *
 * Linguagens de Programação II / Algoritmos e Estruturas de Dados II
 * 1º Fase
 *
 * Universidade Fernando Pessoa
 *
 */

package Projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
        SeparateChainingHashST_Projeto<Date,Company> company = new SeparateChainingHashST_Projeto<>();      //Date é data de registo da empresa
        SeparateChainingHashST_Projeto<Date,Professional> professionals = new SeparateChainingHashST_Projeto<>();   //Date é data de nascimento do profissional
        RedBlackBST<Date,Meeting> meetings = new RedBlackBST<>();       //Date é data de criação do meeting

        //datas de nascimento
        Date bdp1 = new Date(21,3,1996,3,34);
        Date bdp2 = new Date(10,3,1940,6,47);
        Date bdp3 = new Date(5,5,1994,12,23);
        Date bdp4 = new Date(4,7,1991,17,11);
        Date bdp5 = new Date(3,10,1993,11,1);
        Date bdp6 = new Date(21,6,2001,23,57);
        Date bdp7 = new Date(6,10,1975,12,30);
        Date bdp8 = new Date(9,1,1987,5,37);
        Date bdp9 = new Date(28,3,1973,1,21);
        Date bdp10 = new Date(30,12,1964,12,60);

        //datas de registo
        Date d1r = new Date (10,5,2010,4,30);
        Date d2r = new Date (15,4,1970,1,53);
        Date d3r = new Date (7,10,1999,3,24);
        Date d4r = new Date (1,4,2005,11,56);
        Date d5r = new Date (23,10,2005,16,13);
        Date d6r = new Date (25,4,2009,20,3);
        Date d7r = new Date (2,3,1997,8,50);
        Date d8r = new Date (2,11,2002,4,45);
        Date d9r = new Date (25,8,1996,21,43);
        Date d10r = new Date (1,1,1987,19,16);

        //datas de saida das empresas
        Date d1s = new Date (12,4,2015,10,11);
        Date d2s = new Date (17,4,2017,3,36);
        Date d3s = new Date (17,4,2014,6,34);
        Date dHoje = new  Date(20,4,2019,6,60);

        //datas de registo de empresas
        Date dc1 = new Date (3,5,2000,5,45);
        Date dc2 = new Date (1,7,1930,3,49);
        Date dc3 = new Date (6,11,1946,9,11);

        //datas dos meetings
        Date dm1 = new Date(7,12,2018,5,45);
        Date dm2 = new Date(6,4,2017,3,30);
        Date dm3 = new Date(8,3,2004,6,21);

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
        ArrayList<String> skillsP3 = new ArrayList<>();
        skillsP3.add("Base de dados");
        skillsP3.add("Computacao");
        ArrayList<String> skillsP4 = new ArrayList<>();
        skillsP4.add("Ruby");
        skillsP4.add("PHP");
        ArrayList<String> skillsP5 = new ArrayList<>();
        skillsP5.add("Programacao c++");
        skillsP5.add("Programacao c#");

        Professional p1 = new Professional("Paulo","Masculino",bdp1,skillsP1,l1);
        Professional p2 = new Professional("Carolina","Feminino",bdp2,skillsP2,l1);
        Professional p3 = new Professional("Jota","Masculino",bdp3,skillsP1,l1);
        Professional p4 = new Professional("Artur","Masculino",bdp4,skillsP2,l1);
        Professional p5 = new Professional("Pedro","Masculino",bdp5,skillsP1,l1);
        Professional p6 = new Professional("Catarina","Feminino",bdp6,skillsP2,l2);
        Professional p7 = new Professional("Joana","Feminino",bdp7,skillsP3,l3);
        Professional p8 = new Professional("Maria","Feminino",bdp8,skillsP4,l4);
        Professional p9 = new Professional("Osvaldo","Feminino",bdp9,skillsP5,l2);
        Professional p10 = new Professional("Andre","Feminino",bdp10,skillsP3,l3);

        Company c1 = new Company("UFP",252252525,190190190,l2);
        Company c2 = new Company("PR MOTORS",252759021,423567437,l3);
        Company c3 = new Company("Fotogrupo",252846792,425678241,l4);
        ///// Desempregado //////
        Company c4 =new Company("Desempregado",0,0,null);

        company.put(dc1,c1);
        company.put(dc2,c2);
        company.put(dc3,c3);

        professionals.put(bdp1,p1);
        professionals.put(bdp2,p2);
        professionals.put(bdp3,p3);
        professionals.put(bdp4,p4);
        professionals.put(bdp5,p5);
        professionals.put(bdp6,p6);
        professionals.put(bdp7,p7);
        professionals.put(bdp8,p8);
        professionals.put(bdp9,p9);
        professionals.put(bdp10,p10);

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

        c3.registerProfessional(d6r,p6,c3);
        c3.associatePro(c3,p6);
        p6.setSalary(10000.0);

        c3.registerProfessional(d7r,p7,c3);
        c3.associatePro(c3,p7);
        p7.setSalary(1000.0);

        c3.registerProfessional(d8r,p8,c3);
        c3.associatePro(c3,p8);
        p8.setSalary(650.0);

        c3.registerProfessional(d9r,p9,c3);
        c3.associatePro(c3,p9);
        p9.setSalary(850.0);

        c3.registerProfessional(d10r,p10,c3);
        c3.associatePro(c3,p10);
        p10.setSalary(650.0);

        //c1.searchBySkill("Video");

        ArrayList<String> interestAreas1 = new ArrayList<>();
        interestAreas1.add("Programacao");
        interestAreas1.add("POO");
        interestAreas1.add("APPS");

        ArrayList<String> interestAreas2 = new ArrayList<>();
        interestAreas2.add("Aprender C");

        ArrayList<String> interestAreas3 = new ArrayList<>();
        interestAreas3.add("Fotografia");

        Meeting m1 = new Meeting("Palestra JAVA",60,l4,interestAreas1,dm1);
        Meeting m2 = new Meeting("Palestra C",180,l2,interestAreas2,dm2);
        Meeting m3 = new Meeting("Photoshop",120,l2,interestAreas3,dm3);

        meetings.put(dm1,m1);
        meetings.put(dm2,m2);
        meetings.put(dm3,m3);

        c1.associateCompanyMeet(m1);    //associa company a meeting
        c1.associateCompanyMeet(m2);
        c2.associateCompanyMeet(m2);
        c3.associateCompanyMeet(m3);

        m1.associateMeetCompany(c1);    //associa meeting a company
        m2.associateMeetCompany(c1);
        m2.associateMeetCompany(c2);
        m3.associateMeetCompany(c3);

        p1.associateProfessionalMeet(m1);   //associa profissional a meet
        p2.associateProfessionalMeet(m2);
        p3.associateProfessionalMeet(m1);
        p4.associateProfessionalMeet(m2);
        p5.associateProfessionalMeet(m2);
        p6.associateProfessionalMeet(m3);
        p7.associateProfessionalMeet(m3);
        p8.associateProfessionalMeet(m3);
        p9.associateProfessionalMeet(m3);
        p10.associateProfessionalMeet(m3);

        m1.associateMeetProfessional(p1);   //associa meet a profissional
        m2.associateMeetProfessional(p2);
        m1.associateMeetProfessional(p3);
        m2.associateMeetProfessional(p4);
        m2.associateMeetProfessional(p5);
        m3.associateMeetProfessional(p6);
        m3.associateMeetProfessional(p7);
        m3.associateMeetProfessional(p8);
        m3.associateMeetProfessional(p9);
        m3.associateMeetProfessional(p10);

        /** Company History **/
        ArrayList<CompanyHistory> professionalHp1 = new ArrayList<>();     //historico de profissional p1
        ArrayList<CompanyHistory> professionalHp2 = new ArrayList<>();     //historico de profissional p2
        ArrayList<CompanyHistory> professionalHp3 = new ArrayList<>();     //historico de profissional p3
        ArrayList<CompanyHistory> professionalHp4 = new ArrayList<>();     //historico de profissional p4
        ArrayList<CompanyHistory> professionalHp5 = new ArrayList<>();     //historico de profissional p5
        ArrayList<CompanyHistory> professionalHp6 = new ArrayList<>();     //historico de profissional p6
        ArrayList<CompanyHistory> professionalHp7 = new ArrayList<>();     //historico de profissional p7
        ArrayList<CompanyHistory> professionalHp8 = new ArrayList<>();     //historico de profissional p8
        ArrayList<CompanyHistory> professionalHp9 = new ArrayList<>();     //historico de profissional p9
        ArrayList<CompanyHistory> professionalHp10 = new ArrayList<>();    //historico de profissional p10

        /**
         * Profissional P1
         */
        //remove o profissional p1 da empresa c1
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p1.getName()) && professionals.get(d).getCompany()==c1)
            {
                c1.removePro(p1);
                professionals.get(d).setCompany(c4);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }

        //regista p1 na c2
        c2.registerProfessional(d1r,p1,c2);
        c2.associatePro(c2,p1);
        p1.setSalary(1000.0);

        // adiciona ao historico de empresas de p1
        CompanyHistory p1h1 = new CompanyHistory(d1r,d1s,p1,c1);
        professionalHp1.add(p1h1); // p1 -> empresa 1

        //remove p1 de c2
        for (Date d:professionals.keys()) {
            if(professionals.get(d).getName().equals(p1.getName()) && professionals.get(d).getCompany()==c2)
            {
                c2.removePro(p1);
                professionals.get(d).setCompany(c4);    //desempregado
                professionals.get(d).setSalary(0.0);
            }
        }

        // adiciona ao historico de empresas de p1
        CompanyHistory p1h2 = new CompanyHistory(d1s,d2s,p1,c2);
        professionalHp1.add(p1h2); // p1 -> empresa 2


//        c3.registerProfessional(d4r,p4,c3);
//        c3.associatePro(c3,p4);
//        p4.setSalary(1200);
//
//        c1.registerProfessional(d9r,p9,c1);
//        c1.associatePro(c1,p9);
//        p9.setSalary(2300);

//        CompanyHistory p4h1 = new CompanyHistory(d4r,d2s,p4,c2);
//        CompanyHistory p9h1 = new CompanyHistory(d9r,d3s,p9,c3);

//        CompanyHistory p4h2 = new CompanyHistory(d2s,dHoje,p4,c3);
//        CompanyHistory p9h2 = new CompanyHistory(d3s,dHoje,p9,c1);

//        professionalHp4.add(p4h1);// p4 -> empresa 2
//        professionalHp4.add(p4h2);// p4 -> empresa 3

//        professionalHp9.add(p9h1);// p9 -> empresa 3
//        professionalHp9.add(p9h2);// p9 -> empresa 1

        /**
         * Prints
         */

        //para imprimir o historico criou se um objeto para aceder a funçao
        CompanyHistory print = new CompanyHistory(null,null,null,null);

        //imprime historico de empresas de p1
        print.printCompanyHistoric(professionalHp1);

        //imprime historico de empresas de p4
        //for (CompanyHistory h:professionalHp4) {
         //   System.out.println(h);
         //   System.out.println("Experiencia: "+h.YearsExperience(h.getIn(),h.getOut())+" anos");
        //}

        //imprime profissionais de cada empresa
//        c1.printProForRegistrationDate();
//        c2.printProForRegistrationDate();
//        c3.printProForRegistrationDate();

        //imprime todos os profissionais desempregados
        //int i =0;
        //for (Date d:professionals.keys()) {
            //if(professionals.get(d).getCompany().getName().contains(c4.getName()))
            //{
              //  System.out.println(professionals.get(d));
            //    i++;
          //  }
        //}
        //System.out.println("Profissinais desempregados: "+i);

        //imprime todos os meetings
        //for (Date d:meetings.keys()) {                    //imprime todos os meetings
         //   System.out.println(d+" "+meetings.get(d));
       //}

          //imprime todas as empresas e numero de profissionais
        //for (Date d:company.keys()) {
        //System.out.println(d+" "+company.get(d));
        //}
        //c1.numberOfProfessionals(c1);
        //c2.numberOfProfessionals(c2);
        //c3.numberOfProfessionals(c3);

//          imprime todos os profissionais
//        for (Date d:professionals.keys()) {               //imprime todos os professionals
//          System.out.println(d+" "+professionals.get(d));
//        }
    }
}
