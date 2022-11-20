package SpringMVCDemo7.repository;

import java.util.List;

import SpringMVCDemo7.pojos.Product;

public interface ProductRepository {
	List<Product> getproProducts(String kw); 
	boolean addOrUpdate(Product product);
	Product getProductById(int id);
}
