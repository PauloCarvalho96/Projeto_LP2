package Projeto;

import java.util.ArrayList;

public class CompanyHistory {

    private Professional professional;                          //profissional
    private Date inDate;                                        //data de entrada
    private Date outDate;                                       //data de saida
    private ArrayList<String> companys = new ArrayList<>();     //arrayList de empresas

    /**
     * Constructor
     */
    public CompanyHistory(Professional professional, Date inDate, Date outDate, ArrayList<String> companys) {
        this.setProfessional(professional);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setCompanys(companys);
    }

    /**
     * Gets and Sets
     */
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public ArrayList<String> getCompanys() {
        return companys;
    }

    public void setCompanys(ArrayList<String> companys) {
        this.companys = companys;
    }
}
