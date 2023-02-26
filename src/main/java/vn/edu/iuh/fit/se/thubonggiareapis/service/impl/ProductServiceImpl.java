package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.ProductRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);

	}

	@Override
	public Product getProductById(long id) {

		return productRepository.findById(id).get();
	}

}
