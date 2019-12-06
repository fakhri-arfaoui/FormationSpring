package com.comm.comm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.comm.comm.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
	Product findById(int id);
	List<Product> findByPrixGreaterThan(int prixLimit);
	@Query("SELECT p FROM Product p WHERE p.prix > :prixLimit")
	List<Product> chercherUnProduitCher(@Param("prixLimit")int prix);
	@Query("select p.nom from Product p inner join p.Categorie ca where ca.id = p.id AND ca.nom=:name ")
	List<String> cherch(@Param("name")String name);
}
