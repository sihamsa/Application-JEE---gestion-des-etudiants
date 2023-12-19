package com.octest.beans;

public class filiere {
		private int id;
		private String nom;
		private String nomprof;
		private int netudiant;
		private int iddepar;
		
		public filiere(String nom, String nomprof, int netudiant, int iddepar) {
			super();
			this.nom = nom;
			this.nomprof = nomprof;
			this.netudiant = netudiant;
			this.iddepar = iddepar;
		}
		public filiere(int id) {
			super();
			this.id = id;
			
		}
		public filiere(String nom) {
			super();
			this.nom = nom;
			
		}
		public filiere(String nom,String nomprof, int iddepar) {
			super();
			this.nom = nom;
			this.nomprof=nomprof;
			this.iddepar=iddepar;
			
		}
		public filiere(int id,String nom,String nomprof, int iddepar) {
			super();
			this.id=id;
			this.nom = nom;
			this.nomprof=nomprof;
			this.iddepar=iddepar;
			
		}


		public filiere(int id, String nom, String nomprof, int netudiant, int iddepar) {
			super();
			this.id = id;
			this.nom = nom;
			this.nomprof = nomprof;
			this.netudiant = netudiant;
			this.iddepar = iddepar;

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
		public String getNomprof() {
			return nomprof;
		}
		public void setNomprof(String nomprof) {
			this.nomprof = nomprof;
		}
		public int getNetudiant() {
			return netudiant;
		}
		public void setNetudiant(int netudiant) {
			this.netudiant = netudiant;
		}
		public int getIddepar() {
			return iddepar;
		}
		public void setIddepar(int iddepar) {
			this.iddepar = iddepar;
		}
		public int getIdadmin() {
			return idadmin;
		}
		public void setIdadmin(int idadmin) {
			this.idadmin = idadmin;
		}
		private int idadmin;

		
	}


