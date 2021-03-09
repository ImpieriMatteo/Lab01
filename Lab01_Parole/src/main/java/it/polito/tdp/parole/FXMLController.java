package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParoleArrayList;
import it.polito.tdp.parole.model.ParoleLinkedList;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleArrayList elenco;
	ParoleLinkedList elenco2;
	String prova;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempistiche;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    void doInsert(ActionEvent event) {
    	this.elenco.addParola(this.txtParola.getText());
    	this.elenco2.addParola(this.txtParola.getText());
    	this.txtTempistiche.clear();
    	this.txtResult.clear();
    	for(String s : this.elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    	}
    	this.txtParola.clear();
    	
    	this.txtTempistiche.setText("Tempistiche ArrayList\n");
    	this.txtTempistiche.appendText("Durata Inserimento: "+Long.toString(this.elenco.getDurataAdd())+" nanosecondi\n");
    	this.txtTempistiche.appendText("Durata Sort: "+Long.toString(this.elenco.getDurataSort())+" nanosecondi\n");
    	
    	this.txtTempistiche.appendText("\nTempistiche LinkedList\n");
    	this.txtTempistiche.appendText("Durata Inserimento: "+Long.toString(this.elenco2.getDurataAdd())+" nanosecondi\n");
    	this.txtTempistiche.appendText("Durata Sort: "+Long.toString(this.elenco2.getDurataSort())+" nanosecondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.elenco.reset();
    	this.elenco2.reset();
    	this.txtResult.clear();
    	this.txtParola.clear();
    	
    	this.txtTempistiche.setText("Tempistiche ArrayList\n");
    	this.txtTempistiche.appendText("Durata Reset: "+Long.toString(this.elenco.getDurataReset())+" nanosecondi\n");
    
    	this.txtTempistiche.appendText("\nTempistiche LinkedList\n");
    	this.txtTempistiche.appendText("Durata Reset: "+Long.toString(this.elenco2.getDurataReset())+" nanosecondi\n");
    }
    

    @FXML
    void doCancella(ActionEvent event) {
    	this.elenco.cancella(this.txtResult.getSelectedText());
    	this.elenco2.cancella(this.txtResult.getSelectedText());
    	this.txtResult.clear();
    	for(String s : this.elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    	}
    	
    	this.txtTempistiche.setText("Tempistiche ArrayList\n");
    	this.txtTempistiche.appendText("Durata Remove: "+Long.toString(this.elenco.getDurataRemove())+" nanosecondi\n");
    	
    	this.txtTempistiche.appendText("\nTempistiche LinkedList\n");
    	this.txtTempistiche.appendText("Durata Remove: "+Long.toString(this.elenco2.getDurataRemove())+" nanosecondi\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempistiche != null : "fx:id=\"txtTempistiche\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new ParoleArrayList();
        elenco2 = new ParoleLinkedList();
    }
}
