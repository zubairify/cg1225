package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.UserDTO;
import com.zs.entity.User;
import com.zs.error.InvalidUserException;
import com.zs.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public User save(UserDTO dto) {
		return repo.save(UserService.transform(dto));
	}

	@Override
	public User find(int uid) {
		return repo.findById(uid).orElseThrow(
				() -> new InvalidUserException("User not found with Id: " + uid));
	}

	@Override
	public List<User> list() {
		return repo.findAllOrderByName();
	}
}
