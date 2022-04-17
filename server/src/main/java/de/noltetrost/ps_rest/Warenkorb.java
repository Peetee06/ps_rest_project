package de.noltetrost.ps_rest;


public class Warenkorb {
	private int warenkorbID;
	private int artikelID;
	private int artikelanzahl;
	
	public Warenkorb(int warenkorbID, int artikelID, int artikelanzahl) {
		this.warenkorbID = warenkorbID;
		this.artikelID = artikelID;
		this.artikelanzahl = artikelanzahl;
	}
	public int getWarenkorbID() {
		return warenkorbID;
	}
	public void setWarenkorbID(int warenkorbID) {
		this.warenkorbID = warenkorbID;
	}
	public int getArtikelID() {
		return artikelID;
	}
	public void setArtikelID(int artikelID) {
		this.artikelID = artikelID;
	}
	public int getArtikelanzahl() {
		return artikelanzahl;
	}
	public void setArtikelanzahl(int artikelanzahl) {
		this.artikelanzahl = artikelanzahl;
	}

}
