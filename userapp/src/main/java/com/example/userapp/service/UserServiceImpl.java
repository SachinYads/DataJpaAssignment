package com.example.userapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userapp.entity.User;
import com.example.userapp.repository.UserRepository;

import exceptions.InvalidCredentialsException;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;	
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public User getUserByName(String userName) {
		return userRepo.findByUsername(userName);
		
	}
	@Override
	public User updateUser(User user) {
		if(userRepo.existsById(user.getUserId())) {
			userRepo.save(user);
		}
		return user;
	}
	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);

	}

	@Override
	public User loginUser(User user) throws InvalidCredentialsException {
		User usr = userRepo.findByUsername(user.getUsername());
		if(usr!= null) {
			if(usr.getPassword().equals(user.getPassword() )) {

				return usr;
			}else {
				throw new InvalidCredentialsException();
			}
		}else {
			throw new InvalidCredentialsException();
		}

	}
	
}