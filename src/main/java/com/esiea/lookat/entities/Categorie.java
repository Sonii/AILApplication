package com.esiea.lookat.entities;

import java.io.Serializable;

public class Categorie implements Serializable{

	private Integer id;
	private String nom;
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
	}
	

	
}
