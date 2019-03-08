package id.newsservice.service;

import java.util.List;

import id.newsservice.model.user.User;
import id.newsservice.model.user.UserPasswordChanger;

public interface UserService {

	List<User> getAll();
	User getUser(Long id);
	User userRegister(User user);
	User userLogin(User user);
	User userEdit(Long idUser, User User);
	User changePassword(Long idUser, UserPasswordChanger user);
	
}
