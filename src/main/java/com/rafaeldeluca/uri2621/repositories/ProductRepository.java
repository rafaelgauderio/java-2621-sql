package com.rafaeldeluca.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.uri2621.entities.Product;
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
}
