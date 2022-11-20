package SpringMVCDemo7.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import SpringMVCDemo7.pojos.Product;
import SpringMVCDemo7.repository.ProductRepository;
import SpringMVCDemo7.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Cloudinary cloudinary;
	@Override
	public List<Product> getProducts(String kw) {
		return productRepository.getproProducts(kw);
	}
	@Override
	public boolean addOrUpdate(Product product) {
			try {
				Map r =  cloudinary.uploader().upload(product.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
				String img = (String) r.get("secure_url");
				product.setImage(img);
				productRepository.addOrUpdate(product);
				return true;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return false;
	}
	@Override
	public Product getProductById(int id) {
		return this.productRepository.getProductById(id);
	}
}
