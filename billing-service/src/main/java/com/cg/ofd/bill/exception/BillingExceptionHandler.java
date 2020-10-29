package com.cg.ofd.bill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BillingExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<BillingErrorResponse> handleException(BillNotFoundException exception, WebRequest webRequest){
        BillingErrorResponse errorResponse = new BillingErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<BillingErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BillingErrorResponse> handleException(Exception ex){
        BillingErrorResponse errorResponse = new BillingErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Records for specified Entry not found");
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<BillingErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
