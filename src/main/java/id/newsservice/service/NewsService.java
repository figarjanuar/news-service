package id.newsservice.service;

import java.util.List;

import id.newsservice.model.news.News;
import id.newsservice.model.news.NewsShow;

public interface NewsService {
	
	List<NewsShow> newsGetAll();
	List<NewsShow> newsByCategory(Long categoryId);
	NewsShow newsById(Long id);
	NewsShow newsPost(News news);
	NewsShow newsEdit(Long id, News news);
	String newsDelete(Long id);

}
