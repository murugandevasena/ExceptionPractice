package com.person.glopalexception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.person.userdefinedexception.IdNotFoundException;
import com.person.userdefinedexception.NameNotFoundException;
import com.person.userdefinedexception.NoOneFoundException;

@RestControllerAdvice
public class GlopalExceptionHandle {
	@ExceptionHandler(IdNotFoundException.class)
	public String idNotFoundHandling() {
		return "Specified id not found.";
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public String nameNotFoundHandling() {
		return "Specified Name not found.";
	}

	@ExceptionHandler(NoSuchElementException.class) 
	public ResponseEntity<Object> noSuchElementException() {
		return new ResponseEntity<Object>("No such record.", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoOneFoundException.class) 
	public ResponseEntity<Object> noOneFoundException() {
		return new ResponseEntity<Object>("No such a age group person.", HttpStatus.BAD_REQUEST);
	}

}
