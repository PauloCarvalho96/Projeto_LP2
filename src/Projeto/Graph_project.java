package Projeto;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.SeparateChainingHashST_Projeto;
import edu.princeton.cs.algs4.SymbolGraph;

public class Graph_project {

    public void save_professionals_txt_graph(SeparateChainingHashST_Projeto<Integer,Professional> professionals, String path)
    {
        Out out = new Out(path);
        int i = 0;
        for (Integer d : professionals.keys()) {
            out.print("\n");
            out.print(d);
            out.print(";");
            out.print(i);
            i++;
        }
    }
}
