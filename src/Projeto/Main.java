/**
 *
 * ************************
 * Projeto realizado por: *
 *                        *
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

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SeparateChainingHashST_Projeto<Integer, Company> company = new SeparateChainingHashST_Projeto<>();      //Date é data de registo da empresa
        SeparateChainingHashST_Projeto<Integer, Professional> professionals = new SeparateChainingHashST_Projeto<>();   //Date é data de nascimento do profissional
        RedBlackBST<Date, Meeting> meetings = new RedBlackBST<>();       //Date é data de criação do meeting

        //datas de nascimento
        Date bdp1 = new Date(21, 3, 1996, 3, 34);
        Date bdp2 = new Date(10, 3, 1940, 6, 47);
        Date bdp3 = new Date(5, 5, 1994, 12, 23);
        Date bdp4 = new Date(4, 7, 1991, 17, 11);
        Date bdp5 = new Date(3, 10, 1993, 11, 1);
        Date bdp6 = new Date(21, 6, 2001, 23, 57);
        Date bdp7 = new Date(6, 10, 1975, 12, 30);
        Date bdp8 = new Date(9, 1, 1987, 5, 37);
        Date bdp9 = new Date(28, 3, 1973, 1, 21);
        Date bdp10 = new Date(30, 12, 1964, 12, 60);

        //datas de registo
        Date d1r = new Date(10, 5, 2010, 4, 30);
        Date d2r = new Date(15, 4, 1970, 1, 53);
        Date d3r = new Date(7, 10, 1999, 3, 24);
        Date d4r = new Date(1, 4, 2005, 11, 56);
        Date d5r = new Date(23, 10, 2005, 16, 13);
        Date d6r = new Date(25, 4, 2009, 20, 3);
        Date d7r = new Date(2, 3, 1997, 8, 50);
        Date d8r = new Date(2, 11, 2002, 4, 45);
        Date d9r = new Date(25, 8, 1996, 21, 43);
        Date d10r = new Date(1, 1, 1987, 19, 16);

        //datas de saida das empresas
        Date d1s = new Date(12, 4, 2015, 10, 11);
        Date d2s = new Date(17, 4, 2017, 3, 36);
        Date d3s = new Date(17, 4, 2014, 6, 34);
        Date dHoje = new Date(20, 4, 2019, 6, 60);

        //datas de registo de empresas
        Date dc1 = new Date(3, 5, 2000, 5, 45);
        Date dc2 = new Date(1, 7, 1930, 3, 49);
        Date dc3 = new Date(6, 11, 1946, 9, 11);

        //datas dos meetings
        Date dm1 = new Date(7, 12, 2007, 5, 45);
        Date dm2 = new Date(6, 4, 2015, 3, 30);
        Date dm3 = new Date(8, 3, 2017, 6, 21);

        //data de entrada e saida de empresa
        Date d1in = new Date(1, 1, 2001, 1, 1);
        Date d1out = new Date(5, 3, 1998, 0, 0);

        //localizaçoes
        Location l1 = new Location(10, 10);
        Location l2 = new Location(1, 1);
        Location l3 = new Location(4, 5);
        Location l4 = new Location(50, 30);

        //skills
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

        //profissionais
        Professional p1 = new Professional("Paulo", "Masculino", bdp1, skillsP1, l1, 111111111);
        Professional p2 = new Professional("Carolina", "Feminino", bdp2, skillsP2, l1, 222222222);
        Professional p3 = new Professional("Jota", "Masculino", bdp3, skillsP1, l1, 333333333);
        Professional p4 = new Professional("Artur", "Masculino", bdp4, skillsP2, l1, 444444444);
        Professional p5 = new Professional("Pedro", "Masculino", bdp5, skillsP1, l1, 555555555);
        Professional p6 = new Professional("Catarina", "Feminino", bdp6, skillsP2, l2, 666666666);
        Professional p7 = new Professional("Joana", "Feminino", bdp7, skillsP3, l3, 777777777);
        Professional p8 = new Professional("Maria", "Feminino", bdp8, skillsP4, l4, 888888888);
        Professional p9 = new Professional("Osvaldo", "Feminino", bdp9, skillsP5, l2, 999999999);
        Professional p10 = new Professional("Andre", "Feminino", bdp10, skillsP3, l3, 101010101);

        //companys
        Company c1 = new Company("UFP", 252252525, 190190190, l2);
        Company c2 = new Company("PR MOTORS", 252759021, 423567437, l3);
        Company c3 = new Company("Fotogrupo", 252846792, 425678241, l4);
        Company c4 = new Company("Desempregado", 0, 0, null);       //desempregado

        //regista empresas na base de dados
        company.put(c1.getNif(), c1);
        company.put(c2.getNif(), c2);
        company.put(c3.getNif(), c3);

        //regista profissionais na base de dados
        professionals.put(p1.getNif(), p1);
        professionals.put(p2.getNif(), p2);
        professionals.put(p3.getNif(), p3);
        professionals.put(p4.getNif(), p4);
        professionals.put(p5.getNif(), p5);
        professionals.put(p6.getNif(), p6);
        professionals.put(p7.getNif(), p7);
        professionals.put(p8.getNif(), p8);
        professionals.put(p9.getNif(), p9);
        professionals.put(p10.getNif(), p10);

        //regista todos os profissionais em empresas
        c1.registerProfessional(d1r, p1, c1, 1000);
        c1.registerProfessional(d2r, p2, c1, 5000);
        c1.registerProfessional(d3r, p3, c1, 3000);

        c2.registerProfessional(d4r, p4, c2, 2000);
        c2.registerProfessional(d5r, p5, c2, 8000);

        c3.registerProfessional(d6r, p6, c3, 10000);
        c3.registerProfessional(d7r, p7, c3, 1000);
        c3.registerProfessional(d8r, p8, c3, 650);
        c3.registerProfessional(d9r, p9, c3, 850);
        c3.registerProfessional(d10r, p10, c3, 650);

        //procura profissionais pela skill
//        c1.searchBySkill("Programacao C");

//        adiona areas de interesse ao array
        ArrayList<String> interestAreas1 = new ArrayList<>();
        interestAreas1.add("Programacao");
        interestAreas1.add("POO");
        interestAreas1.add("APPS");

        ArrayList<String> interestAreas2 = new ArrayList<>();
        interestAreas2.add("Aprender C");

        ArrayList<String> interestAreas3 = new ArrayList<>();
        interestAreas3.add("Fotografia");

        //meetings
        Meeting m1 = new Meeting("Palestra JAVA", 60, l4, interestAreas1, dm1);
        Meeting m2 = new Meeting("Palestra C", 180, l2, interestAreas2, dm2);
        Meeting m3 = new Meeting("Photoshop", 120, l2, interestAreas3, dm3);

        //adiciona meetings na base de dados
        meetings.put(dm1, m1);
        meetings.put(dm2, m2);
        meetings.put(dm3, m3);

        //associa company a meeting
        c1.associateCompanyMeet(m1);
        c1.associateCompanyMeet(m2);
        c2.associateCompanyMeet(m2);
        c3.associateCompanyMeet(m3);

        //associa meeting a company
        m1.associateMeetCompany(c1);
        m2.associateMeetCompany(c1);
        m2.associateMeetCompany(c2);
        m3.associateMeetCompany(c3);

        //associa profissional a meet
        p1.associateProfessionalMeet(m1);
        p2.associateProfessionalMeet(m2);
        p3.associateProfessionalMeet(m1);
        p4.associateProfessionalMeet(m2);
        p5.associateProfessionalMeet(m2);
        p6.associateProfessionalMeet(m3);
        p7.associateProfessionalMeet(m3);
        p8.associateProfessionalMeet(m3);
        p9.associateProfessionalMeet(m3);
        p10.associateProfessionalMeet(m3);

//        associa meet a profissional
        m1.associateMeetProfessional(p1);
        m2.associateMeetProfessional(p2);
        m1.associateMeetProfessional(p3);
        m2.associateMeetProfessional(p4);
        m2.associateMeetProfessional(p5);
        m3.associateMeetProfessional(p6);
        m3.associateMeetProfessional(p7);
        m3.associateMeetProfessional(p8);
        m3.associateMeetProfessional(p9);
        m3.associateMeetProfessional(p10);

        /**
         * Company History
         */
        //listagem de o historico de cada profissional
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

        //remove empresa
//        c1.removeCompany(company, c1, professionals, c4);    //remove empresa c1

        //edita empresa
//        c1.editCompanyName(company, c1, "Microsoft");
//        c1.editCompanyPhone(company, c1, 252123456);
//        c1.editCompanyNif(company, c1, 123456789);
//        c1.editCompanyLocation(company, c1, l1);

        /**
         * Profissional P1
         */
        //remove o profissional p1 da empresa c1
//        c1.removeProfessionalCompany(professionals, p1, c1, c4);

        //regista p1 na c2
//        c2.registerProfessional(d1r, p1, c2, 1000);

        // adiciona ao historico de empresas de p1
//        CompanyHistory p1h1 = new CompanyHistory(d1r, d1s, p1, c1);
//        professionalHp1.add(p1h1); // p1 -> empresa 1

        //remove p1 de c2
//        c2.removeProfessionalCompany(professionals, p1, c2, c4);

        // adiciona ao historico de empresas de p1
//        CompanyHistory p1h2 = new CompanyHistory(d1s, d2s, p1, c2);
//        professionalHp1.add(p1h2); // p1 -> empresa 2
//
//        c3.registerProfessional(d4r, p4, c3, 1200);
//        c3.associatePro(c3, p4);
//
//        c1.registerProfessional(d9r, p9, c1, 2300);
//        c1.associatePro(c1, p9);
//
//        CompanyHistory p4h1 = new CompanyHistory(d4r, d2s, p4, c2);
//        CompanyHistory p9h1 = new CompanyHistory(d9r, d3s, p9, c3);
//
//        CompanyHistory p4h2 = new CompanyHistory(d2s, dHoje, p4, c3);
//        CompanyHistory p9h2 = new CompanyHistory(d3s, dHoje, p9, c1);
//
//        professionalHp4.add(p4h1);// p4 -> empresa 2
//        professionalHp4.add(p4h2);// p4 -> empresa 3
//
//        professionalHp9.add(p9h1);// p9 -> empresa 3
//        professionalHp9.add(p9h2);// p9 -> empresa 1

        /**
         * Prints
         */
        //para imprimir o historico criou se um objeto para aceder a funçao
//        CompanyHistory printh = new CompanyHistory(null, null, null, null);

        //imprime historico de empresas de p1
        //printh.printCompanyHistoric(professionalHp1);

        //imprime profissionais de cada empresa
//        c1.printProForRegistrationDate();
//        c2.printProForRegistrationDate();
//        c3.printProForRegistrationDate();

        //imprime todos os profissionais desempregados
//        c4.printProWithoutCompany(professionals,c4);

        //imprime todos os meetings
//        Meeting printm = new Meeting(null, 0, null, null, null); //para aceder a classe
//        printm.printAllMeetings(meetings);

        // Imprime meetings por data
//        printm.searchMeetingsbyDates(meetings,dm2);

        // Imprime meetings entre 2 datas
        //printm.searchMeetingsBetweenToDates(meetings,dm1,dm3);

        // Imprime meetings com n ou mais participantes
        //printm.searchMeetingsWithNParticipants(meetings,3);

        //imprime todas as empresas e numero de profissionais de cada empresa
//        Company print = new Company(null, 0, 0, null);
//        print.printAllCompanys(company);
//        System.out.println("Numero de profissionais da empresa "+c1.getName()+" : "+c1.numberOfProfessionals(c1));
//        System.out.println("Numero de profissionais da empresa "+c2.getName()+" : "+c2.numberOfProfessionals(c2));
//        System.out.println("Numero de profissionais da empresa "+c3.getName()+" : "+c3.numberOfProfessionals(c3));

        //imprime a empresa pelo nif
        //print.searchCompanybynif(company,190190190);

        //imprime a empresa pelo nome
        //print.searchCompanybyname(company,"Fotogrupo");

        //imprime a empresa pelo numero
        //print.searchCompanybyphone(company,252759021);

        //imprime a empresa pela localizacao
        //print.searchCompanybylocation(company,l2);

//          imprime todos os profissionais
//        Professional print1 = new Professional(null, null, null, null, null,null);    //para aceder a classe
//        print1.printAllProfessionals(professionals);

        //imprime profissionais com uma determinada skill
        //print1.searchProfessionalBySkill(professionals,"Base de dados"); !!!!!! nao consegui

        //imprime profissionais pelo salario
        //print1.searchProfessionalBySalary(professionals,1000);

        //imprime profissionais pela localizacao
        //print1.searchProfessionalByLocation(professionals,l1);

        //imprime profissionais pelo nome
        //print1.searchProfessionalByName(professionals,"Jota");

        /**
         * FILES (SAVE)
         */
        //companys information
//        Company c = new Company(null,0,0,null);
//        c.writeCompanysToTXT(company,".//data//company.txt");
//        c.write_comp_to_txt_JAVAFX(company,".//data//company_JAVAFX.txt");

        //professionals information
//        Professional p = new Professional(null,null,null,null,null,0);
//        p.writeProfessionalsToTXT(professionals,".//data//professionals.txt");
//        p.write_pro_to_txt_JAVAFX(professionals,".//data//professionals_JAVAFX.txt");

        //meetings information
//        Meeting m = new Meeting(null,0,null,null,null);
//        m.writeMeetingsToTXT(meetings,".//data//meetings.txt");
//        m.write_meet_to_txt_JAVAFX(meetings,".//data//meets_JAVAFX.txt");

        /**
         * FILES (LOAD)
         */
//        c.loadCompanyToST(company,".//data//company.txt");
//        p.loadProfessionalsToST(professionals,".//data//professionals.txt");
//        m.loadMeetingsToST(meetings,".//data//meetings.txt");

        /**
         * GRAPH
         */
        Graph_project g = new Graph_project();                          //para aceder a classe

        //grafo pessoas
        String path_pessoas_txt = ".//data//professionals_graph.txt";       //caminho do ficheiro
        String path_pessoas_bin = ".//data//professionals_graph.bin";       //caminho do ficheiro
        g.save_professionals_txt_graph(professionals,path_pessoas_txt);     //guarda todas os profissionais no txt (NIF)
        SymbolGraphWheighted pessoas = new SymbolGraphWheighted(path_pessoas_txt, ";");    //cria o symbol graph de profissionais

        //ligaçoes (funçoes teste)
        g.conect_2_people(p1,p2,pessoas,path_pessoas_txt,10);
        g.conect_2_people(p1,p3,pessoas,path_pessoas_txt,20);
        g.conect_2_people(p2,p3,pessoas,path_pessoas_txt,30);
        g.conect_2_people(p2,p5,pessoas,path_pessoas_txt,15);
        g.conect_2_people(p2,p4,pessoas,path_pessoas_txt,8);
        g.conect_2_people(p3,p4,pessoas,path_pessoas_txt,3);
        g.conect_2_people(p4,p5,pessoas,path_pessoas_txt,5);
        g.conect_2_people(p6,p8,pessoas,path_pessoas_txt,5);
        g.conect_2_people(p6,p9,pessoas,path_pessoas_txt,5);
        g.conect_2_people(p7,p9,pessoas,path_pessoas_txt,5);
        g.conect_2_people(p7,p10,pessoas,path_pessoas_txt,5);
        g.conect_2_people(p8,p9,pessoas,path_pessoas_txt,5);
        g.conect_2_people(p9,p10,pessoas,path_pessoas_txt,5);

        //guarda e carrega de bin
        g.save_all_professionals_bin_graph(pessoas,path_pessoas_bin);   //guarda grafo em ficheiro bin
//        pessoas = g.read_pro_bin_file(pessoas,path_pessoas_bin);          //le do ficheiro bin

//        System.out.println(pessoas.graph());

        //grafo profissionais / empresas
        String path_pessoas_empresas_txt = ".//data//pro_comp_graph.txt";
        String path_pessoas_empresas_bin = ".//data//pro_comp_graph.bin";
        g.save_pro_comp_txt_graph(professionals,company,path_pessoas_empresas_txt);
        SymbolDigraphWeighted pessoas_empresas = new SymbolDigraphWeighted(path_pessoas_empresas_txt,";");
        g.pro_comp_meet_vertex(pessoas_empresas,path_pessoas_empresas_txt,professionals,company,meetings);

        //ligaçoes (funçoes teste)
        g.conect_pro_comp_graphProCompMeet(p1,c1,pessoas_empresas,path_pessoas_empresas_txt,10,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p2,c1,pessoas_empresas,path_pessoas_empresas_txt,20,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p3,c1,pessoas_empresas,path_pessoas_empresas_txt,30,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p4,c2,pessoas_empresas,path_pessoas_empresas_txt,12,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p5,c2,pessoas_empresas,path_pessoas_empresas_txt,17,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p6,c3,pessoas_empresas,path_pessoas_empresas_txt,22,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p7,c3,pessoas_empresas,path_pessoas_empresas_txt,24,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p8,c3,pessoas_empresas,path_pessoas_empresas_txt,14,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p9,c3,pessoas_empresas,path_pessoas_empresas_txt,37,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p10,c3,pessoas_empresas,path_pessoas_empresas_txt,27,professionals,company,meetings);

        //guarda e carrega de bin
        g.save_all_pro_comp_bin_digraph(pessoas_empresas,path_pessoas_empresas_bin);
//        g.read_pro_comp_bin_file(pessoas_empresas,path_pessoas_empresas_bin);

//        System.out.println(pessoas_empresas.digraph());

        //grafo profissionais/empresas/meetings
        String path_pro_comp_meet_txt = ".//data//pro_comp_meet.txt";
        String path_pro_comp_meet_bin = ".//data//pro_comp_meet.bin";
        g.save_pro_comp_meet_txt_graph(professionals,company,meetings,path_pro_comp_meet_txt);
        SymbolDigraphWeighted pro_comp_meet = new SymbolDigraphWeighted(path_pro_comp_meet_txt,";");
        g.pro_comp_meet_vertex(pro_comp_meet,path_pro_comp_meet_txt,professionals,company,meetings);

        //ligaçoes (funçoes teste)
        g.conect_pro_comp_graphProCompMeet(p1,c1,pro_comp_meet,path_pro_comp_meet_txt,10,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p2,c1,pro_comp_meet,path_pro_comp_meet_txt,20,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p3,c1,pro_comp_meet,path_pro_comp_meet_txt,30,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p4,c2,pro_comp_meet,path_pro_comp_meet_txt,12,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p5,c2,pro_comp_meet,path_pro_comp_meet_txt,17,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p6,c3,pro_comp_meet,path_pro_comp_meet_txt,22,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p7,c3,pro_comp_meet,path_pro_comp_meet_txt,24,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p8,c3,pro_comp_meet,path_pro_comp_meet_txt,14,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p9,c3,pro_comp_meet,path_pro_comp_meet_txt,37,professionals,company,meetings);
        g.conect_pro_comp_graphProCompMeet(p10,c3,pro_comp_meet,path_pro_comp_meet_txt,27,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p1,p2,pro_comp_meet,path_pro_comp_meet_txt,1,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p1,p3,pro_comp_meet,path_pro_comp_meet_txt,2,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p2,p3,pro_comp_meet,path_pro_comp_meet_txt,3,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p2,p5,pro_comp_meet,path_pro_comp_meet_txt,4,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p2,p4,pro_comp_meet,path_pro_comp_meet_txt,5,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p3,p4,pro_comp_meet,path_pro_comp_meet_txt,6,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p4,p5,pro_comp_meet,path_pro_comp_meet_txt,7,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p6,p8,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p6,p9,pro_comp_meet,path_pro_comp_meet_txt,9,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p7,p9,pro_comp_meet,path_pro_comp_meet_txt,10,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p7,p10,pro_comp_meet,path_pro_comp_meet_txt,11,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p8,p9,pro_comp_meet,path_pro_comp_meet_txt,12,professionals,company,meetings);
        g.conect_pro_pro_graphProCompMeet(p9,p10,pro_comp_meet,path_pro_comp_meet_txt,13,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p1,m1,pro_comp_meet,path_pro_comp_meet_txt,14,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p3,m1,pro_comp_meet,path_pro_comp_meet_txt,14,professionals,company,meetings);
        g.conect_comp_meet_graphProCompMeet(c1,m1,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_comp_meet_graphProCompMeet(c1,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_comp_meet_graphProCompMeet(c2,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p2,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p4,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p5,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_comp_meet_graphProCompMeet(c3,m3,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p6,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p7,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p8,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p9,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
        g.conect_pro_meet_graphProCompMeet(p10,m2,pro_comp_meet,path_pro_comp_meet_txt,8,professionals,company,meetings);
//        System.out.println(pro_comp_meet.digraph());

        /**
         * Funçoes de Pesquisa em Grafos
         */
        //todos os profissionais que seguem uma empresa
//        g.search_comp_pro_followers(c1,pro_comp_meet,professionals,company,meetings);
//        g.search_comp_pro_followers(c2,pro_comp_meet,professionals,company,meetings);
//        g.search_comp_pro_followers(c3,pro_comp_meet,professionals,company,meetings);

        //todos os profissionais que participaram num meet
//        g.search_meet_pro_followers(m1,pro_comp_meet,professionals,company,meetings);
//        g.search_meet_pro_followers(m2,pro_comp_meet,professionals,company,meetings);
//        g.search_meet_pro_followers(m3,pro_comp_meet,professionals,company,meetings);
    }
}
