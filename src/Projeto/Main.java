package Projeto;

public class Main {
    public static void main (String[] args)
    {
        Date d1 = new Date(21,03,1996,23,00);
        Date d1r = new Date (10,05,2010,00,00);
        Location l1 = new Location(10,10);
        Professional p1 = new Professional("Paulo",23,"Masculino",d1,d1r,l1);

        System.out.println("Nome:"+p1.getName());
        System.out.println("Idade:"+p1.getAge()+"\nData nascimento: "+p1.getBirth_date().toString());
        System.out.println("Genero: "+p1.getGender());
        System.out.println("Location: "+p1.getLocation());



    }
}
