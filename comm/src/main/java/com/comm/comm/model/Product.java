package com.comm.comm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"prixAchat","id"})
@Entity
@Table(name = "Product")
public class Product {
	@Id
    @GeneratedValue
	 private int id;
	@Length(min =3 , max = 20, message = "ici")
	    private String nom;
	    private int prix;
	    @ManyToOne
	    @JoinColumn
	    private Categorie Categorie;
	    
		
		//a ne pas affiché
	    //@JsonIgnore
		private int prixAchat;


		public Categorie getCategorie() {
			return Categorie;
		}


		public void setCategorie(Categorie categorie) {
			Categorie = categorie;
		}





		public Product(int id, String nom, int prix, com.comm.comm.model.Categorie categorie, int prixAchat) {
			super();
			this.id = id;
			this.nom = nom;
			this.prix = prix;
			Categorie = categorie;
			this.prixAchat = prixAchat;
		}


		public Product() {
			super();
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


		public int getPrix() {
			return prix;
		}


		public void setPrix(int prix) {
			this.prix = prix;
		}


		public int getPrixAchat() {
			return prixAchat;
		}


		public void setPrixAchat(int prixAchat) {
			this.prixAchat = prixAchat;
		}


		@Override
		public String toString() {
			return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + ", Categorie=" + Categorie + ", prixAchat="
					+ prixAchat + "]";
		}



		
}
