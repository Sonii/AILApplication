package com.esiea.lookat.entities;

import java.io.Serializable;

public class Commentaire implements Serializable{
	
	private Integer id;
	private Integer etoile;
	private Integer idSite;
	private String contenu;
	private Integer idUser;
	
	public Commentaire() {
		super();
	}
	public Commentaire(Integer id, Integer etoile, Integer idSite,String contenu, Integer idUser) {
		super();
		this.id = id;
		this.etoile = etoile;
		this.idSite = idSite;
		this.contenu = contenu;
		this.idUser = idUser;
	}
	public Integer getId() {
		return id;
	}
	public Integer getEtoile() {
		return etoile;
	}
	public void setEtoile(Integer etoile) {
		this.etoile = etoile;
	}
	public Integer getIdSite() {
		return idSite;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", etoile=" + etoile + ", idSite="
				+ idSite + ", contenu=" + contenu + ", idUser=" + idUser + "]";
	}

}
