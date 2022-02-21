package tn.dksoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.dksoft.dao.UserPagiRep;
import tn.dksoft.dao.UserRepository;
import tn.dksoft.entity.User;

@Service

public class UserService {

	private final UserRepository userRepository;
	private final UserPagiRep userPagiRep;

	@Autowired
	public UserService(UserRepository userRepository, UserPagiRep userPagiRep) {
		super();
		this.userRepository = userRepository;
		this.userPagiRep = userPagiRep;
	}

	public List<User> getAllUser(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<User> pagedResult = userPagiRep.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
	
	
	
	public void addUser(User user) {
		userRepository.saveAndFlush(user);
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
