package com.capgemini.emp.exceptions.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.capgemini.emp.dto.ErrorResponseDto;
import com.capgemini.emp.exceptions.IdNotFoundException;
import com.capgemini.emp.exceptions.MobileNumberAlreadyExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<?> handleIdNotFoundException(IdNotFoundException ex, WebRequest wr){
		ErrorResponseDto error=new ErrorResponseDto();
		error.setMsg(ex.getMessage());
		error.setPath(wr.getDescription(false));
		error.setDateTime(LocalDateTime.now().toString());
		return new ResponseEntity<ErrorResponseDto>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = MobileNumberAlreadyExistsException.class)
	public ResponseEntity<?> handleMobileNumberAlreadyExistsException(MobileNumberAlreadyExistsException ex, WebRequest wr){
		ErrorResponseDto error=new ErrorResponseDto();
		error.setMsg(ex.getMessage());
		error.setPath(wr.getDescription(false));
		error.setDateTime(LocalDateTime.now().toString());
		return new ResponseEntity<ErrorResponseDto>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest wr){
		List<FieldError> errors=ex.getBindingResult().getFieldErrors();
		Map<String, String> error=new HashMap<>();
		for(FieldError fe:errors) {
			String msg=fe.getDefaultMessage();
			String field=fe.getField();
			error.put(field, msg);
		}
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}

}
