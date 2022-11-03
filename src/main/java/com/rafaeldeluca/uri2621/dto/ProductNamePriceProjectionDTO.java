package com.rafaeldeluca.uri2621.dto;

import com.rafaeldeluca.uri2621.projections.ProductNamePriceProjection;

public class ProductNamePriceProjectionDTO {
	
	private String name;
	private Double price;
	
	public ProductNamePriceProjectionDTO () {
		
	}	
	
	public ProductNamePriceProjectionDTO(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public ProductNamePriceProjectionDTO(ProductNamePriceProjection projection) {
		
		name = projection.getName();
		price = projection.getPrice();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product Data [name= " + name + ", price= " + String.format("%.2f", price) + "]";
	}

	
	
	

}
