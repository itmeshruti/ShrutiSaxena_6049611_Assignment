package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(
	            MethodArgumentNotValidException ex) {

	        Map<String, String> errors = new HashMap<>();

	        ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errors.put(error.getField(), error.getDefaultMessage());
	        });

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }

	    // 2️⃣ Department not found
	    @ExceptionHandler(DepartmentNameNotFoundException.class)
	    public ResponseEntity<String> handleDeptNotFound(DepartmentNameNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    // 3️⃣ Mobile not found
	    @ExceptionHandler(MobileNumberDoesNotExistsForEmployeeException.class)
	    public ResponseEntity<String> handleMobileNotFound(
	            MobileNumberDoesNotExistsForEmployeeException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    // 4️⃣ Employee not found
	    @ExceptionHandler(EmployeeNotFoundException.class)
	    public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    // 5️⃣ Generic exception
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleAll(Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}




//package com.example.demo.exception;
//
//
//import java.util.*;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
////import jakarta.validation.ConstraintViolationException;
//
//@RestControllerAdvice
//// This class will handle exceptions globally for all controllers in the application and return appropriate HTTP responses when exceptions occur.
//public class GlobalExceptionHandler {
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<String> handlerForPhoneNotFound(EmployeeNotFoundException ex) {
//
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//	}
//
////	@ExceptionHandler(MethodArgumentNotValidException.class)
////	public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
////	    return new ResponseEntity<>(
////	        ex.getBindingResult().getFieldError().getDefaultMessage(),
////	        HttpStatus.BAD_REQUEST
////	    );
////	}
//	// This method handles validation exceptions that occur when method arguments
//	// fail validation. It extracts the default error message from the first field
//	// error and returns it in the response body with a 400 Bad Request status.
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
//
//		Map<String, String> errors = new HashMap<>();
//
//		ex.getBindingResult().getFieldErrors().forEach(error -> {
//			errors.put(error.getField(), error.getDefaultMessage());
//		});
//
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
//}