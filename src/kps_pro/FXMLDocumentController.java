/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kps_pro;

import aima.core.logic.propositional.inference.PLResolution;
import aima.core.logic.propositional.kb.KnowledgeBase;
import aima.core.logic.propositional.kb.data.Clause;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author asd
 */
public class FXMLDocumentController implements Initializable {
        @FXML
    private Pane p2;

    @FXML
    private JFXTextField q1;

    @FXML
    private JFXTextField ask1;

    @FXML
    private JFXTextField out1;

    @FXML
    private Pane p21;

    @FXML
    private JFXTextField q11;

    @FXML
    private JFXTextField ask11;

    @FXML
    private JFXTextField out11;

    @FXML
    private Pane p22;

    @FXML
    private JFXTextField q12;

    @FXML
    private JFXTextField ask12;

    @FXML
    private JFXTextField out12;

    @FXML
    private Pane p1;

    
    @FXML
    private Label label;
    
     @FXML
    private void res(ActionEvent event) {
        
        p1.setVisible(false);
        p2.setVisible(true);
        p21.setVisible(false);
        p22.setVisible(false);
    } 
       @FXML
    private void bc(ActionEvent event) {
        
        p1.setVisible(false);
        p21.setVisible(true);
        p2.setVisible(false);
        p22.setVisible(false);
    } 
       @FXML
    private void fc(ActionEvent event) {
        
        p1.setVisible(false);
        p22.setVisible(true);
        p21.setVisible(false);
        p2.setVisible(false);
    } 
    @FXML
    private void ba(ActionEvent event) {
        
        p21.setVisible(false);
        p1.setVisible(true);
        p2.setVisible(false);
        p22.setVisible(false);
    } 
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

 @FXML
    private void out_res(ActionEvent event) {
    
        Res(q1.getText(), ask1.getText());
        
    }
    
    @FXML
    private void out_b(ActionEvent event) {
   
        //"r","p=>q;q=>r;p;q;"
       
       BC bc=new BC( ask11.getText(),q11.getText());
        System.out.println(bc.execute());
      
        out11.setText(bc.execute());
        
    }
    
    @FXML
    private void out_f(ActionEvent event) {
    
      BC bc=new BC( ask12.getText(),q12.getText());
        System.out.println(bc.execute());
      
        out12.setText(bc.execute());
        
    }


    @FXML
    private void Res(String s,String g) {
                   PLResolution resolution = new PLResolution();
            KnowledgeBase kb = new KnowledgeBase();
            //"(A | B) & ( C) & (~B | D) & (C => G) & (~D | G)"
            kb.tell(s);
            KnowledgeBase alpha = new KnowledgeBase();
            //"G"
            alpha.tell(g);
            boolean result = resolution.plResolution(kb, alpha.asSentence());
            Set<Clause> cnfForm = kb.asCNF();
            String cnf = "";
            for (Clause c : cnfForm) {
                cnf+=c.toString();

            }
            if (result) {
                System.out.println(cnf+"true");
                out1.setText(cnf+"true");
              //  resultLabel.setText("CNF: "+cnf+ "\nTrue");
            } else {
                                System.out.println(cnf+"false");
                                out1.setText(cnf+"false");
               // resultLabel.setText("CNF: "+cnf+"\nFalse");
            }
        }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
