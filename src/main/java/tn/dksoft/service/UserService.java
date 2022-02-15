package tn.dksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dksoft.dao.UserRepository;
import tn.dksoft.entity.User;

@Service

public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void addUser(User user) {
		userRepository.saveAndFlush(user);
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public void updateUser(User newUser, Long id) {
		User currentUser = userRepository.findById(id).get();
		
			if (currentUser != null) {
				currentUser.setName(newUser.getName());
				currentUser.setEmail(newUser.getEmail());
				currentUser.setNumMobile(newUser.getNumMobile());
				currentUser.setSalary(newUser.getSalary());
				
				userRepository.saveAndFlush(currentUser);
			}
		

	}

}
