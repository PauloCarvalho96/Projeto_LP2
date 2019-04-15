package Projeto;

public class Person {

    private String name;
    private String gender;
    private Professional professional;
    private Date birth_date;

    /**
     *  Constructor
     */
    public Person(String name, String gender,Date birth) {
        this.setName(name);
        this.setGender(gender);
        this.setBirth_date(birth);
    }

    /**
     * Gets and Sets
     */
    public String getName() {
        return name;
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