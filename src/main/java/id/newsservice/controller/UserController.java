package id.newsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.newsservice.model.user.User;
import id.newsservice.model.user.UserPasswordChanger;
import id.newsservice.repository.UserReposirory;
import id.newsservice.response.MetaResponse;
import id.newsservice.response.CustomResponse;
import id.newsservice.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity getAll() {
		return new CustomResponse().success(userService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getUser(@PathVariable("id") Long id){
		if(null == userService.getUser(id)) {			
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(userService.getUser(id));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user){
		return new CustomResponse().success(userService.userRegister(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody User user){
		if(null == userService.userLogin(user)) {			
			return new CustomResponse().badRequest("Username and password not match");
		}
		return new CustomResponse().success(userService.userLogin(user));		
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody User user) {
		if(null == userService.userEdit(id, user)) {			
			return new CustomResponse().notFound();
		}
		return new CustomResponse().success(userService.userEdit(id, user));
	}
	
	@PostMapping("/change-password/{id}")
	public ResponseEntity changePassword(@PathVariable("id") Long id, @RequestBody UserPasswordChanger user) {
		if(!user.getNewPassword().equals(user.getConfirmPassword())) {
			return new CustomResponse().badRequest("Password not match");
		}
		return new CustomResponse().success(userService.changePassword(id, user));
	}
	

}
