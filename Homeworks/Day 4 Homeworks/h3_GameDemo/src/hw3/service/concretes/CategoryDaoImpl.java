package hw3.service.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hw3.model.concretes.Category;
import hw3.service.abstracts.CategoryDao;

public class CategoryDaoImpl implements CategoryDao{
	
	private static List<Category> categories = new ArrayList<Category>();

	@Override
	public void add(Category category) {
		categories.add(category);	
	}

	@Override
	public void delete(int id) {
		for(Iterator<Category> iterator = categories.listIterator(); iterator.hasNext();){
			if(iterator.next().getId() == id) {
				iterator.remove();
				System.out.print("Category successfully deleted with id: " + id);
			}
		}
	}

	@Override
	public void update(Category category) {
		int indexOfCategory = category.getId();
		Category categoryToUpdate = categories.get(indexOfCategory);
		if(!category.getCategoryName().equals(category.getCategoryName())) {
			System.out.println("Category name successfull changed.");
			categoryToUpdate.setCategoryName(category.getCategoryName());
		}
	}

	@Override
	public Category getCategoryById(int id) {
		for(Iterator<Category> iterator = categories.listIterator(); iterator.hasNext();) {
			Category category = iterator.next();
			if(category.getId() == id) {
				return category;
			}
		}
		System.out.println("Cannot find category with id: " + id);
		return null;
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}

}
