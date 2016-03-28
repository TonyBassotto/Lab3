package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.model.model;
import it.polito.tdp.lab3.model.studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SegreteriaStudentiController {
	model m=new model();
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> boxCorsi;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea txtNome;

    @FXML
    private TextArea txtCognome;
    
    @FXML
    private ImageView imgX;

    @FXML
    private Button btnFound;

    @FXML
    private Button btnSubmission;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCheck(ActionEvent event) {
    	try {String c=txtMatricola.getText();
    	if(c.length()==0){
    		txtNome.setText("v u o t o");
    		txtCognome.setText("found");
    		//Image x=new Image("glossy-grey-icon-button-hi.png");
    		//imgX.setImage(x);
    		}else if(txtMatricola.getText()!=null){
    			studente s=m.checkStudent(c);
    			if(s==null){
    				txtNome.setText("not");
    				txtCognome.setText("found");
    				//Image x=new Image("glossy-grey-icon-button-hi.png");
    				//imgX.setImage(x);
    			
    			}else{
    				txtNome.setText(s.getNome());
    				txtCognome.setText(s.getCognome());
    				//Image x=new Image(getClass().getResourceAsStream("300px-Button_Icon_Green.svg.png"));//new Image(getClass().getResourceAsStream("logo.png"))
    				//1btnCheck.setGraphic(new ImageView(x));
    	    		}
    		}
    	}
    		catch(NumberFormatException nfe){
    			txtNome.setText("errore");

    			txtCognome.setText("errore");
    			//Image x=new Image("@../../../../../imh/glossy-grey-icon-button-hi.png");
    			//imgX.setImage(x);
    		
    	}
    		catch(Exception e){
    			txtNome.setText(" ");

    			txtCognome.setText(" ");
    			//Image x=new Image("@../../../../../imh/glossy-grey-icon-button-hi.png");
    			//imgX.setImage(x);
    		
    	}
    	
    }

    @FXML
    void doFound(ActionEvent event) {
    	if(boxCorsi.getValue()==null && txtMatricola.getText().length()==0){
    		txtResult.setText("Error 1004:\n Campi vuoti.");
    	}else{
    		try{
    	
    		if(boxCorsi.getValue()!=null && txtMatricola.getText().length()==0){
    	
    	String materia=boxCorsi.getValue();
    	txtResult.setText(m.giveStudents(materia));
    	}if(boxCorsi.getValue()==null && txtMatricola.getText().length()!=0){
    		String matricola=txtMatricola.getText();
    		txtResult.setText(m.giveMaterie(matricola));
    	}else {
    		String matricola=txtMatricola.getText();
    		String materia=boxCorsi.getValue();
    		txtResult.setText(m.presente(matricola,materia));
    	}
    		}
    	

    	
    	catch(Exception e){
    		txtResult.setText("Error 1001:\n Matricola emessa in maniera errata.");
    	}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtNome.setText("");
		txtCognome.setText("");
		txtMatricola.setText("");
		txtResult.setText("");
		boxCorsi.setValue(null);

    }

    @FXML
    void doSubmission(ActionEvent event) {
    	try{
    	if(boxCorsi.getValue()!=null && txtMatricola.getText().length()!=0){
    		String matricola=txtMatricola.getText();
    		String materia=boxCorsi.getValue();
    		txtResult.setText(m.sub(matricola,materia));
    	}
    	}
    	catch(Exception e){
    		txtResult.setText("Error 1001:\n Matricola emessa in maniera errata.");
    	}

    }

    @FXML
    void initialize() {
        assert boxCorsi != null : "fx:id=\"boxCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnFound != null : "fx:id=\"btnFound\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSubmission != null : "fx:id=\"btnSubmission\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        //assert imgX != null : "fx:id=\"imgX\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

       //ImageIcon x=new ImageIcon("E:/UNIVERSITA'/Programmazione a Oggetti/Lab3/logeo black-02.png");
     
        // btnCheck.setIcon(new ImageIcon("E:/UNIVERSITA'/Programmazione a Oggetti/Lab3/logeo black-02.png"));
   
       boxCorsi.getItems().addAll(m.corsi());
        
    }
}

