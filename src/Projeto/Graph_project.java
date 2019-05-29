package Projeto;

import edu.princeton.cs.algs4.*;

public class Graph_project {

    public void save_all_professionals_txt_graph(SeparateChainingHashST_Projeto<Integer,Professional> professionals, String path)
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

    public void write_pro_to_file_txt(SymbolGraphWheighted g, String path)
    {
        Out out = new Out(path);
        for (int v = 0; v < g.graph().V(); v++) {       //percorre os vertices
                out.print(v+";");
            for (Integer d:g.graph().adj(v)) {
                out.print(d+";");
            }
            out.print("\n");
        }
    }

    public void write_pro_to_bin_file()
    {

    }

    public void conect_2_people(Professional p1, Professional p2, SymbolGraphWheighted g,String path)
    {
        for (int v = 0; v < g.graph().V(); v++) {       //percorre os vertices
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {     //se o vertice for igual ao nif do profissional
                    for (int vi = 0; vi < g.graph().V(); vi++) {
                            if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                                g.graph().addEdge(v,vi);                            //adiciona ligaçao
                                write_pro_to_file_txt(g,path);
                            }
                    }
                }
            }
    }
}
