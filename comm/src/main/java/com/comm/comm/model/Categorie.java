package com.comm.comm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
public class Categorie {
	@Id
    @GeneratedValue
	 private int id;
	 private String nom;
	 @OneToMany(mappedBy = "Categorie", cascade = CascadeType.ALL)
	    private List<Product> produits;
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
	public List<Product> getProduits() {
		return produits;
	}
	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
	}
	public Categorie(int id, String nom, List<Product> produits) {
		super();
		this.id = id;
		this.nom = nom;
		this.produits = produits;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
