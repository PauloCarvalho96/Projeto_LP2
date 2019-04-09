package Projeto;


public class Skill {

    private String name;

    private Professional professional;

    /**
     * Constructor
     */
    public Skill(String name, Professional professional) {
        this.setName(name);
        this.setProfessional(professional);
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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public void addSkilltoProfessional(Professional p)
    {

    }
}