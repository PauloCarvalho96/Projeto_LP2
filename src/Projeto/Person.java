package Projeto;

public class Person {

    private String name;
    private String gender;
    private Professional professional;
    private Date birth_date;
    private Integer nif;
    private Integer ID;

    /**
     *  Constructor
     */
    public Person(String name, String gender,Date birth,Integer nif,Integer ID) {
        this.setName(name);
        this.setGender(gender);
        this.setBirth_date(birth);
        this.setNif(nif);
        this.setID(ID);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Gets and Sets
     */


    public String getName() {
        return name;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Date getDate() {
        return getBirth_date();
    }

    public void setDate(Date date) {
        this.setBirth_date(date);
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
}