package id.newsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.newsservice.model.user.User;

public interface UserReposirory extends JpaRepository<User, Long>{
	
	@Query(value = "select * from users where u_username = ? and u_password = ? ", nativeQuery = true)
	User findByUsernamePass(String userName, String password);
	
	@Query(value = "select * from users where u_id = ? and u_password = ? ", nativeQuery = true)
	User findByIdPass(Long id, String password);

}
