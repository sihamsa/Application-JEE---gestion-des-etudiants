package com.octest.beans;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.etudiant;

public class etudiantcher {
	private String nameUser3;
	List<etudiant> etudiant = new ArrayList<etudiant>();
	public String getNameUser3() {
		return nameUser3;
	}
	public void setNameUser3(String nameUser3) {
		this.nameUser3 = nameUser3;
	}
	public List<etudiant> getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(List<etudiant> etudiant) {
		this.etudiant = etudiant;
	}
}
