package com.example.demo.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.example.demo.entities.Produit;

@RepositoryRestResource
public interface ProduitRepository  extends JpaRepository<Produit, Long>{
	@RestResource(path = "/byDesination")
	public List<Produit> findByDesignationContains(@Param("mc") String des);
	@RestResource(path = "/byDesinationPage")
	public Page<Produit> findByDesignationContains(@Param("mc") String des, Pageable pageable );

}
