package com.octest.beans;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.departement;

public class departementcher {
	private String nameUser;
	List<departement> departement = new ArrayList<departement>();

	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public List<departement> getDepartement() {
		return departement;
	}
	public void setDepartement(List<departement> departement) {
		this.departement = departement;
	}
	
}
