package Projeto;

public class Main {
    public static void main (String[] args)
    {
        Date d1 = new Date(21,03,1996,23,00);
        Date d2 = new Date(10,03,1990,11,00);
        Date d1r = new Date (10,05,2010,00,00);
        Location l1 = new Location(10,10);
        Location l2 = new Location(1,1);
        Location l3 = new Location(4,5);
        Professional p1 = new Professional("Paulo",23,"Masculino",d1,d1r,l1);
        Professional p2 = new Professional("Sheila",69,"Feminino",d2,d1r,l1);
        Company c1 = new Company("UFP",252252525,190190190,l2);
        Company c2 = new Company("PR MOTORS",123456789,423567437,l3);

        c1.registerProfessional(p1);
        c1.registerProfessional(p2);

        c1.unregisterProfessional(p2);
        c2.registerProfessional(p2);

        System.out.println("Empresa:" +c1.getName()+"\nphone: "+c1.getPhone()+"\nnif: "+c1.getNif());
        System.out.println("Profissional:"+c1.getProfessional());
        System.out.println("-----------------------");
        System.out.println("Empresa:" +c2.getName()+"\nphone: "+c2.getPhone()+"\nnif: "+c2.getNif());
        System.out.println("Profissional:"+c2.getProfessional());
    }
}
