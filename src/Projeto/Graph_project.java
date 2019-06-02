package Projeto;

import edu.princeton.cs.algs4.*;

import java.io.*;

public class Graph_project {

    /**
     * FILES
     */
    public void save_all_professionals_bin_graph(SymbolGraphWheighted g, String path) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SymbolGraphWheighted read_pro_bin_file(SymbolGraphWheighted g, String path) {
        ObjectInputStream ios = null;
        try {
            ios = new ObjectInputStream(new FileInputStream(new File(path)));
            g = (SymbolGraphWheighted) ios.readObject();
            return g;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save_all_pro_comp_bin_digraph(SymbolDigraphWeighted g, String path) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SymbolDigraphWeighted read_pro_comp_bin_file(SymbolDigraphWeighted g, String path) {
        ObjectInputStream ios = null;
        try {
            ios = new ObjectInputStream(new FileInputStream(new File(path)));
            g = (SymbolDigraphWeighted) ios.readObject();
            return g;
//            System.out.println(g.digraph());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save_professionals_txt_graph(SeparateChainingHashST_Projeto<Integer, Professional> professionals, String path) {
        Out out = new Out(path);
        for (Integer d : professionals.keys()) {
            out.print(d + ";" + "\n");
        }
        out.close();
    }

    public void save_pro_comp_txt_graph(SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, String path) {
        Out out = new Out(path);
        for (Integer p : professionals.keys()) {
            out.print(p + ";" + "\n");
        }
        for (Integer c : company.keys()) {
            out.print(c + ";" + "\n");
        }
        out.close();
    }

    public void save_pro_comp_meet_txt_graph(SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings, String path) {
        Out out = new Out(path);
        for (Integer p : professionals.keys()) {
            out.print(p + ";" + "\n");
        }
        for (Integer c : company.keys()) {
            out.print(c + ";" + "\n");
        }
        for (Date d : meetings.keys()) {
            out.print(d + ";" + "\n");
        }
        out.close();
    }

    public void write_pro_to_file_txt(SymbolGraphWheighted g, String path) {
        Out out = new Out(path);
        for (int v = 0; v < g.graph().V(); v++) {       //percorre os vertices
            out.print(v + ";");
            for (Edge d : g.graph().adj(v)) {
                out.print(d.other(v) + ";" + d.weight() + ";");
            }
            out.print("\n");
        }
        out.close();
    }

    public void conect_2_people(Professional p1, Professional p2, SymbolGraphWheighted g, String path, Integer w) {
        for (int v = 0; v < g.graph().V(); v++) {       //percorre os vertices
            if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {     //se o vertice for igual ao nif do profissional
                for (int vi = 0; vi < g.graph().V(); vi++) {
                    if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                        g.graph().addEdge(new Edge(v, vi, w));                            //adiciona ligaçao
                        write_pro_to_file_txt(g, path);
                    }
                }
            }
        }
    }

    public int pro_or_comp_or_meet(SymbolDigraphWeighted g, int v, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (Date d : meetings.keys()) {
            if (d.toString().compareTo(g.nameOf(v)) == 0) {     //se a data coicidir entao é meeting
                return 2;
            }
        }
        for (Integer p : professionals.keys()) {          //percorre os profissionais
            if (p == Integer.parseInt(g.nameOf(v))) {     //se o nif coicidir entao é profissional
                return 0;
            }
        }
        for (Integer c : company.keys()) {
            if (c == Integer.parseInt(g.nameOf(v))) {     //se o nif coicidir entao é empresa
                return 1;
            }
        }
        return 3;
    }

    public void write_pro_comp_to_file_txt(SymbolDigraphWeighted g, String path, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        Out out = new Out(path);
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings); //procura a ver se é profissional ou empresa ou meet
            if (i == 0) {
                out.print("p" + ";" + v + ";");
            } else {
                if (i == 1) {
                    out.print("c" + ";" + v + ";");
                } else {
                    if (i == 2) {
                        out.print("d" + ";" + v + ";");
                    } else {
                        System.out.println("erro ao ler");
                    }
                }
            }
            for (DirectedEdge d : g.digraph().adj(v)) {
                out.print(d.to() + ";" + d.weight() + ";");
            }
            out.print("\n");
        }
        out.close();
    }

    public void pro_comp_meet_vertex(SymbolDigraphWeighted g, String path, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        Out out = new Out(path);
        for (int v = 0; v < g.digraph().V(); v++) {
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 0) {
                out.print("p" + ";" + v + ";" + "\n");
            } else {
                if (i == 1) {
                    out.print("c" + ";" + v + ";" + "\n");
                } else {
                    if (i == 2) {
                        out.print("d" + ";" + v + ";" + "\n");
                    } else {
                        System.out.println("erro");
                    }
                }
            }
        }
        out.close();
    }

    public void conect_pro_comp_graphProCompMeet(Professional p1, Company p2, SymbolDigraphWeighted g, String path, Integer w, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 0) {
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 1) {
                            if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                                g.digraph().addEdge(new DirectedEdge(v, vi, w));
                                g.digraph().addEdge(new DirectedEdge(vi, v, w));
                                write_pro_comp_to_file_txt(g, path, professionals, company, meetings);
                            }
                        }
                    }
                }
            }
        }
    }

    public void conect_pro_meet_graphProCompMeet(Professional p1, Meeting p2, SymbolDigraphWeighted g, String path, Integer w, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 0) {
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 2) {
                            if (p2.getDate().toString().compareTo(g.nameOf(vi)) == 0) {
                                g.digraph().addEdge(new DirectedEdge(v, vi, w));
                                g.digraph().addEdge(new DirectedEdge(vi, v, w));
                                write_pro_comp_to_file_txt(g, path, professionals, company, meetings);
                            }
                        }
                    }
                }
            }
        }
    }

    public void conect_comp_meet_graphProCompMeet(Company p1, Meeting p2, SymbolDigraphWeighted g, String path, Integer w, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 1) {
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 2) {
                            if (p2.getDate().toString().compareTo(g.nameOf(vi)) == 0) {
                                g.digraph().addEdge(new DirectedEdge(v, vi, w));
                                g.digraph().addEdge(new DirectedEdge(vi, v, w));
                                write_pro_comp_to_file_txt(g, path, professionals, company, meetings);
                            }
                        }
                    }
                }
            }
        }
    }

    public void conect_pro_pro_graphProCompMeet(Professional p1, Professional p2, SymbolDigraphWeighted g, String path, Integer w, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 0) {
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 0) {
                            if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                                g.digraph().addEdge(new DirectedEdge(v, vi, w));
                                g.digraph().addEdge(new DirectedEdge(vi, v, w));
                                write_pro_comp_to_file_txt(g, path, professionals, company, meetings);
                            }
                        }
                    }
                }
            }
        }
    }

    public void conect_comp_comp_graphProCompMeet(Company p1, Company p2, SymbolDigraphWeighted g, String path, Integer w, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 1) {
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 1) {
                            if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                                g.digraph().addEdge(new DirectedEdge(v, vi, w));
                                write_pro_comp_to_file_txt(g, path, professionals, company, meetings);
                            }
                        }
                    }
                }
            }
        }
    }

    public void conect_meet_meet_graphProCompMeet(Company p1, Company p2, SymbolDigraphWeighted g, String path, Integer w, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        for (int v = 0; v < g.digraph().V(); v++) {       //percorre os vertices
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 1) {
                if (Integer.parseInt(g.nameOf(v)) == p1.getNif()) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 1) {
                            if (Integer.parseInt(g.nameOf(vi)) == p2.getNif()) {
                                g.digraph().addEdge(new DirectedEdge(v, vi, w));
                                write_pro_comp_to_file_txt(g, path, professionals, company, meetings);
                            }
                        }
                    }
                }
            }
        }
    }

    public void write_search_comp_pro(SymbolDigraphWeighted g, String path, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        Out out = new Out(path);
        for (int v = 0; v < g.digraph().V(); v++) {
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 1) {
                for (Integer d : company.keys()) {
                    if (company.get(d).getNif() == Integer.parseInt(g.nameOf(v))) {
                        out.print(company.get(d).getName() + ";");
                        for (DirectedEdge e : g.digraph().adj(v)) {
                            int x = pro_or_comp_or_meet(g, e.to(), professionals, company, meetings);
                            if (x == 0) {
                                for (Integer t : professionals.keys()) {
                                    if (professionals.get(t).getNif() == Integer.parseInt(g.nameOf(e.to()))) {
                                        out.print(professionals.get(t).getName() + ";");
                                    }
                                }
                            }
                        }
                        out.print("\n");
                    }
                }
            }
        }
        out.close();
    }

    /**
     * PESQUISA EM GRAFOS
     */
    //pesquisa de profissionais que seguem uma empresa
    public void search_comp_pro_followers(Company p2, SymbolDigraphWeighted g, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        System.out.println("Profissionais que seguem a empresa " + p2.getName());
        for (int v = 0; v < g.digraph().V(); v++) {
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 1) {
                if (Integer.parseInt(g.nameOf(v)) == p2.getNif()) {
                    for (DirectedEdge d : g.digraph().adj(v)) {
                        int y = pro_or_comp_or_meet(g, d.to(), professionals, company, meetings);
                        if (y == 0) {
                            for (Integer di : professionals.keys()) {
                                if (professionals.get(di).getNif() == Integer.parseInt(g.nameOf(d.to()))) {
                                    System.out.println(professionals.get(di).getName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //pesquisa profissionais que participaram num encontro
    public void search_meet_pro_followers(Meeting p2, SymbolDigraphWeighted g, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        System.out.println("Profissionais que participaram no encontro " + p2.getName());
        for (int v = 0; v < g.digraph().V(); v++) {
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 2) {
                if (p2.getDate().toString().compareTo(g.nameOf(v)) == 0) {
                    for (DirectedEdge d : g.digraph().adj(v)) {
                        int y = pro_or_comp_or_meet(g, d.to(), professionals, company, meetings);
                        if (y == 0) {
                            for (Integer di : professionals.keys()) {
                                if (professionals.get(di).getNif() == Integer.parseInt(g.nameOf(d.to()))) {
                                    System.out.println(professionals.get(di).getName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //menor caminho entre empresa e encontro
    public void short_path_between_CompMeet(SymbolDigraphWeighted g, Company c, Meeting m, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        System.out.println("Caminho mais curto de " + c.getName() + " a " + m.getName());
        System.out.println(c.getName() + "-" + m.getName() + " " + "Distancia");
        for (int v = 0; v < g.digraph().V(); v++) {
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 1) {
                if (c.getNif() == Integer.parseInt(g.nameOf(v))) {
                    for (int vi = 0; vi < g.digraph().V(); vi++) {
                        int x = pro_or_comp_or_meet(g, vi, professionals, company, meetings);
                        if (x == 2) {
                            if (m.getDate().toString().compareTo(g.nameOf(vi)) == 0) {
                                DijkstraSP_Projeto sp = new DijkstraSP_Projeto(g, v);
                                if (sp.hasPathTo(vi)) {
                                    System.out.println(v + "-" + vi + " " + sp.distTo(vi));
                                } else {
                                    System.out.println("Sem caminho possivel!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void search_pro_without_comp_and_skills(SymbolDigraphWeighted g, Company c, String skill, SeparateChainingHashST_Projeto<Integer, Professional> professionals, SeparateChainingHashST_Projeto<Integer, Company> company, RedBlackBST<Date, Meeting> meetings) {
        System.out.println("Profissionais desempregados e com a skill "+skill);
        for (int v = 0; v < g.digraph().V(); v++) {
            int i = pro_or_comp_or_meet(g, v, professionals, company, meetings);
            if (i == 0) {
                    for (Integer d : professionals.keys()) {
                            if (professionals.get(d).getNif() == Integer.parseInt(g.nameOf(v)) && professionals.get(d).getCompany() == c && professionals.get(d).getSkills().contains(skill)) {
                            System.out.println(professionals.get(d));
                    }
                }
            }
        }
    }
}
