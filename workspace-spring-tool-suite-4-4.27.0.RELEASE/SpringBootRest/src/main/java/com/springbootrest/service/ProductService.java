package com.springbootrest.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.entity.Product;
import com.springbootrest.repository.ProductRepository;

@Service
public class ProductService {
	 private ProductRepository repository;
	 
	 @Autowired
	 public ProductService(ProductRepository repository)
	 {
		 this.repository = repository;
	 }
//	 i want to add a new product in to a table
	 public Product addProduct(Product p1)
	 {
		 return repository.save(p1);
	 }
	 
	 public void readAllProduct()
	 {
		 
	 }
	public List<Product> viewProduct() {
		return repository.findAll();
	}
	public Optional<Product> getproductById(int id) {
		Optional<Product> p1=repository.findById(id);
		if(p1.isPresent()) {
			return p1;
		}
		else
		{
			return null;
		}
	}
	public List<Product> getProductByPrice(int price) {
		return repository.getProductByPrice(price);
		
	}
	public String deleteProductById(int id) {
		
		Optional<Product> p1 = repository.findById(id);
		if(p1.isPresent()) {
		 repository.deleteById(id);;
		  return "delete id "+ id +" successfully";
	
		}
		else {
			return id+"is not exit";
		}
	 }
	public Product updateProduct(int id, Product newProduct) {
//		check product id is available
//		if available get the product from db
//		modify the data using setter
		Optional<Product> p1=repository.findById(id);
		if(p1.isPresent()) {
			Product productFromDB = p1.get();
			productFromDB.setPname(newProduct.getPname());
			productFromDB.setPrice(newProduct.getPrice());
			productFromDB.setQty(newProduct.getQty());
			return repository.save(productFromDB);
			
		}
		else {
			throw new RuntimeException("Invalid product id");
		}
	}
	
}
