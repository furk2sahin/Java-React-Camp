package hw3.business.abstracts;

import java.util.List;

import hw3.model.concretes.Category;

public interface CategoryService {
	void add(Category category);
	void delete(int id);
	void update(Category category);
	Category getCategoryById(int id);
	List<Category> getCategories();
}
