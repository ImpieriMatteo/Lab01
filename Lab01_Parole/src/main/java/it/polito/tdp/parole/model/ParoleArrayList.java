package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParoleArrayList {
		
	private List<String> elencoParole;
	private long durataAdd;
	private long durataSort;
	private long durataReset;
	private long durataRemove;
	
	public ParoleArrayList() {
		this.elencoParole = new ArrayList<>();
		this.durataAdd = 0;
		this.durataSort = 0;
		this.durataReset = 0;
		this.durataRemove = 0;
	}
	
	/**
	 * Aggiunge una parola all'elenco di parole in memoria
	 * e mette in ordine alfabetico l'intero elenco
	 * @param p
	 */
	public void addParola(String p) {
		long inizioAdd = System.nanoTime();
		this.elencoParole.add(p);
		long fineAdd = System.nanoTime();
		
		this.durataAdd = fineAdd-inizioAdd;
		
		long inizioSort = System.nanoTime();
		Collections.sort(this.elencoParole);
		long fineSort = System.nanoTime();
		
		this.durataSort = fineSort-inizioSort;
	}
	
	/**
	 * Restituisce l'elenco di parole
	 * @return
	 */
	public List<String> getElenco() {
		return this.elencoParole;
	}
	
	/**
	 * Resetta la struttura dati eliminando le parole salvate
	 */
	public void reset() {
		long inizioReset = System.nanoTime();
		this.elencoParole.clear();
		long fineReset = System.nanoTime();
		
		this.durataReset = fineReset-inizioReset;
	}
	
	/**
	 * Elimina dalla struttura dati la parola selezionata nell'area di testo
	 * (se non viene selezionata completamente una parola non sortisce alcun effetto)
	 * @param s Parola selezionata nell'area di testo
	 */
	public void cancella(String s) {
		long inizioRemove = System.nanoTime();
		this.elencoParole.remove(s);
		long fineRemove = System.nanoTime();

		this.durataRemove = fineRemove-inizioRemove;
	}

	public long getDurataAdd() {
		return durataAdd;
	}

	public long getDurataSort() {
		return durataSort;
	}

	public long getDurataReset() {
		return durataReset;
	}

	public long getDurataRemove() {
		return durataRemove;
	}

}
