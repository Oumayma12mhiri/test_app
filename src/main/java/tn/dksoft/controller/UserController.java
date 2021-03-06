package tn.dksoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.dksoft.entity.User;
import tn.dksoft.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/users/")

public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("get")
	public List<User> get(@RequestParam(defaultValue = "0") Integer pageNo, 
                @RequestParam(defaultValue = "2") Integer pageSize,
                @RequestParam(defaultValue = "id") String sortBy) {
           return userService.getAllUser(pageNo, pageSize, sortBy);
	}

	@PostMapping
	
	public void save(@RequestBody User user) {
		userService.addUser(user);
	}

	@PutMapping("{id}")
	
	public void put(@RequestBody User user, @PathVariable Long id) {
		userService.updateUser(user, id);
	}

	@DeleteMapping("{id}")
	
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
