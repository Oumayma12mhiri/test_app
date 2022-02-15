package tn.dksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dksoft.dao.UserAuthentificationRepository;
import tn.dksoft.entity.UserAuthentification;

@Service
public class UserAuthentificationService {
	
	private final UserAuthentificationRepository userAuthentificationRepository;
	
    @Autowired
	public UserAuthentificationService(UserAuthentificationRepository userAuthentificationRepository) {
		super();
		this.userAuthentificationRepository = userAuthentificationRepository;
	}
    
    public UserAuthentification getUserByUsernamePassword(String username) {
    	return userAuthentificationRepository.findByUsername(username);
    }
	
	
	
	
	

}
