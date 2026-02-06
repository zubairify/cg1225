package com.zs.service;

import java.util.List;

import com.zs.dto.UserDTO;
import com.zs.entity.User;

public interface UserService {

	User save(UserDTO dto);
	
	User find(int uid);
	
	List<User> list();
	
	static User transform(UserDTO dto) {
		User usr = new User();
		usr.setUid(dto.getUid());
		usr.setName(dto.getName());
		return usr;
	}
}
