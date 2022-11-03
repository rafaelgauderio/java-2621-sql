package com.rafaeldeluca.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.uri2621.dto.ProductNamePriceProjectionDTO;
import com.rafaeldeluca.uri2621.entities.Product;
import com.rafaeldeluca.uri2621.projections.ProductNamePriceProjection;
import com.rafaeldeluca.uri2621.projections.ProductNameProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value ="SELECT products.name "
			+ "FROM products "
			+ "INNER JOIN providers "
			+ "ON products.id_providers = providers.id "
			+ "WHERE products.amount BETWEEN :min AND :max "
			+ "AND providers.name LIKE CONCAT(:beginName, '%')") //tem a letra com a letra beginName no começo
				// AND providers.name LIKE CONTACT('%', :beginName, '%'") // teria a letra antes e depois
	List<ProductNameProjection> listName(Integer min, Integer max, String beginName);
	
	@Query(nativeQuery = true, value ="SELECT products.name, products.price "
			+ "FROM products "
			+ "INNER JOIN providers "
			+ "ON products.id_providers = providers.id "
			+ "WHERE products.price BETWEEN :min AND :max "
			+ "AND providers.name LIKE CONCAT('%',:hasName, '%')") //tem a palavra em algum lugar				
	List<ProductNamePriceProjection> listNamePrice(double min, double max, String hasName);
	
	
	@Query("SELECT new com.rafaeldeluca.uri2621.dto.ProductNamePriceProjectionDTO (obj.name, obj.price) "
			+ "FROM Product obj "	//object é palavra reservada no SQL		
			+ "WHERE obj.amount BETWEEN :min AND :max "
			+ "AND obj.provider.name LIKE CONCAT('%',:hasName, '%')") //tem a palavra em algum lugar				
	List<ProductNamePriceProjectionDTO> listJPQL(Integer min, Integer max, String hasName);
}
