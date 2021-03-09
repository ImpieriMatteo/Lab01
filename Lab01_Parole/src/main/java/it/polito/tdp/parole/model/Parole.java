package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
		
	private List<String> elencoParole;
	
	public Parole() {
		elencoParole = new ArrayList<>();
	}
	
	public void addParola(String p) {
		this.elencoParole.add(p);
		Collections.sort(this.elencoParole);
	}
	
	public List<String> getElenco() {
		return this.elencoParole;
	}
	
	public void reset() {
		this.elencoParole.clear();
	}

}
