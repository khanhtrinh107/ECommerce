package SpringMVCDemo7.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVCDemo7.pojos.Comment;
import SpringMVCDemo7.pojos.Product;
import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.repository.CommentRepository;
import SpringMVCDemo7.repository.ProductRepository;
import SpringMVCDemo7.repository.UserRepository;
import SpringMVCDemo7.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Override
	public Comment addComment(String content, int productId) {
		Product p = productRepository.getProductById(productId);
		User u = userRepository.getUserById(1);
		Comment c = new Comment();
		c.setContent(content);
		c.setProduct(p);
		c.setUser(u);
		c.setCreatedDate(new Date());
		return commentRepository.addComment(c);
	}

}
