package com.zs.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TestDTO {
	private String userid;
	private int quizId;
	private List<AttemptDTO> attempts = new ArrayList<AttemptDTO>();
}
