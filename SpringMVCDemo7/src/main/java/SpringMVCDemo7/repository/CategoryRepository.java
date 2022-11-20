package SpringMVCDemo7.repository;

import java.util.List;

import SpringMVCDemo7.pojos.Category;

public interface CategoryRepository {
	List<Category> getCategories();
}
