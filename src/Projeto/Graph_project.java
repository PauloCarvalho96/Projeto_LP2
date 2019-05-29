package Projeto;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;
import edu.princeton.cs.algs4.SymbolGraph;

public class Graph_project {

    public void save_professionals_txt_graph(SeparateChainingHashST_Projeto<Integer,Professional> professionals, String path)
    {
        Out out = new Out(path);
        for (Integer d : professionals.keys()) {
            out.print(d+";"+"\n");
        }
    }

    public void save_pro_comp_txt_graph(SeparateChainingHashST_Projeto<Integer,Professional> professionals,SeparateChainingHashST_Projeto<Integer,Company> company,String path)
    {
        Out out = new Out(path);
        for (Integer p:professionals.keys()) {
            out.print(p+";"+"\n");
        }
        for (Integer c:company.keys()) {
            out.print(c+";"+"\n");
        }
    }

    public void conect_2_people(Professional p1, Professional p2, Graph g)
    {
        g.addEdge(p1.getNif(),p2.getNif());
    }
}
