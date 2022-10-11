package com.barclays.student.adharapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.barclays.student.adharapp.dto.Person;
import com.barclays.student.adharapp.dto.ResponseStructure;
@ControllerAdvice
public class AdharappException_Handler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(AdharaIdNotFoundException.class)
	
public ResponseEntity<ResponseStructure<String>> IdNotFoundException(AdharaIdNotFoundException exception)
{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Exception Id not found or exists");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

}
