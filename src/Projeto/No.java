package Projeto;

public abstract class No {
    private Integer id;

    /**
     * Constructor
     */
    public No(Integer id) {
        this.setId(id);
        id++;
    }

    /**
     * Gets and Sets
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
