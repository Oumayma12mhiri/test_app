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

	public void updateUser(User user, Long id) {
		List<User> users = userRepository.findAll();
		for (User us : users) {
			if (us.getId() == id) {
				us.setName(user.getName());
				us.setEmail(user.getEmail());
				us.setNumMobile(user.getNumMobile());
				us.setSalary(user.getSalary());
				userRepository.save(user);
			}
		}

	}

}
