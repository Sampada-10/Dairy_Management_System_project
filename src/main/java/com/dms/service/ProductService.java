package com.dms.service;

import java.util.List;

import com.dms.model.ProductDTO;

public interface ProductService {
	ProductDTO addProduct(ProductDTO productDTO);
	ProductDTO getProductById(int id);
	List<ProductDTO> getAllProducts();
	ProductDTO updateProduct(ProductDTO productDTO,int id);
	String deleteById(int id);
}
