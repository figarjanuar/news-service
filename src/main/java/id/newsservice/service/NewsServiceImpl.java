package id.newsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.newsservice.model.news.News;
import id.newsservice.model.news.NewsShow;
import id.newsservice.repository.CategoryReposiroty;
import id.newsservice.repository.NewsRepository;
import id.newsservice.repository.NewsShowRepository;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Yielding;

@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	NewsShowRepository nsRepo;
	
	@Autowired
	NewsRepository nRepo;
	
	@Autowired
	CategoryReposiroty cRepo;

	@Override
	public List<NewsShow> newsGetAll() {
		return nsRepo.showAll();
	}

	@Override
	public List<NewsShow> newsByCategory(Long categoryId) {
		if(cRepo.findById(categoryId).isPresent()) {
			return nsRepo.showByCategory(categoryId);
		}
		return null;
	}

	@Override
	public NewsShow newsById(Long id) {
		if(nRepo.findById(id).isPresent()) {
			return nsRepo.showDetail(id);
		}
		return null;
	}

	@Override
	public NewsShow newsPost(News news) {
		News addNews = nRepo.save(news);
		return nsRepo.showDetail(addNews.getId());
	}

	@Override
	public NewsShow newsEdit(Long id, News news) {
		if(nRepo.findById(id).isPresent()) {
			News updatedNews = nRepo.findById(id).get();
			updatedNews.setUserId(news.getUserId());
			updatedNews.setCategoryId(news.getCategoryId());
			updatedNews.setTitle(news.getTitle());
			updatedNews.setDescription(news.getDescription());
			nRepo.save(updatedNews);
			
			return nsRepo.showDetail(id);
		}
		return null;
	}

	@Override
	public String newsDelete(Long id) {
		if(nRepo.findById(id).isPresent()) {
			nRepo.deleteById(id);
			return "Data has been deleted";
		}
		return null;
	}

}
