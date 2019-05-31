package Projeto.Fase2_JavaFX;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Random;

public class GraphCreatorFXMLController {

    public TextField verticesNumberField;
    public TextArea edgesField;
    public Group graphGroup;
    public MenuItem openGraph;
    public MenuItem editGraph;
    public MenuItem editGraph1;
    public Button createButton;
    public MenuItem companiesGraph;
    public MenuItem professionalGraph;
    public TableColumn nameCol;
    public TableColumn nifCol;
    public TableColumn companyCol;
    public TableColumn companyNameCol;
    public TableColumn companyNifCol;
    public TableColumn professionalsCompanyCol;
    public TableColumn meetingsNameCol;
    public TableColumn meetingDataCol;
    public TableColumn meetingDuracaoCol;
    private Graph graph;
    private String delimeter = ";";
    private double radius = 12.0;

    public void handleCreateButtonAction(ActionEvent actionEvent) {
//        int vNumber = Integer.parseInt(verticesNumberField.getText());
//        graph = new Graph(vNumber);
//        createGraphGroup(vNumber);
//        String[] lines = edgesField.getText().split("\n");
//        for(String li : lines)
//        {
//            String[] a = li.split(delimeter);
//            int v = Integer.parseInt(a[0]);
//            StackPane spv = (StackPane) graphGroup.getChildren().get(v);
//            Circle cv = (Circle) spv.getChildren().get(0);
//            for(int i = 1; i<a.length;i++)
//            {
//                int w=Integer.parseInt(a[i]);
//                graph.addEdge(v,w);
//                StackPane spw = (StackPane) graphGroup.getChildren().get(w);
//                Circle cw = (Circle) spw.getChildren().get(0);
//                Line line = new Line(cv.getCenterX(),cv.getCenterY(),cw.getCenterX(),cw.getCenterY());
//                graphGroup.getChildren().add(line);
//            }
//        }
//        System.out.println(graph);
    }

    public void createGraphGroup(int vNumber)
    {
        for(int i = 0; i<vNumber;i++)
        {
            Random r = new Random();
            double posX = r.nextDouble()*150;
            double posY = r.nextDouble()*130;
            Circle c = new Circle(posX,posY,radius);
            c.setOpacity(0.6);
            c.setFill(Color.DEEPSKYBLUE);
            c.setId(""+i);
            Text text = new Text(""+i);
            StackPane stack = new StackPane();
            stack.setLayoutX(posX-radius);
            stack.setLayoutY(posY-radius);
            stack.getChildren().addAll(c,text);
            graphGroup.getChildren().add(stack);
        }
    }

    public void handleCreateProfessionalsGraphAction(ActionEvent actionEvent) {
    }

    public void handleCreateCompaniesGraphAction(ActionEvent actionEvent) {
    }

    public void handleCreateProfessionalsCompaniesGraphAction(ActionEvent actionEvent) {
    }
}
