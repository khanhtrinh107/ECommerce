package SpringMVCDemo7.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVCDemo7.pojos.Category;
import SpringMVCDemo7.repository.CategoryRepository;
import SpringMVCDemo7.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getCategories() {
		return categoryRepository.getCategories();
	}
	
}
