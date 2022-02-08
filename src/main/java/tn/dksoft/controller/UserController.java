package tn.dksoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.dksoft.entity.User;
import tn.dksoft.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/get")
	public List<User> get() {
		return (List<User>) userService.getUser();
	}

	@PostMapping("/post")
	public void save(@RequestBody User user) {
		user.setEmail("oumaima@gmail.com");
		userService.addUser(user);
	}

	@PutMapping("/put")
	public void put(@RequestBody User user, @RequestParam Long id) {
		userService.updateUser(user, id);
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam Long id) {
		userService.deleteUser(id);
	}

}
