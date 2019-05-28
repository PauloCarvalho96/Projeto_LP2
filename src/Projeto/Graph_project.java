package Projeto;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;
import edu.princeton.cs.algs4.SymbolGraph;

public class Graph_project {

    public void save_professionals_txt_graph(SeparateChainingHashST_Projeto<Integer,Professional> professionals, String path)
    {
        Out out = new Out(path);
        for (Integer d : professionals.keys()) {
            out.print("\n"+d+";");
        }
    }

    public void save_pro_comp_txt_graph(SeparateChainingHashST_Projeto<Integer,Professional> professionals,SeparateChainingHashST_Projeto<Integer,Company> company,String path)
    {
        Out out = new Out(path);
        for (Integer p:professionals.keys()) {
            out.print("\n"+p+";");
        }
        for (Integer c:company.keys()) {
            out.print("\n"+c+";");
        }

    }
}
