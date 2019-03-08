package id.newsservice.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.newsservice.model.user.User;
import id.newsservice.model.user.UserPasswordChanger;
import id.newsservice.repository.UserReposirory;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserReposirory userRepo;
	
	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(Long id) {
		if (userRepo.findById(id).isPresent()) {
            return userRepo.findById(id).get();
        }
        return null;
	}

	@Override
	public User userRegister(User user) {
		String encodePass = DigestUtils.sha256Hex(user.getPassword());
		User addUser = new User(user.getUsername(),user.getName(), encodePass, user.getGender());
		userRepo.save(addUser);
		return addUser;
	}

	@Override
	public User userLogin(User user) {
		String encodePass = DigestUtils.sha256Hex(user.getPassword());
		User userLogin = userRepo.findByUsernamePass(user.getUsername(), encodePass);
		if(userLogin != null) {
			return userLogin;
		}
		return null;
	}

	@Override
	public User userEdit(Long userId, User user) {
		if (userRepo.findById(userId).isPresent()) {
            User userUpdated = userRepo.findById(userId).get();

            userUpdated.setName(user.getName());
            userUpdated.setGender(user.getGender());
            userUpdated.setUsername(user.getUsername());

            userRepo.save(userUpdated);

            return userUpdated;
        }

        return null;
	}

	@Override
	public User changePassword(Long userId, UserPasswordChanger user) {
		if (userRepo.findById(userId).isPresent()) {
            User userUpdated = userRepo.findById(userId).get();
            
            String encodePass = DigestUtils.sha256Hex(user.getConfirmPassword());
            userUpdated.setPassword(encodePass);
            userRepo.save(userUpdated);

            return userUpdated;
        }

        return null;
	}

}
