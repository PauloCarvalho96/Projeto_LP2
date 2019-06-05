package Projeto.Fase2_JavaFX;
import Projeto.*;
import Projeto.Date;
import edu.princeton.cs.algs4.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static Projeto.Fase2_JavaFX.GraphCreator.*;

public class GraphCreatorFXMLController implements Initializable {
    public TextField verticesNumberField;
    public TextArea edgesField;
    public MenuItem openGraph;
    public Button createButton;
    public MenuItem companiesGraph;
    public MenuItem professionalGraph;
    public TableColumn professionalsCompanyCol;
    public Group graphGroup;
    public Group graphGroup1;
    public Group graphGroup2;
    public TableView<Professional> professionalTable;
    public TableColumn<Professional,String> nameCol;
    public TableColumn<Professional, Integer> nifCol;
    public TableColumn<Professional, String> companyCol;
    public TableView<Company> companyTable;
    public TableColumn<Company, String> companyNameCol;
    public TableColumn<Company, String> companyNifCol;
    public TableColumn<Company, String> phoneCompany;
    public TableView<Meeting> meetTable;
    public TableColumn<Meeting,String> meetingsNameCol;
    public TableColumn<Meeting,String> meetingDataCol;
    public TableColumn<Meeting,String> meetingDuracaoCol;
    public TableView<Professional> searchTable;
    public TableColumn<Professional,String> searchNameCol;
    public TableColumn<Professional,String> searchCompCol;
    public ComboBox<String> selectComComboBox;
    public HBox addSearchBox;
    public ComboBox <String>selectMeetComboBox;
    public TableView <Professional>searchTableMeet;
    public TableColumn<Professional,String> searchProCol;
    public TableColumn<Professional,String> searchMeetCol;
    public HBox addSearchBox1;
    public ComboBox <String>selecProRemoveComboBox;
    public TableView searchTableMeet1;
    public TableColumn searchProCol1; //
    public TableColumn searchMeetCol1;
    public HBox addSearchBox11;
    public TableView <Professional>removeTable;
    public HBox addSearchBox111;
    public TextField skillName;
    public TableColumn<Object, Object> searchSkill;
    public TableColumn<Object, Object> searchUnemployed;
    public TableView<Professional> removeUnemployedTable;
    public MenuItem removeEdge;
    public TextField addSkillName;
    public HBox addSearchBox12;
    public TextField printConexo;
    public HBox bipartiteHBOX;
    public TextField bipartiteTextField;
    public ComboBox<String> selectMeComboBox1;
    public TableColumn<Object, Object> shortestPathCompany;
    public TableColumn<Object, Object> shortestPathMeeting;
    public TableColumn shortestDistance;
    public ComboBox<String> selectCoComboBox2;
    public TableView<Object> tabelaparadistancia;
    public TableView<Meeting> tabelaparadistancia1;
    public TableColumn<Object, Object> shortestPathMetting1;
    public TableView<String> tabelaparadistancia2;
    public TableColumn<Object, Object> shortestPathDistance1;
    public TextField textFieldDistance;
    public TableView addTable;
    public TableColumn addProCol1;
    public TextField professionalNameField;
    public TextField genderField;
    public TextField birthDateField;
    public TextField skillsField;
    public TextField locationField;
    public TextField nifField;
    public TextField birthDateDayField;
    public TextField birthDateMonthField;
    public TextField birthDateYearField;
    public TextField locationXField;
    public TextField locationYField;
    public TextField probox1_graphpessoas;
    public TextField probox2_graphpessoas;
    public TextField probox3_graphpessoas1;
    public TextField proEmpBox1;
    public TextField proEmpBox2;
    public TextField proEmpBox3;
    public ComboBox<String> listProGraphPessoas;
    public ComboBox<String> listProGraphPessoas1;
    public ComboBox<String> listPro_GraphProEmp;
    public ComboBox<String> listEmp_GraphProEmp;
    public ComboBox<String> meet_graphMEP;
    public ComboBox<String> PE_GraphMEP;
    public TextField proEmpBox31;
    public ComboBox<String> comp_GraphMEP;
    public ComboBox<String> PE1_GraphMEP;
    public TextField proEmpBox311;
    public ComboBox<String> PE3_GraphMEP;
    public ComboBox<String> PE2_GraphMEP;
    public TextField proEmpBox3111;
    private Company cc =new Company("ola",334444,43434,null);
    private Graph graph;
    private String delimeter = ";";
    private double radius = 30.0;
    private String path_pessoas_txt = ".//data//professionals_graph.txt";
    private String path_companies_txt = ".//data//pro_comp_graph.txt";
    private String path_pro_comp_meet_txt = ".//data//point_comp_meet.txt";
    Graph_project gi = new Graph_project();

    public void create_vertice_in_ProGraph(int v)
    {
        Random r = new Random();
        double posX = r.nextDouble()*500;
        double posY = r.nextDouble()*500;
        Circle c = new Circle(posX,posY,radius);
        c.setOpacity(0.6);
        c.setFill(Color.RED);
        c.setId(""+v);
        Text text = new Text(""+v);
        StackPane stack = new StackPane();
        stack.setLayoutX(posX-radius);
        stack.setLayoutY(posY-radius);
        stack.getChildren().addAll(c,text);
        graphGroup.getChildren().add(stack);
    }

    public void drawGraph_Pro()
    {
        String delimiter = ";";
        In in = new In(path_pessoas_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = Integer.parseInt(a[1]);
            create_vertice_in_ProGraph(v);
        }
        in.close();
    }

    public void handleCreateProfessionalsGraphAction(ActionEvent actionEvent) {
        graphGroup.getChildren().clear();
        drawGraph_Pro();
        String delimiter = ";";
        In in = new In(path_pessoas_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = Integer.parseInt(a[1]);
            StackPane spv = (StackPane) graphGroup.getChildren().get(v);
            Circle cv = (Circle) spv.getChildren().get(0);
            for(int i = 2;i<a.length;i=i+2)
            {
                int w=Integer.parseInt(a[i]);
                StackPane spw = (StackPane) graphGroup.getChildren().get(w);
                Circle cw = (Circle) spw.getChildren().get(0);
                Line line = new Line(cv.getCenterX(),cv.getCenterY(),cw.getCenterX(),cw.getCenterY());
                graphGroup.getChildren().add(line);
            }
        }
        in.close();
    }

    public void create_vertex_in_ProCompGraph_Pro(int v)        //vertex Pro
    {
        Random r = new Random();
        double posX = r.nextDouble()*500;
        double posY = r.nextDouble()*500;
        Circle c = new Circle(posX,posY,radius);
        c.setOpacity(0.6);
        c.setFill(Color.RED);
        c.setId(""+v);
        Text text = new Text(""+v);
        StackPane stack = new StackPane();
        stack.setLayoutX(posX-radius);
        stack.setLayoutY(posY-radius);
        stack.getChildren().addAll(c,text);
        graphGroup1.getChildren().add(stack);
    }

    public void create_vertex_in_ProCompGraph_Comp(int v)        //vertex Company
    {
        Random r = new Random();
        double posX = r.nextDouble()*500;
        double posY = r.nextDouble()*500;
        Circle c = new Circle(posX,posY,radius);
        c.setOpacity(0.6);
        c.setFill(Color.BLUE);
        c.setId(""+v);
        Text text = new Text(""+v);
        StackPane stack = new StackPane();
        stack.setLayoutX(posX-radius);
        stack.setLayoutY(posY-radius);
        stack.getChildren().addAll(c,text);
        graphGroup1.getChildren().add(stack);
    }

    public void drawGraph_Pro_Comp()
    {
        String delimiter = ";";
        In in = new In(path_companies_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            String type = a[0];
            int v = Integer.parseInt(a[1]);
            if(type.compareTo("p")==0)
            {
                create_vertex_in_ProCompGraph_Pro(v);
            }else{
                create_vertex_in_ProCompGraph_Comp(v);
            }
        }
        in.close();
    }

    public void handleCreateProfessionalsCompaniesGraphAction(ActionEvent actionEvent) {
        graphGroup1.getChildren().clear();
        drawGraph_Pro_Comp();
        String delimiter = ";";
        In in = new In(path_companies_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = Integer.parseInt(a[1]);
            StackPane spv = (StackPane) graphGroup1.getChildren().get(v);
            Circle cv = (Circle) spv.getChildren().get(0);
            for(int i = 2;i<a.length;i=i+2)
            {
                int w=Integer.parseInt(a[i]);
                StackPane spw = (StackPane) graphGroup1.getChildren().get(w);
                Circle cw = (Circle) spw.getChildren().get(0);
                Line line = new Line(cv.getCenterX(),cv.getCenterY(),cw.getCenterX(),cw.getCenterY());
                graphGroup1.getChildren().add(line);
            }
        }
        in.close();
    }

    public void create_vertex_in_ProCompMeetGraph_Comp(int v)        //vertex Pro
    {
        Random r = new Random();
        double posX = r.nextDouble()*500;
        double posY = r.nextDouble()*500;
        Circle c = new Circle(posX,posY,radius);
        c.setOpacity(0.6);
        c.setFill(Color.BLUE);
        c.setId(""+v);
        Text text = new Text(""+v);
        StackPane stack = new StackPane();
        stack.setLayoutX(posX-radius);
        stack.setLayoutY(posY-radius);
        stack.getChildren().addAll(c,text);
        graphGroup2.getChildren().add(stack);
    }

    public void create_vertex_in_ProCompMeetGraph_Meet(int v)        //vertex Pro
    {
        Random r = new Random();
        double posX = r.nextDouble()*500;
        double posY = r.nextDouble()*500;
        Circle c = new Circle(posX,posY,radius);
        c.setOpacity(0.6);
        c.setFill(Color.ORANGE);
        c.setId(""+v);
        Text text = new Text(""+v);
        StackPane stack = new StackPane();
        stack.setLayoutX(posX-radius);
        stack.setLayoutY(posY-radius);
        stack.getChildren().addAll(c,text);
        graphGroup2.getChildren().add(stack);
    }

    public void create_vertex_in_ProCompMeetGraph_point(int v)        //vertex Pro
    {
        Random r = new Random();
        double posX = r.nextDouble()*500;
        double posY = r.nextDouble()*500;
        Circle c = new Circle(posX,posY,radius);
        c.setOpacity(0.6);
        c.setFill(Color.PINK);
        c.setId(""+v);
        Text text = new Text(""+v);
        StackPane stack = new StackPane();
        stack.setLayoutX(posX-radius);
        stack.setLayoutY(posY-radius);
        stack.getChildren().addAll(c,text);
        graphGroup2.getChildren().add(stack);
    }

    public void drawGraph_Pro_Comp_Meet()
    {
        String delimiter = ";";
        In in = new In(path_pro_comp_meet_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            String type = a[0];
            int v = Integer.parseInt(a[1]);
            if(type.compareTo("pe")==0)
            {
                create_vertex_in_ProCompMeetGraph_point(v);
            }else{
                if(type.compareTo("c")==0){
                    create_vertex_in_ProCompMeetGraph_Comp(v);
                }else {
                    create_vertex_in_ProCompMeetGraph_Meet(v);
                }
            }
        }
        in.close();
    }

    public void handleCreateProCompMeetGraphAction(ActionEvent actionEvent) {
        graphGroup2.getChildren().clear();
        drawGraph_Pro_Comp_Meet();
        String delimiter = ";";
        In in = new In(path_pro_comp_meet_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = Integer.parseInt(a[1]);
            StackPane spv = (StackPane) graphGroup2.getChildren().get(v);
            Circle cv = (Circle) spv.getChildren().get(0);
            for(int i = 2;i<a.length;i=i+2)
            {
                int w=Integer.parseInt(a[i]);
                StackPane spw = (StackPane) graphGroup2.getChildren().get(w);
                Circle cw = (Circle) spw.getChildren().get(0);
                Line line = new Line(cv.getCenterX(),cv.getCenterY(),cw.getCenterX(),cw.getCenterY());
                graphGroup2.getChildren().add(line);
            }
        }
        in.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //profissionais
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nifCol.setCellValueFactory(new PropertyValueFactory<>("nif"));
        companyCol.setCellValueFactory(new PropertyValueFactory<>("company_name"));

        //empresas
        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyNifCol.setCellValueFactory(new PropertyValueFactory<>("nif"));
        phoneCompany.setCellValueFactory(new PropertyValueFactory<>("phone"));

        //meetings
        meetingsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        meetingDataCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        meetingDuracaoCol.setCellValueFactory(new PropertyValueFactory<>("duration"));

        //search
        searchCompCol.setCellValueFactory(new PropertyValueFactory<>("company_name"));
        searchNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        searchMeetCol.setCellValueFactory(new PropertyValueFactory<>("meet"));
        searchProCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        searchUnemployed.setCellValueFactory(new PropertyValueFactory<>("name"));
        searchSkill.setCellValueFactory(new PropertyValueFactory<>("skills"));

        //calcular distancia
        shortestPathCompany.setCellValueFactory(new PropertyValueFactory<>("name"));
        shortestPathMetting1.setCellValueFactory(new PropertyValueFactory<>("name"));

    }

    public void handleReadFileAction(ActionEvent actionEvent) {
        readProfessionalFile();
        readCompanyFile();
        readMeetFile();
        addProToConect_Graph_Pessoas();
        listEmp_ConnectGraph();
        showMeetMEP();
        showPointsMEP();
    }

    public void readMeetFile() {
        meetTable.getItems().clear();
        for (Date d:meetings.keys()) {
            meetTable.getItems().addAll(meetings.get(d));
        }
    }

    public void readCompanyFile() {
        companyTable.getItems().clear();
        for (Integer d : company.keys()) {
                companyTable.getItems().addAll(company.get(d));
        }
    }

    public void readProfessionalFile() {
        professionalTable.getItems().clear();
        for (Integer d:professionals.keys()) {
            professionalTable.getItems().addAll(professionals.get(d));
        }
    }

    public void handleSelectCompanyFiles(ActionEvent actionEvent) {
        addCompaniesToComboBox();
    }


    public void handleSelectMeetFiles(ActionEvent actionEvent) {
        addMeetingsToComboBox();
    }

    public void addCompaniesToComboBox(){
        selectComComboBox.getItems().clear();
        for (Integer d:company.keys()) {
            selectComComboBox.getItems().addAll(company.get(d).getName());
        }
    }

    public void addMeetingsToComboBox(){
        selectMeetComboBox.getItems().clear();
        for (Date d:meetings.keys()) {
            selectMeetComboBox.getItems().addAll(meetings.get(d).getName());
        }
    }

    public void handleSelectCompany(ActionEvent actionEvent) {
        searchTable.getItems().clear();
        String dname = selectComComboBox.getValue();
        for(int i=0;i<pessoas_empresas.digraph().V();i++) {
            int j = gi.pro_or_comp_or_meet(pessoas_empresas, i);
                if (j == 1) {
                    for (Integer c:company.keys()) {
                        if(company.get(c).getNif()==Integer.parseInt(pessoas_empresas.nameOf(i))){
                            if(company.get(c).getName().equals(dname)){
                                for (Integer p:professionals.keys()) {
                                    if(professionals.get(p).getCompany().equals(company.get(c))){
                                        searchTable.getItems().addAll(professionals.get(p));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    public void handleSelectMeet(ActionEvent actionEvent) {
        searchTableMeet.getItems().clear();
        String dname = selectMeetComboBox.getValue();
        for (int i = 0; i < point_comp_meet.digraph().V(); i++) {
            int j = gi.pro_or_comp_or_meet(point_comp_meet, i);
            if (j == 2) {
                for (Date d : meetings.keys()) {
                    if (meetings.get(d).getDate().toString().compareTo(point_comp_meet.nameOf(i)) == 0) {
                        if (meetings.get(d).getName().equals(dname)) {
                            for (Integer po : professionals.keys()) {
                                if (professionals.get(po).getMeet().contains(meetings.get(d).getName()))
                                    searchTableMeet.getItems().addAll(professionals.get(po));
                            }
                        }
                    }
                }
            }
        }
    }

    /// Pesquisar profissionais desempregados por skill

    public void handleInsertSkillButton(ActionEvent actionEvent) {
        String desempregado="Desempregado";
        removeUnemployedTable.getItems().clear();
        String name = addSkillName.getText();
        name = name.toLowerCase();
        for (Integer d:professionals.keys()) {
            if(professionals.get(d).getSkills().contains(name)){
                if(professionals.get(d).getCompany().getName().contains(desempregado)){
                    removeUnemployedTable.getItems().addAll(professionals.get(d));
                }
            }
        }
    }

    /// Graph Bipartite
    public void handleProCompBipartite(ActionEvent actionEvent) {
        Bipartite_Projeto bp = new Bipartite_Projeto(pessoas_empresas);
        bipartiteTextField.setText(""+bp.isBipartite());
    }

    /// Graph Conexo
    public void handleProConexo(ActionEvent actionEvent) {
        DepthFirstSearch_Project dfs = new DepthFirstSearch_Project(pessoas,0);
        if (dfs.count() != pessoas.graph().V())
            printConexo.setText("Conexo");
        else
            printConexo.setText("Not Conexo");
    }

    //caminho mais curto entre meet e empresa  (Dijkstra)
    public void handleLoadCompaniesAndMettings(ActionEvent actionEvent) {
        selectMeComboBox1.getItems().clear();
        for (Date d:meetings.keys()) {
            selectMeComboBox1.getItems().addAll(meetings.get(d).getName());
        }

        selectCoComboBox2.getItems().clear();
        for (Integer d:company.keys()) {
            selectCoComboBox2.getItems().addAll(company.get(d).getName());
        }
    }
    public void handleSelectCoComboBox(ActionEvent actionEvent) {
        tabelaparadistancia.getItems().clear();
        String dname = selectCoComboBox2.getValue();
        for (Integer c:company.keys()){
            if(company.get(c).getName().equals(dname)){
                tabelaparadistancia.getItems().addAll(company.get(c));
            }
        }
    }
    public void handleSeleMeetComboBox1(ActionEvent actionEvent) {
        tabelaparadistancia1.getItems().clear();
        String dname = selectMeComboBox1.getValue();
        for (Date d:meetings.keys()){
            if(meetings.get(d).getName().equals(dname)){
                tabelaparadistancia1.getItems().addAll(meetings.get(d));
            }
        }
    }

    public void handleCalculeDistance(ActionEvent actionEvent) {
        String compName=selectCoComboBox2.getValue();
        String meetName=selectMeComboBox1.getValue();
        for (Integer c:company.keys()) {
            if(company.get(c).getName().equals(compName)){
                for (Date d:meetings.keys()) {
                    if ((meetings.get(d).getName().equals(meetName))){
                        /////////////// CODIGO DO (Dijkstra) //////////////////
                        for (int v = 0; v < point_comp_meet.digraph().V(); v++) {
                            int i = gi.pro_or_comp_or_meet(point_comp_meet, v);
                            if (i == 1) {
                                if (company.get(c).getNif() == Integer.parseInt(point_comp_meet.nameOf(v))) {
                                    for (int vi = 0; vi < point_comp_meet.digraph().V(); vi++) {
                                        int x = gi.pro_or_comp_or_meet(point_comp_meet, vi);
                                        if (x == 2) {
                                            if (meetings.get(d).getDate().toString().compareTo(point_comp_meet.nameOf(vi)) == 0) {
                                                DijkstraSP_Projeto sp = new DijkstraSP_Projeto(point_comp_meet, v);
                                                if (sp.hasPathTo(vi)) {
                                                    textFieldDistance.setText(v + "-" + vi + " " + sp.distTo(vi));
                                                } else {
                                                    textFieldDistance.setText("Sem Caminho Possivel");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    /// Adicionar/Eliminar Edge ///

    public void handleRemoveEdgePro(ActionEvent actionEvent) {
        //addProToComboBox();
        //removeProEge();
    }
    public void removeProEge(){
    }
    public void handleSelectProRemove(ActionEvent actionEvent) {
//        removeTable.getItems().clear();
//        In in = new In(".//data//professionals_JAVAFX.txt");
//        in.readLine();
//        while (!in.isEmpty()) {
//            String[] texto = in.readLine().split(";");
//            String name_pro = texto[0];
//            Professional test = new Professional(name_pro,null,null,null,null,null);
//            removeTable.getItems().addAll(test);
//        }
//        in.close();
    }


    /// Adicionar Profissional ///

    public void handlerAddProFile1(ActionEvent actionEvent) {

    }

    public void handleAddProAction(ActionEvent actionEvent) {
        String name = professionalNameField.getText();
        String gender = genderField.getText();
        // data
        int dia = Integer.parseInt(birthDateDayField.getText());
        int mes = Integer.parseInt(birthDateMonthField.getText());
        int ano = Integer.parseInt(birthDateYearField.getText());
        Date d1 = new Date(dia,mes,ano,0,0);
        // localizacao
        int x = Integer.parseInt(locationXField.getText());
        int y = Integer.parseInt(locationYField.getText());
        Location l1 = new Location(x,y);
        //nif
        int nif = Integer.parseInt(nifField.getText());
        //skills
        ArrayList<String> skillsP1 = new ArrayList<>();
        String skills = skillsField.getText();
        skillsP1.add(skills);
        Professional p1 = new Professional(name,gender,d1,skillsP1,l1,nif);
        System.out.println(p1.getName()+" "+p1.getGender()+" "+p1.getBirth_date()+" "+"" +p1.getLocation()+" "+p1.getSkills()+" "+p1.getNif());
    }

    public void handlerbutoonConnect_Pro_Pro(ActionEvent actionEvent) {
        String p1 = listProGraphPessoas.getValue();
        String p2 = listProGraphPessoas1.getValue();
        Integer i = Integer.parseInt(probox3_graphpessoas1.getText());

        for (Integer pi1:professionals.keys()) {
            if(professionals.get(pi1).getName().compareTo(p1)==0){
                for(Integer pi2:professionals.keys()){
                    if(professionals.get(pi2).getName().compareTo(p2)==0){
                        gi.conect_2_people(professionals.get(pi1),professionals.get(pi2),pessoas,".//data//professionals_graph.txt",i);
                    }
                }
            }
        }
        handleCreateProfessionalsGraphAction(null);
        listProGraphPessoas.getItems().clear();
        listProGraphPessoas1.getItems().clear();
    }

    public void handlerButtonConnect_Pro_Emp(ActionEvent actionEvent) {
        String p1 = listPro_GraphProEmp.getValue();
        String c1 = listEmp_GraphProEmp.getValue();
        Integer i = Integer.parseInt(proEmpBox3.getText());

        for (Integer pi1:professionals.keys()) {
            if(professionals.get(pi1).getName().compareTo(p1)==0){
                for(Integer pi2:company.keys()){
                    if(company.get(pi2).getName().compareTo(c1)==0){
                        gi.conect_pro_comp_graphProCompMeet(professionals.get(pi1),company.get(pi2),pessoas_empresas,".//data//pro_comp_graph.txt",i);
                    }
                }
            }
        }
        handleCreateProfessionalsCompaniesGraphAction(null);
        listPro_GraphProEmp.getItems().clear();
        listEmp_GraphProEmp.getItems().clear();
    }

    public void handlerConnect_M_P(ActionEvent actionEvent) {
        String m1 = meet_graphMEP.getValue();
        String pe1 = PE_GraphMEP.getValue();
        Integer i = Integer.parseInt(proEmpBox31.getText());

        for (Date pi1:meetings.keys()) {
            if(meetings.get(pi1).getName().compareTo(m1)==0){
                for(Integer pi2:pontosDeEncontro.keys()){
                    if(pontosDeEncontro.get(pi2).getName().compareTo(pe1)==0){
                        gi.conect_meet_point_graphProCompMeet(meetings.get(pi1),pontosDeEncontro.get(pi2),point_comp_meet,".//data//point_comp_meet.txt",i);
                    }
                }
            }
        }
        handleCreateProCompMeetGraphAction(null);
        meet_graphMEP.getItems().clear();
        PE_GraphMEP.getItems().clear();
    }

    public void handler_Connect_C_P(ActionEvent actionEvent) {
        String c1 = comp_GraphMEP.getValue();
        String pe1 = PE1_GraphMEP.getValue();
        Integer i = Integer.parseInt(proEmpBox311.getText());

        for (Integer pi1:company.keys()) {
            if(company.get(pi1).getName().compareTo(c1)==0){
                for(Integer pi2:pontosDeEncontro.keys()){
                    if(pontosDeEncontro.get(pi2).getName().compareTo(pe1)==0){
                        gi.conect_comp_point_graphProCompMeet(company.get(pi1),pontosDeEncontro.get(pi2),point_comp_meet,".//data//point_comp_meet.txt",i);
                    }
                }
            }
        }
        handleCreateProCompMeetGraphAction(null);
        comp_GraphMEP.getItems().clear();
        PE1_GraphMEP.getItems().clear();
    }

    public void hander_Connect_P_P(ActionEvent actionEvent) {
        String c1 = PE2_GraphMEP.getValue();
        String pe1 = PE3_GraphMEP.getValue();
        Integer i = Integer.parseInt(proEmpBox3111.getText());

        for (Integer pi1:pontosDeEncontro.keys()) {
            if(pontosDeEncontro.get(pi1).getName().compareTo(c1)==0){
                for(Integer pi2:pontosDeEncontro.keys()){
                    if(pontosDeEncontro.get(pi2).getName().compareTo(pe1)==0){
                        gi.conect_point_point_graphProCompMeet(pontosDeEncontro.get(pi1),pontosDeEncontro.get(pi2),point_comp_meet,".//data//point_comp_meet.txt",i);
                    }
                }
            }
        }
        handleCreateProCompMeetGraphAction(null);
        PE2_GraphMEP.getItems().clear();
        PE3_GraphMEP.getItems().clear();
    }

    public void listEmp_ConnectGraph()
    {
        for (Integer d:company.keys()) {
            listEmp_GraphProEmp.getItems().addAll(company.get(d).getName());
            comp_GraphMEP.getItems().addAll(company.get(d).getName());
        }
    }

    public void addProToConect_Graph_Pessoas(){
        for (Integer d:professionals.keys()) {
            listProGraphPessoas.getItems().addAll(professionals.get(d).getName());
            listProGraphPessoas1.getItems().addAll(professionals.get(d).getName());
            listPro_GraphProEmp.getItems().addAll(professionals.get(d).getName());
        }
    }

    public void showMeetMEP(){
        for (Date d:meetings.keys()) {
            meet_graphMEP.getItems().addAll(meetings.get(d).getName());
        }
    }



    public void showPointsMEP(){
        for (Integer d:pontosDeEncontro.keys()) {
            PE_GraphMEP.getItems().addAll(pontosDeEncontro.get(d).getName());
            PE1_GraphMEP.getItems().addAll(pontosDeEncontro.get(d).getName());
            PE2_GraphMEP.getItems().addAll(pontosDeEncontro.get(d).getName());
            PE3_GraphMEP.getItems().addAll(pontosDeEncontro.get(d).getName());
        }
    }

    public void handlerlistProGraphPessoas(ActionEvent actionEvent) {
        addProToConect_Graph_Pessoas();
    }

    public void handlerlistProGraphPessoas1(ActionEvent actionEvent) {
        addProToConect_Graph_Pessoas();
    }

    public void handlerlistPro_GraphProEmp(ActionEvent actionEvent) {
        addProToConect_Graph_Pessoas();
    }

    public void handlerlistEmp_GraphProEmp(ActionEvent actionEvent) {
        listEmp_ConnectGraph();
    }

    public void handlermeet_graphMEP(ActionEvent actionEvent) {
        showMeetMEP();
    }

    public void handlerPE_GraphMEP(ActionEvent actionEvent) {
        showPointsMEP();
    }

    public void handlercomp_GraphMEP(ActionEvent actionEvent) {
        listEmp_ConnectGraph();
    }

    public void handlerPE1_GraphMEP(ActionEvent actionEvent) {
        showPointsMEP();
    }

    public void handlerPE2_GraphMEP(ActionEvent actionEvent) {
        showPointsMEP();
    }

    public void handlerPE3_GraphMEP(ActionEvent actionEvent) {
        showPointsMEP();
    }

}
