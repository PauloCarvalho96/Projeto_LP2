package Projeto;


public class InterestAreas {

    private String name;

    private Meeting meeting;
    private Professional professional;

    /**
     * Constructor
     */
    public InterestAreas(String name) {
        this.setName(name);
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

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}