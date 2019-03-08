package id.newsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.newsservice.model.User;
import id.newsservice.repository.UserReposirory;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserReposirory userRepo;

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

}
