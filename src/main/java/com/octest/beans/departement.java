package com.octest.beans;

public class departement {
	private int id;
	private String nom;
	private int nfilier;
	private int netudiant;
	
	public departement(String nom, int nfilier, int netudiant) {
		super();
		this.nom = nom;
		this.nfilier = nfilier;
		this.netudiant = netudiant;
	}
	public departement(String nom) {
		super();
		this.nom = nom;
		
	}
	
	public departement(int netudiant) {
		super();
		this.netudiant = netudiant;
		
	}
	
	public departement(int id,int netudiant ) {
		super();
		this.id = id;
		this.netudiant=netudiant;
		
	}
	
	public departement(int id,String nom) {
		super();
		this.id=id;
		this.nom = nom;
		
	}

	public departement(int id, String nom, int nfilier, int netudiant) {
		super();
		this.id = id;
		this.nom = nom;
		this.nfilier = nfilier;
		this.netudiant = netudiant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNfilier() {
		return nfilier;
	}
	public void setNfilier(int nfilier) {
		this.nfilier = nfilier;
	}
	public int getNetudiant() {
		return netudiant;
	}
	public void setNetudiant(int netudiant) {
		this.netudiant = netudiant;
	}


	

}
