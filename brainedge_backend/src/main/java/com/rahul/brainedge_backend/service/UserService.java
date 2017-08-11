package com.rahul.brainedge_backend.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.brainedge_backend.entity.User;
import com.rahul.brainedge_backend.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger logger=Logger.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	

	public boolean save(User user) {
		try {
			userRepository.save(user);
			logger.debug("User created successfully "+user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to creat User!");
			return false;
		}
	}
}
