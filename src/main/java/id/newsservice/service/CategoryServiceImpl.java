package id.newsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.newsservice.model.category.Category;
import id.newsservice.repository.CategoryReposiroty;

@Service
public class CategoryServiceImpl implements  CategoryService{
	@Autowired
	CategoryReposiroty categoryRepo;

	@Override
	public List<Category> categoryShow() {
		return categoryRepo.findAll();
	}

	@Override
	public Category categoryAdd(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category categoryEdit(Long id, Category category) {
		if(categoryRepo.findById(id).isPresent()) {
			Category newCategory = categoryRepo.findById(id).get();
			
			newCategory.setName(category.getName());
			newCategory.setDescription(category.getDescription());
			categoryRepo.save(newCategory);
			
			return newCategory;
		}
		return null;
	}
	
	@Override
	public Category categoryDetail(Long id) {
		if(categoryRepo.findById(id).isPresent()) {
			return categoryRepo.findById(id).get();
		}
		return null;
	}

	@Override
	public String categoryRemove(Long id) {
		if(categoryRepo.findById(id).isPresent()) {
			categoryRepo.deleteById(id);
			return "Data has been deleted";
		}
		return null;
	}

}
