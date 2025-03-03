package com.capgemini.emp.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
	
	private String dateTime;
	
	private String msg;
	
	private String path;
	

}
