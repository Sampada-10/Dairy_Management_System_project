package com.dms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dms.model.ProductDTO;
import com.dms.service.ProductService;

import jakarta.validation.Valid;

@RestController
@Validated
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//It is use to send the data and that data save in database
	@PostMapping("/api/addProduct")
	ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO){
		
		return new ResponseEntity<ProductDTO>(productService.addProduct(productDTO),HttpStatus.CREATED);
	}
	
	//Use to get data
	@GetMapping("/api/getProductById/{id}")
	ProductDTO getProductByid(@Valid @PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	//Use to get data
	@GetMapping("/api/getAllProduct")
	List<ProductDTO> getAllProduct(){
		return productService.getAllProducts();
	}
	@PutMapping("/api/updateProduct/{id}")
	ProductDTO updateProduct(@Valid @RequestBody ProductDTO productDTO,@PathVariable() int id) {
		
		return productService.updateProduct(productDTO, id);
	}
	
	//Use to delete record
	@DeleteMapping("/api/deleteById/{id}")
	String deleteById(@Valid @PathVariable("id") int id) {
		return productService.deleteById(id);
	}
}