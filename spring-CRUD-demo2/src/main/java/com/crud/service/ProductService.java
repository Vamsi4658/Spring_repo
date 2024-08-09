package com.crud.service;

import java.util.List;

import com.crud.DTO.ProductDTO;
import com.crud.DTO.ResponceProductDTO;
import com.crud.model.Product;

public interface ProductService {

	Product createProduct(ProductDTO productDTO);

	ResponceProductDTO showAllProduct();

	ProductDTO showProduct(Integer productId);

}
