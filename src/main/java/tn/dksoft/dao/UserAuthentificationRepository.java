package tn.dksoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dksoft.entity.UserAuthentification;

@Repository
public interface UserAuthentificationRepository extends JpaRepository<UserAuthentification, Long> {
	UserAuthentification findByUsername(String username);

}
