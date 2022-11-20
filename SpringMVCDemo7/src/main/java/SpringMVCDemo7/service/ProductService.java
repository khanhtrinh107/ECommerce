package SpringMVCDemo7.service;

import java.util.List;

import SpringMVCDemo7.pojos.Product;

public interface ProductService {
	List<Product> getProducts(String kw);
	boolean addOrUpdate(Product product);
	Product getProductById(int id);
}	

