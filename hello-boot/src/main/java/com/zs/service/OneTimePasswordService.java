package com.zs.service;

import org.springframework.stereotype.Service;

@Service
public class OneTimePasswordService {

	public long generateOtp() {
		while(true) {
			long otp = (long)(Math.random() * 999999);
			if(otp > 99999)
				return otp;
		}
	}
}
