package id.newsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.newsservice.model.news.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}
