package com.cin.cyclerentalservice.exception;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GenericResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(GenericResponseEntityExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericException> handleAllException (Exception e) {
		logger.info("Here in handleAllException...");
		GenericException genericException = new GenericException("500", e.getMessage());
		return new ResponseEntity<GenericException>(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<GenericException> handleNoRecordFoundException (NoResultException e) {
		logger.info("Here in handleNoRecordFoundException...");
		GenericException genericException = new GenericException("404", e.getMessage());
		return new ResponseEntity<GenericException>(genericException, HttpStatus.NOT_FOUND);
	}
}
