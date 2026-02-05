package com.zs.service;

import org.springframework.stereotype.Service;

import com.zs.dto.LoginDTO;

@Service
public class LoginService {

	public boolean authenticate(LoginDTO login) {
		if(login.getUserid().equals("scott") && 
				login.getPassword().equals("tiger"))
			return true;
		else
			return false;
	}
}
