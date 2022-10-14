package de.dhbw.javaproject.notizverwaltung.model;

public class Notiz {
	int id;
	String inhalt;
	
	public Notiz() {}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public String getInhalt() {
		return inhalt;
	}
}
