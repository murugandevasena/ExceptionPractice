package com.cricket.glopalexceptionhandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cricket.userdefinedexception.IdNotFoundException;
import com.cricket.userdefinedexception.JercyNotFoundException;
import com.cricket.userdefinedexception.PlayerNotFoundException;

@RestControllerAdvice
public class GlopalHandling {
	@ExceptionHandler(JercyNotFoundException.class)
	public String jercyHandling() {
		return "Jercy number already exist.";
	}

	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<Object> playerNotFoundHandling() {
		return new ResponseEntity<Object>("Player not found.", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class) 
	public ResponseEntity<Object> noSuchElementException() {
		return new ResponseEntity<Object>("No such record.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class) 
	public ResponseEntity<Object> idNotFoundException() {
		return new ResponseEntity<Object>("No such id.Please check", HttpStatus.BAD_REQUEST);
	}

}
