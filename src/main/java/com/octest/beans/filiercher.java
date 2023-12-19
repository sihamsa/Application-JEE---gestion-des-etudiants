package com.octest.beans;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.filiere;

public class filiercher {
	private String nameUser2;
	List<filiere> filiere = new ArrayList<filiere>();

	public String getNameUser2() {
		return nameUser2;
	}
	public void setNameUser2(String nameUser2) {
		this.nameUser2 = nameUser2;
	}
	public List<filiere> getFiliere() {
		return filiere;
	}
	public void setFiliere(List<filiere> filiere) {
		this.filiere = filiere;
	}
}
