package Projeto;

import edu.princeton.cs.algs4.*;

import java.io.*;

public class Graph_project {

    public void save_all_professionals_bin_graph(SymbolGraphWheighted g, String path)
    {
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(g);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void read_pro_bin_file(SymbolGraphWheighted g,String path)
    {
        ObjectInputStream ios = null;
        try{
            ios = new ObjectInputStream(new FileInputStream(new File(path)));
            g = (SymbolGraphWheighted) ios.readObject();
//            System.out.println(g.graph());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void save_all_pro_comp_bin_digraph(SymbolDigraphWeighted g, String path)
    {
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(g);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void read_pro_comp_bin_file(SymbolDigraphWeighted g,String path)
    {
        ObjectInputStream ios = null;
        try{
            ios = new ObjectInputStream(new FileInputStream(new File(path)));
            g = (SymbolDigraphWeighted) ios.readObject();
            System.out.println(g.digraph());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
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
            for (Edge d:g.graph().adj(v)) {
                out.print(d+";");
            }
            out.print("\n");
        }
    }

    public void conect_2_people(Professional p1, Professional p2, SymbolGraphWheighted g,String path,Integer w)
    {
        for (int v = 0; v < g.graph().V(); v++) {       //percorre os vertices
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {     //se o vertice for igual ao nif do profissional
                    for (int vi = 0; vi < g.graph().V(); vi++) {
                            if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                                g.graph().addEdge(new Edge(v,vi,w));                            //adiciona ligaçao
                                write_pro_to_file_txt(g,path);
                            }
                    }
                }
            }
    }
}
