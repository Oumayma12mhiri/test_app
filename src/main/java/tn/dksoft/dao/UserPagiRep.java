package tn.dksoft.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tn.dksoft.entity.User;

@Repository
public interface UserPagiRep extends PagingAndSortingRepository<User, Long> {

}
