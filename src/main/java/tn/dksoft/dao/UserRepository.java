package tn.dksoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dksoft.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
