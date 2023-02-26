package vn.edu.iuh.fit.se.thubonggiareapis.service;

import java.util.List;

import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

public interface ProductService {

	public List<Product> getProducts();
	public void addProduct(Product product);
	public void deleteProduct(long id);
	public Product getProductById(long id);
}
