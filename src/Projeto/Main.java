package Projeto;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
        Date d1r = new Date (10,05,2010,00,00);
        Date d2r = new Date (15,04,1900,00,00);
        Date d3r = new Date (7,10,1999,00,00);

        Location l1 = new Location(10,10);
        Location l2 = new Location(1,1);
        Location l3 = new Location(4,5);

        ArrayList<String> skillsP1 = new ArrayList<>();
        skillsP1.add("Programacao C");
        skillsP1.add("Programacao JAVA");
        ArrayList<String> skillsP2 = new ArrayList<>();
        skillsP2.add("Fotografia");
        skillsP2.add("Video");

        Professional p1 = new Professional("Paulo",23,"Masculino",skillsP1,l1,null);
        Professional p2 = new Professional("Sheila",69,"Feminino",skillsP2,l1,null);
        Professional p3 = new Professional("Jota",32,"Macho",skillsP2,l1,null);

        Company c1 = new Company("UFP",252252525,190190190,l2);
        Company c2 = new Company("PR MOTORS",123456789,423567437,l3);

        p1.setId("1");
        p2.setId("2");
        p3.setId("3");
        c1.registerProfessional(d1r,p1);
        c1.registerProfessional(d2r,p2);
        c1.registerProfessional(d3r,p3);

        c1.printProForRegistrationDate();

    }

}
