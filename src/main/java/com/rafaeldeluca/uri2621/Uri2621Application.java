package com.rafaeldeluca.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaeldeluca.uri2621.dto.ProductDTO;
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
		
		System.out.println("CONSULTAS COM SQL RAIZ");
		for(ProductDTO object : resultListName) {
			System.out.println(object);
		}
		
	}
}
