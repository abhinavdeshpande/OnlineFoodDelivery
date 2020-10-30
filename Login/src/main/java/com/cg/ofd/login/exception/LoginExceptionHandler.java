package com.cg.ofd.login.exception;

import java.sql.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LoginExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<LoginErrorResponse> handleException(UserNotFoundException exception, WebRequest webRequest){
		LoginErrorResponse errorResponse = new LoginErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<LoginErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<LoginErrorResponse> handleException(Exception ex){
		LoginErrorResponse errorResponse = new LoginErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("Record Not Found");
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<LoginErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status,WebRequest request) {
		LoginErrorResponse response= new LoginErrorResponse(HttpStatus.BAD_REQUEST.value(), "UserName and password should have at least 2 characters",
   			 System.currentTimeMillis());
   	
     return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
   }
	
	//handling custom validation errors
	/*@ExceptionHandler
	public ResponseEntity<LoginErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException excep){
		LoginErrorResponse errorResponse = new LoginErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(excep.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<LoginErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}*/
}
