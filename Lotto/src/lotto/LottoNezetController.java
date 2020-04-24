
package lotto;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

 //codingbat.com

public class LottoNezetController implements Initializable {
    
   private final int MIN = 1;
   private final int MAX = 89;
   
   private int genNum1 ;
   private int genNum2 ;
   private int genNum3 ;
   private int genNum4 ;
   private int genNum5 ;
   
   private int selnum1 ;
   private int selnum2 ;
   private int selnum3 ;
   private int selnum4 ;
   private int selnum5 ;
    
    @FXML
    private Pane basePane;
     @FXML
    private Pane alertPane;
      @FXML
    private Label alertText;
      @FXML
    private Button alertButton;
   
    @FXML
    private Label Label1;
     @FXML
    private Label Label2;
      @FXML
    private Label Label3;
       @FXML
    private Label Label4;
        @FXML
    private Label Label5;

        @FXML
     private TextField input1; 
        @FXML
     private TextField input2; 
        @FXML
     private TextField input3; 
        @FXML
     private TextField input4; 
        @FXML
     private TextField input5; 
        
         @FXML
     private Label eredmenyLabel; 
   
         @FXML
    private void handleAlertButton(ActionEvent event) {
         alertPane.setVisible(false);
          basePane.setDisable(false);
          basePane.setOpacity(1);
         
     

    }
        
        
        @FXML
    private void handleButtonAction(ActionEvent event) {
       
   
      genNum1 = 0;
      genNum2 = 0;
      genNum3 = 0;
      genNum4 = 0;
      genNum5 = 0;
      
      genNum1 = getRandomNumber();
      genNum2 = getRandomNumber();
      genNum3 = getRandomNumber();
      genNum4 = getRandomNumber();
      genNum5 = getRandomNumber();
      
      Label1.setText("" + genNum1);
      Label2.setText("" + genNum2);
      Label3.setText("" + genNum3);
      Label4.setText("" + genNum4);
      Label5.setText("" + genNum5);
      
      calculate();
   
    }
    
    private void alert (String text){
         alertPane.setVisible(true);
          alertText.setText(text);
          basePane.setDisable(true);
          basePane.setOpacity(0.3);
    } 
    
   private String calculate () {
      
        try {
      selnum1 = Integer.parseInt(input1.getText());
      selnum2 = Integer.parseInt(input2.getText());
      selnum3 = Integer.parseInt(input3.getText());
      selnum4 = Integer.parseInt(input4.getText());
      selnum5 = Integer.parseInt(input5.getText());
        }
        catch(Exception e) {
          alert("Nem jo szamot adtal meg");
          
          return "";
      }
        if(selnum1 < 1 || selnum1 > 90 || selnum2 < 1 || selnum2 > 90 || selnum3 < 1 || selnum3 > 90 ||selnum4 < 1 || selnum4 > 90 ||selnum5 < 1 || selnum5 > 90 ) {
          alert("1 es 90 kozoti szamot adjal meg");
        }  
            
          
   Set<Integer> selectednumbers = new HashSet <>() ;
       selectednumbers.add(selnum1);  
       selectednumbers.add(selnum2);
       selectednumbers.add(selnum3);
       selectednumbers.add(selnum4);
       selectednumbers.add(selnum5);
       
       if(selectednumbers.size() < 5 ){
         alert("A szamoknak kulombozoeknek kell lenniuk");
       }
       
       ArrayList<Integer> usernumbers = new ArrayList <>(selectednumbers);
       
       int result = 0;
       
       for( int i=0; i < usernumbers.size() ; i++ ){
           
           if(usernumbers.get(i) == genNum1 || usernumbers.get(i) == genNum2 || usernumbers.get(i) == genNum3 || usernumbers.get(i) == genNum4 || usernumbers.get(i) == genNum5 )
               result++;
               }
     switch(result){
         
         case  0 : eredmenyLabel.setText("Nem nyertel semmit");
            break;
          
         case  1 : eredmenyLabel.setText("Gratulalok van " + result  + " egy talalatod");
            break;
             
         case  2 : eredmenyLabel.setText("Gratulalok nyertel egy fel guminot");
            break;
                 
         case  3 : eredmenyLabel.setText("Gratulalok van" + result  + " talalatod");
            break;
                     
         case  4 : eredmenyLabel.setText("Gratulalok van" + result  + " talalatod");
            break;
                     
         case  5 : eredmenyLabel.setText("Gratulalok van" + result  + " talalatod");
            break;
             
                 }
       return "";
}
  private int getRandomNumber () {
      int random = (int) (Math.random() * MAX) + MIN;
      
      if(random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5 ) {
          
       return getRandomNumber();
      }
      return random;
            
  }      
            @Override
    public void initialize(URL url, ResourceBundle rb) {
       System.out.println("Szia Cunci Punci");
    }     
    
}
