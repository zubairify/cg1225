package com.zs.service;

import com.zs.dto.TestDTO;
import com.zs.entity.Result;

public interface TestService {

	Result submit(TestDTO dto);
}
