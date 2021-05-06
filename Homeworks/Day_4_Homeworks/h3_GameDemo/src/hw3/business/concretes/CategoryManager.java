package hw3.business.concretes;

import java.util.List;

import hw3.business.abstracts.CategoryService;
import hw3.model.concretes.Category;
import hw3.service.abstracts.CategoryDao;
import hw3.service.abstracts.GameDao;

public class CategoryManager implements CategoryService {
	
	private CategoryDao categoryDao;
	private GameDao gameDao;
	
	public CategoryManager(CategoryDao categoryDao, GameDao gameDao) {
		this.categoryDao = categoryDao;
		this.gameDao = gameDao;
	}

	@Override
	public void add(Category category) {
		if(category.getId() <= 0) {
			System.out.println("Unsuccessfull! ID must be bigger than 0.");
			return;
		}
		if(category.getCategoryName().length() < 3 && category.getCategoryName().length() > 24) {
			System.out.println("Unsuccessful! Game name length must be between 3-24.");
			return;
		}	
		categoryDao.add(category);
	}

	@Override
	public void delete(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return;
		}
		categoryDao.delete(id);
		gameDao.deleteGamesByCategoryId(id);
	}

	@Override
	public void update(Category category) {
		if(category.getId() <= 0) {
			System.out.println("Unsuccessfull! ID must be bigger than 0.");
			return;
		}
		if(category.getCategoryName().length() < 3 && category.getCategoryName().length() > 24) {
			System.out.println("Unsuccessful! Game name length must be between 3-24.");
			return;
		}	
		categoryDao.update(category);
	}

	@Override
	public Category getCategoryById(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return null;
		}
		return categoryDao.getCategoryById(id);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

}
