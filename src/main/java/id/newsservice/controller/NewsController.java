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

import id.newsservice.model.news.News;
import id.newsservice.response.MetaResponse;
import id.newsservice.response.CustomResponse;
import id.newsservice.service.NewsService;

@RestController
@RequestMapping("news")
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@GetMapping
	public ResponseEntity getAll() {
		return new CustomResponse().success(newsService.newsGetAll());
	}
	
	@GetMapping("category/{id}")
	public ResponseEntity newsByCategory(@PathVariable Long id) {
		if(null == newsService.newsByCategory(id)) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(newsService.newsByCategory(id));
	}
	
	@GetMapping("{id}")
	public ResponseEntity detail(@PathVariable Long id) {
		if(null == newsService.newsById(id)) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(newsService.newsById(id));
	}
	
	@PostMapping("post")
	public ResponseEntity post(@RequestBody News news) {
		return new CustomResponse().success(newsService.newsPost(news));
	}
	
	@PostMapping("edit/{id}")
	public ResponseEntity edit(@PathVariable Long id, @RequestBody News news) {
		if(null == newsService.newsById(id)) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(newsService.newsEdit(id, news));
	}

	@GetMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		String removeResult = newsService.newsDelete(id);
		if(null == newsService.newsById(id)) {
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(removeResult);
	}
}
