package Projeto;

public class CompanyHistory {

    private Date in;
    private Date out;
    private Professional professional;
    private Company company;

    /**
     * Constructor
     */
    public CompanyHistory(Date in,Date out, Professional professional, Company company) {
        this.setIn(in);
        this.setOut(out);
        this.setProfessional(professional);
        this.setCompany(company);
    }

    /**
     * Gets and Sets
     */
    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString()
    {
        return "\nProfissional: "+this.getProfessional().getName()+"\nEmpresa: "+this.getCompany().getName()+"\nData de entrada: "+
                this.getIn()+"\nData de saída: "+this.getOut();
    }
}
