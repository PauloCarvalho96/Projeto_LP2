package Projeto;

import edu.princeton.cs.algs4.Graph;

public class Graph_project {
    public static void main(String[] args) {
        Graph pessoas = new Graph(4);
        Professional p1 = new Professional("Paulo", "macho", null, null, null,123456789,0);
        Professional p2 = new Professional("Pedro", "macho", null, null, null,195402065,1);
        Professional p3 = new Professional("Osvaldo", "macho", null, null, null,234509854,2);
        Professional p4 = new Professional("Joao", "macho", null, null, null,394583457,3);

        pessoas.addEdge(p1.getID(),p2.getID());
        pessoas.addEdge(p2.getID(),p3.getID());
        pessoas.addEdge(p3.getID(),p4.getID());

        System.out.println(pessoas);

    }
}
