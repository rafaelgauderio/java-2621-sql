package com.rafaeldeluca.uri2621.dto;

import com.rafaeldeluca.uri2621.projections.ProductNamePriceProjection;

public class ProductNamePriceProviderDTO {
	
	private String name;
	private Double price;
	private String providerName;
	
	
	public ProductNamePriceProviderDTO () {
		
	}	
	
	public ProductNamePriceProviderDTO(String name, Double price, String providerName) {
		super();
		this.name = name;
		this.price = price;
		this.providerName= providerName;
	}
	
	public ProductNamePriceProviderDTO(ProductNamePriceProjection projection) {
		
		name = projection.getName();
		price = projection.getPrice();
		providerName = projection.getProvider();
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
	

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String toString() {
		return "Product Data [name= " + name + ", price= " + String.format("%.2f", price) + ", Provider(Fornecedor) = " + providerName + "]";
	}

	
	
	

}
