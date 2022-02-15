package tn.dksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.dksoft.entity.UserAuthentification;
import tn.dksoft.service.UserAuthentificationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login/")
public class UserAuthentificationController {
	
	private final UserAuthentificationService userAuthentificationService;
	
	
    @Autowired
	public UserAuthentificationController(UserAuthentificationService userAuthentificationService) {
		super();
		this.userAuthentificationService = userAuthentificationService;
	}
	
	@GetMapping("{username}")
	public UserAuthentification getByUsernamePassword(@PathVariable("username") String username) {
		return userAuthentificationService.getUserByUsernamePassword(username);
	}
	

}
