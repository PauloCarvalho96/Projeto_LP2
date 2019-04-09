package Projeto;


public class Employment {

  private String name;

        private Company company;

    /**
     * Constructor
     */
    public Employment(String name, Company company) {
        this.setName(name);
        this.setCompany(company);
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}