package com.crud.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.DTO.ProductDTO;
import com.crud.DTO.ResponceProductDTO;
import com.crud.model.Product;
import com.crud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(ProductDTO productDto) {	
		Product product = new Product();
//		product.setProductId(productDto.getProductId());  //auto increment
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());		
		product.setQuantity(productDto.getQuantity());
		product.setDate(productDto.getDate());
		
		 return productRepository.save(product);
	}
	/*
	 *    date transfer Product ===> ProductDTO
	 */
	@Override
	public ResponceProductDTO showAllProduct() {
		ResponceProductDTO responceProductDTO = new ResponceProductDTO();
		List<ProductDTO> productDTOs= new ArrayList<ProductDTO>();	
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setDate(product.getDate());
			productDTO.setQuantity(product.getQuantity());
			
			productDTOs.add(productDTO); // add 
		}
		responceProductDTO.setProductDTOs(productDTOs);
		responceProductDTO.setTotalProducts(productRepository.count());
		return responceProductDTO;
	}

	@Override
	public ProductDTO showProduct(Integer productId) {
		ProductDTO productDTO = new ProductDTO();
		Product product =productRepository.findById(productId).orElse(null);
		if (product!=null) {
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setDate(product.getDate());
			productDTO.setQuantity(product.getQuantity());
		}
		return productDTO;
	}

}
