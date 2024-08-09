package com.crud.DTO;

import java.util.List;

public class ResponceProductDTO {

	private List<ProductDTO> productDTOs;
	private long totalProducts;
	
	
	public List<ProductDTO> getProductDTOs() {
		return productDTOs;
	}
	public void setProductDTOs(List<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}
	public long getTotalProducts() {
		return totalProducts;
	}
	public void setTotalProducts(long totalProducts) {
		this.totalProducts = totalProducts;
	}
	
	
}
