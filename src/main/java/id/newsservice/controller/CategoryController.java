package id.newsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.newsservice.model.category.Category;
import id.newsservice.response.MetaResponse;
import id.newsservice.response.CustomResponse;
import id.newsservice.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity show() {
		return new CustomResponse().success(categoryService.categoryShow());
	}
	
	@PostMapping("add")
	public ResponseEntity add(@RequestBody Category category) {
		return new CustomResponse().success(categoryService.categoryAdd(category));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detail(@PathVariable("id") Long id) {
		if(null == categoryService.categoryDetail(id)) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(categoryService.categoryDetail(id));
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody Category category) {
		if(null == categoryService.categoryEdit(id, category)) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(categoryService.categoryEdit(id, category));
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		String removeResult = categoryService.categoryRemove(id);
		if(null == removeResult) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(removeResult);
	}

}
