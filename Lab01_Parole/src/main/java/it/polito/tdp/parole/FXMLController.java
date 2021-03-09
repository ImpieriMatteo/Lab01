package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
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
    	this.txtTempistiche.clear();
    	this.txtResult.clear();
    	for(String s : this.elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    	}
    	this.txtParola.clear();
    	this.txtTempistiche.setText("Durata Inserimento: "+Long.toString(this.elenco.getDurataAdd())+" nanosecondi\n");
    	this.txtTempistiche.appendText("Durata Sort: "+Long.toString(this.elenco.getDurataSort())+" nanosecondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.elenco.reset();
    	this.txtResult.clear();
    	this.txtParola.clear();
    	this.txtTempistiche.setText("Durata Reset: "+Long.toString(this.elenco.getDurataReset())+" nanosecondi");
    }
    

    @FXML
    void doCancella(ActionEvent event) {
    	this.elenco.cancella(this.txtResult.getSelectedText());
    	this.txtResult.clear();
    	for(String s : this.elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    	}
    	this.txtTempistiche.setText("Durata Remove: "+Long.toString(this.elenco.getDurataRemove())+" nanosecondi");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempistiche != null : "fx:id=\"txtTempistiche\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
