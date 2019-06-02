package Projeto.Fase2_JavaFX;

import Projeto.*;
import edu.princeton.cs.algs4.In;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import edu.princeton.cs.algs4.Graph;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GraphCreatorFXMLController implements Initializable {

    public TextField verticesNumberField;
    public TextArea edgesField;
    public MenuItem openGraph;
    public MenuItem editGraph;
    public MenuItem editGraph1;
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
    public TableColumn<Professional,String> searchProMeet;
    private Graph graph;
    private String delimeter = ";";
    private double radius = 10.0;
    private String path_pessoas_txt = ".//data//professionals_graph.txt";
    private String path_companies_txt = ".//data//pro_comp_graph.txt";
    private String path_pro_comp_meet_txt = ".//data//pro_comp_meet.txt";

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
            int v = Integer.parseInt(a[0]);
            create_vertice_in_ProGraph(v);
        }
        in.close();
    }

    public void handleCreateProfessionalsGraphAction(ActionEvent actionEvent) {
        drawGraph_Pro();
        String delimiter = ";";
        In in = new In(path_pessoas_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = Integer.parseInt(a[0]);
            StackPane spv = (StackPane) graphGroup.getChildren().get(v);
            Circle cv = (Circle) spv.getChildren().get(0);
            for(int i = 1;i<a.length;i=i+2)
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

    public void create_vertex_in_ProCompMeetGraph_Pro(int v)        //vertex Pro
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
        graphGroup2.getChildren().add(stack);
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

    public void drawGraph_Pro_Comp_Meet()
    {
        String delimiter = ";";
        In in = new In(path_pro_comp_meet_txt);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            String type = a[0];
            int v = Integer.parseInt(a[1]);
            if(type.compareTo("p")==0)
            {
                create_vertex_in_ProCompMeetGraph_Pro(v);
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
    }

    public void handleReadFileAction(ActionEvent actionEvent) {
        readProfessionalFile();
        readCompanyFile();
        readMeetFile();
    }

    public void readMeetFile() {
        meetTable.getItems().clear();
        In in = new In(".//data//meets_JAVAFX.txt");
        in.readLine();
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String[] d = texto[1].split("/");
            String meet_name = texto[0];
            Integer dur = Integer.parseInt(texto[2]);
            Date date = new Date(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]),0,0);
            Meeting m = new Meeting(meet_name,dur,null,null,date);
            meetTable.getItems().addAll(m);
        }
        in.close();
    }

    public void readCompanyFile() {
        companyTable.getItems().clear();
        In in = new In(".//data//company_JAVAFX.txt");
        in.readLine();
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String name_c = texto[0];
            Integer nif = Integer.parseInt(texto[1]);
            Integer phone = Integer.parseInt(texto[2]);
            Company c = new Company(name_c,phone,nif,null);
            companyTable.getItems().addAll(c);
        }
        in.close();
    }

    public void readProfessionalFile() {
        professionalTable.getItems().clear();
        In in = new In(".//data//professionals_JAVAFX.txt");
        in.readLine();
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String name_pro = texto[0];
            Integer nif = Integer.parseInt(texto[1]);
            Professional test = new Professional(name_pro,null,null,null,null,nif);
            String comp_name = texto[2];
            Company test1 = new Company(comp_name,0,0,null);
            test.setCompany(test1);
            professionalTable.getItems().addAll(test);
        }
        in.close();
    }

    public void handleSearchProComp(ActionEvent actionEvent) {
        searchProComp();
    }

    public void handleSearchProMeet(ActionEvent actionEvent) {
    }

    public void searchProComp(){
        searchTable.getItems().clear();
        String path_search_comp_pro_txt = ".//data//search_comp_pro.txt";
        In in = new In(path_search_comp_pro_txt);
        in.readLine();
        while (!in.isEmpty()){
            String[] texto = in.readLine().split(";");
            String comp_name = texto[0];
            Company comp = new Company(comp_name,0,0,null);
            String name_pro = texto[1];
            Professional pro = new Professional(name_pro,null,null,null,null,null);
            pro.setCompany(comp);
            searchTable.getItems().addAll(pro);
        }
        in.close();
    }
}
