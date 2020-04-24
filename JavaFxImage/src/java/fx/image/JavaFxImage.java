/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.fx.image;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JavaFxImage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane pane = new StackPane();
        Image image = new Image("C:/Users/Ace Mcloud/Documents/NetBeansProjects/JavaFxImage/PlansaBiela.jpg");
        ImageView imageview = new ImageView(image);
        pane.getChildren().add(imageview);
        pane.setAlignment(imageview, Pos.TOP_LEFT);
        
        Scene scene1 = new Scene(pane,1200,800);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Programunk");
        primaryStage.show();
        
        
    
    
    
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
