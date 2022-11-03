package com.rafaeldeluca.uri2621.dto;

import com.rafaeldeluca.uri2621.projections.ProductNameProjection;

public class ProductDTO {
	
	private String name;
	
	public ProductDTO () {
		
	}

	public ProductDTO(String name) {
		
		this.name = name;
	}
	
	public ProductDTO(ProductNameProjection projection) {
		name = projection.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [Nome do produto = " + name + "]";
	}
	
	
	
	
}
