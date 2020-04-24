
package bemutato;

//import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Bemutato extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Button("Elso Button"));
        Scene scene1 = new Scene(pane1,300,50);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Elso Stage");
        primaryStage.show();
        
        
        
      /*  Stage stage2 = new Stage();
        stage2.setScene(new Scene (new Button ("Masodik Button"),300,100));
        stage2.setTitle("Masodik Stage");
        stage2.show();
      */  
        Pane pane3 = new Pane(); 
         Stage stage3 = new Stage();
         Circle circle1 = new Circle();
         circle1.setRadius(50);/*
         circle1.setCenterX(70);
         circle1.setCenterY(70);*/
         circle1.centerXProperty().bind(pane3.widthProperty().divide(2));
         circle1.centerYProperty().bind(pane3.widthProperty().divide(2));
        // circle1.setFill(Color.WHITE);
         
         //Color color = new Color (0.3,0.7,0.5,1);
         //Color color2 = color.brighter();
         //circle1.setFill(color);
         circle1.setStyle("-fx-fill:green;-fx-stroke:red");
         
         pane3.getChildren().add(circle1);
        stage3.setScene(new Scene (pane3,300,300));
        stage3.setTitle("Harmadik Stage");
        stage3.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
