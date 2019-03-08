package id.newsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.newsservice.model.news.NewsShow;

public interface NewsShowRepository extends JpaRepository<NewsShow, Long>{
	
	@Query(value="select n_id id, u_name user, c_name category, n_title title, n_description description, n_created_at date from news n"
			+ " left join users u on u.u_id = n.n_u_id"
			+ " left join category c on c.c_id = n.n_c_id",
			nativeQuery=true)
	List<NewsShow> showAll();
	
	@Query(value="select n_id id, u_name user, c_name category, n_title title, n_description description, n_created_at date from news n"
			+ " left join users u on u.u_id = n.n_u_id"
			+ " left join category c on c.c_id = n.n_c_id"
			+ " where n_c_id = ?1",
			nativeQuery=true)
	List<NewsShow> showByCategory(Long categoryId);
	
	@Query(value="select n_id id, u_name user, c_name category, n_title title, n_description description, n_created_at date from news n"
			+ " left join users u on u.u_id = n.n_u_id"
			+ " left join category c on c.c_id = n.n_c_id"
			+ " where n_id = ?1",
			nativeQuery=true)
	NewsShow showDetail(Long id);

}
