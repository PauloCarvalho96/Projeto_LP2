package Projeto;

public class CompanyHistory {

    private int experience;

    private Professional professional;
    private Date date_start;
    private Date date_end;
    private Company company;

    /**
     * Constructor
     */
    public CompanyHistory(int experience, Professional professional, Date date_start, Date date_end, Company company) {
        this.setExperience(experience);
        this.setProfessional(professional);
        this.setDate_start(date_start);
        this.setDate_end(date_end);
        this.setCompany(company);
    }

    /**
     * Gets and Sets
     */
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}