package com.octest.beans;

public class etudiant {
	private int id;
	private String cne;
	private String nom;
	private String prenom;
	private String telephone;
	private int idfilier;
	private int iddepar;
	
	public etudiant(String cne,String nom, String prenom, String telephone, int idfilier, int iddepar) {
		super();
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.idfilier = idfilier;
		this.iddepar = iddepar;
	}
	public etudiant(int id,String cne,String nom, String prenom, String telephone, int idfilier, int iddepar) {
		super();
		this.id = id ;
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.idfilier = idfilier;
		this.iddepar = iddepar;
	}
	public etudiant(int id,String cne,String nom, String prenom, String telephone) {
		super();
		this.id = id ;
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getIdfilier() {
		return idfilier;
	}
	public void setIdfilier(int idfilier) {
		this.idfilier = idfilier;
	}
	public int getIddepar() {
		return iddepar;
	}
	public void setIddepar(int iddepar) {
		this.iddepar = iddepar;
	}


	
}
