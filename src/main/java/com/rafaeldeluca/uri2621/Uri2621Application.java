package com.rafaeldeluca.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaeldeluca.uri2621.dto.ProductDTO;
import com.rafaeldeluca.uri2621.dto.ProductNamePriceProjectionDTO;
import com.rafaeldeluca.uri2621.dto.ProductNamePriceProviderDTO;
import com.rafaeldeluca.uri2621.projections.ProductNamePriceProjection;
import com.rafaeldeluca.uri2621.projections.ProductNameProjection;
import com.rafaeldeluca.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<ProductNameProjection> listName = repository.listName(10,20,"P");
		List<ProductDTO> resultListName = listName.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		
		List<ProductNamePriceProjection> listNamePrice = repository.listNamePrice(500.0, 3100.0,"Elon" );
		List<ProductNamePriceProjectionDTO> result2 = listNamePrice.stream().map(x -> new ProductNamePriceProjectionDTO(x)).collect(Collectors.toList());
		
		System.out.println("CONSULTAS COM SQL RAIZ");
		for(ProductDTO object : resultListName) {
			System.out.println(object);
						
		}
		
		System.out.println("\nConsultando nome e preço");
		for (ProductNamePriceProjectionDTO nickname : result2) {
			System.out.println(nickname);
		}		
		
		System.out.println("\nCONSULTAS COM JPQL\n");
		
		List<ProductNamePriceProjectionDTO> result3 = repository.listJPQL(10,500,"Elon");
		for(ProductNamePriceProjectionDTO object : result3) {
			System.out.println(object);
						
		}
		
		System.out.println("\n\nImprimindo o Fornecedor");
		List<ProductNamePriceProviderDTO> result4 = repository.listJPQLProvider(1,500,"Mike");
		for(ProductNamePriceProviderDTO object : result4) {
			System.out.println(object);
						
		}
		
	}
}
