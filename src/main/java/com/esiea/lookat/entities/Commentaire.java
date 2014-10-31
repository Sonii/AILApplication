package com.esiea.lookat.entities;

import java.io.Serializable;

public class Commentaire implements Serializable{
	
	private Integer id;
	private String etoile;
	private Integer idSite;
	private String contenu;
	private Utilisateur utilisateur;
	
	public Commentaire() {
		super();
	}
	public Commentaire(Integer id, String etoile, Integer idSite,String contenu, Utilisateur util) {
		super();
		this.id = id;
		this.etoile = etoile;
		this.idSite = idSite;
		this.contenu = contenu;
		this.utilisateur = util;
	}
	public Integer getId() {
		return id;
	}
	public String getEtoile() {
		return etoile;
	}
	public void setEtoile(String etoile) {
		this.etoile = etoile;
	}
	public Integer getIdSite() {
		return idSite;
	}
	public void setIdSite(Integer idSite) {
		this.idSite = idSite;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", etoile=" + etoile + ", idSite="
				+ idSite + ", contenu=" + contenu + ", pseudo=" + "]";
	}

}
