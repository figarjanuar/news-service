package id.newsservice.service;

import java.util.List;

import id.newsservice.model.category.Category;

public interface CategoryService {
	
	List<Category> categoryShow();
	Category categoryAdd(Category category);
	Category categoryDetail(Long id);
	Category categoryEdit(Long id, Category category);
	String categoryRemove(Long id);

}
