package Projeto;

import java.io.Serializable;
import static Projeto.Fase2_JavaFX.GraphCreator.professionals;
import static Projeto.Fase2_JavaFX.GraphCreator.company;
import static Projeto.Fase2_JavaFX.GraphCreator.meetings;
import static Projeto.Fase2_JavaFX.GraphCreator.pontosDeEncontro;

public class Person implements Serializable {

    private String name;
    private String gender;
    private Professional professional;
    private Date birth_date;
    private Integer nif;

    /**
     *  Constructor
     */
    public Person(String name, String gender,Date birth,Integer nif) {
        this.setName(name);
        this.setGender(gender);
        this.setBirth_date(birth);
        this.setNif(nif);
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