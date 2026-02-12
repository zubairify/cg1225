package com.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.LoginDTO;
import com.zs.dto.UserDTO;
import com.zs.entity.User;
import com.zs.error.InvalidLoginException;
import com.zs.repo.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserSeviceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	
	@Override
	public User save(UserDTO dto) {
		log.info("User service requested to save user");
		return repo.save(UserService.transform(dto));
	}

	@Override
	public User login(LoginDTO dto) {
		log.info("User service validating login");
		return repo.findByLogin(dto.getUserid(), dto.getPasswd()).orElseThrow(
			() -> new InvalidLoginException("Invalid userid or password"));
	}
}
