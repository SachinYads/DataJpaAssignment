package com.example.userapp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userapp.entity.User;
import com.example.userapp.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
	User findByEmail(String email);

}