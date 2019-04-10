package Projeto;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
        Date d1r = new Date (10,05,2010,00,00);
        Location l1 = new Location(10,10);
        Location l2 = new Location(1,1);
        Location l3 = new Location(4,5);
        ArrayList<String> skillsP1 = new ArrayList<>();
        skillsP1.add("Programacao C");
        skillsP1.add("Programacao JAVA");
        ArrayList<String> skillsP2 = new ArrayList<>();
        skillsP2.add("Fotografia");
        skillsP2.add("Video");
        Professional p1 = new Professional("Paulo",23,"Masculino",d1r,skillsP1,l1);
        Professional p2 = new Professional("Sheila",69,"Feminino",d1r,skillsP2,l1);
        Company c1 = new Company("UFP",252252525,190190190,l2);
        Company c2 = new Company("PR MOTORS",123456789,423567437,l3);

        c1.registerProfessional(p1);
        c1.registerProfessional(p2);

        c1.unregisterProfessional(p2);
        c2.registerProfessional(p2);

        System.out.println("Empresa:" +c1.getName()+"\nphone: "+c1.getPhone()+"\nnif: "+c1.getNif()+"\nLocation: "+c1.getLocation());
        System.out.println("Profissional:"+c1.getProfessional());
        System.out.println("-----------------------");
        System.out.println("Empresa:" +c2.getName()+"\nphone: "+c2.getPhone()+"\nnif: "+c2.getNif()+"\nLocation: "+c2.getLocation());
        System.out.println("Profissional:"+c2.getProfessional());
    }
}
