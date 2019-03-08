package id.newsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.newsservice.model.category.Category;

public interface CategoryReposiroty extends JpaRepository<Category, Long>{

}
