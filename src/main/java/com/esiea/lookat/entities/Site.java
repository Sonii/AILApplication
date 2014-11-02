package com.esiea.lookat.entities;

import java.io.Serializable;
import java.util.*;


public class Site implements Serializable, Comparable<Site> {

	private Integer id;
	private String url;
	private Integer idCat;
	private String description;
	private String nom;
	private Integer nbClick;
	private List<Commentaire> listComms;
	private Integer idUser;
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Site(Integer id, String url, Integer idCat, String description, String nom, Integer nbClick, Integer idUser) {
		super();
		this.id = id;
		this.url = url;
		this.idCat = idCat;
		this.description = description;
		this.nom = nom;
		this.nbClick = nbClick;
		this.setIdUser(idUser);
	}

	public Site(String url, Integer idCat, String description, String nom,
			Integer idUser) {
		super();
		this.url = url;
		this.idCat = idCat;
		this.description = description;
		this.nom = nom;
		this.idUser = idUser;
	}

	public List getListComms() {
		return listComms;
	}
	public void setListComms(List listComms) {
		this.listComms = listComms;
	}
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", url=" + url + ", idCat=" + idCat
				+ ", description=" + description + ", nom=" + nom
				+ ", nbClick=" + nbClick + ", listComms=" + listComms
				+ ", idUser=" + idUser + "]";
	}



	@Override
	public int compareTo(Site arg0) {
		return arg0.getNbClick().compareTo(this.getNbClick());
	}
	
}
