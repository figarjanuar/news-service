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
import id.newsservice.response.Response;
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
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
		Response res = new Response("OK", userService.getAll(), meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getUser(@PathVariable("id") Long id){
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
		Response res = new Response("OK", userService.getUser(id), meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user){
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
		Response res = new Response("OK", userService.userRegister(user), meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody User user){
		if(null == userService.userLogin(user)) {			
			MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), "User Not Found", "");
			Response res = new Response("ERROR", userService.userLogin(user), meta);
			return new ResponseEntity(res, HttpStatus.NOT_FOUND);
		}else{			
			MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
			Response res = new Response("OK", userService.userLogin(user), meta);
			return new ResponseEntity(res, HttpStatus.OK);
		}		
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody User user) {
		if(null == userService.userEdit(id, user)) {			
			MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), "User Not Found", "");
			Response res = new Response("ERROR", userService.userEdit(id, user), meta);
			return new ResponseEntity(res, HttpStatus.NOT_FOUND);
		}else{			
			MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
			Response res = new Response("OK", userService.userEdit(id, user), meta);
			return new ResponseEntity(res, HttpStatus.OK);
		}
	}
	
	@PostMapping("/change-password/{id}")
	public ResponseEntity changePassword(@PathVariable("id") Long id, @RequestBody UserPasswordChanger user) {
		if(!user.getNewPassword().equals(user.getConfirmPassword())) {
			MetaResponse meta = new MetaResponse(HttpStatus.BAD_REQUEST.value(), "Password not match", "");
			Response res = new Response("ERROR", null, meta);
			return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
		}else {
			MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
			Response res = new Response("OK", userService.changePassword(id, user), meta);
			return new ResponseEntity(res, HttpStatus.OK);
		}
	}
	

}
