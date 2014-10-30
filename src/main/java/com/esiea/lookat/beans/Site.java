package com.esiea.lookat.beans;

public class Site {

	private Integer id;
	private String url;
	private Integer idCat;
	private String description;
	private String nom;
	private Integer nbClick;
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIdCat() {
		return idCat;
	}
	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNbClick() {
		return nbClick;
	}
	public void setNbClick(Integer nbClick) {
		this.nbClick = nbClick;
	}
	@Override
	public String toString() {
		return "Site [id=" + id + ", url=" + url + ", idCat=" + idCat
				+ ", description=" + description + ", nom=" + nom
				+ ", nbClick=" + nbClick + "]";
	}
}
