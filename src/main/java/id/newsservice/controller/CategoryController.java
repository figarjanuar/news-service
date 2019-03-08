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
import id.newsservice.repository.CategoryReposiroty;
import id.newsservice.response.MetaResponse;
import id.newsservice.response.Response;
import id.newsservice.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity show() {
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
		Response res = new Response("OK", categoryService.categoryShow(), meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity add(@RequestBody Category category) {
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
		Response res = new Response("OK", categoryService.categoryAdd(category), meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detail(@PathVariable("id") Long id) {
		if(null == categoryService.categoryDetail(id)) {
			MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), "Data doesn't exist", "");
			Response res = new Response("ERROR", null, meta);
			
			return new ResponseEntity(res, HttpStatus.NOT_FOUND);
		}else {
			MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
			Response res = new Response("OK", categoryService.categoryDetail(id), meta);
			
			return new ResponseEntity(res, HttpStatus.OK);
		}
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody Category category) {
		if(null == categoryService.categoryEdit(id, category)) {
			MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), "Data doesn't exist", "");
			Response res = new Response("ERROR", null, meta);
			
			return new ResponseEntity(res, HttpStatus.NOT_FOUND);
		}else {
			MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
			Response res = new Response("OK", categoryService.categoryEdit(id, category), meta);
			
			return new ResponseEntity(res, HttpStatus.OK);
		}
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		String removeResult = categoryService.categoryRemove(id);
		if(null == removeResult) {
			MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), "Data doesn't exist", "");
			Response res = new Response("ERROR", null, meta);
			
			return new ResponseEntity(res, HttpStatus.NOT_FOUND);
		}else {
			MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), removeResult, "");
			Response res = new Response("OK", null, meta);
			
			return new ResponseEntity(res, HttpStatus.OK);
		}
	}

}
