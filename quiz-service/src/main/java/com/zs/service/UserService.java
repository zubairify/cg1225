package com.zs.service;

import com.zs.dto.LoginDTO;
import com.zs.dto.UserDTO;
import com.zs.entity.User;

public interface UserService {

	User save(UserDTO dto);
	
	User login(LoginDTO dto);
	
	static User transform(UserDTO dto) {
		User user = new User();
		user.setUserid(dto.getUserid());
		user.setPasswd(dto.getPasswd());
		user.setEmail(dto.getEmail());
		return user;
	}
}
