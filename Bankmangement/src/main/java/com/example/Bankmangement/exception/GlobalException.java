package com.example.Bankmangement.exception;




import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.bankmangement.payload.ErrorDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(LoanApiException.class)
    public ResponseEntity<ErrorDetails> handleBlogAPIException(LoanApiException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
              webRequest.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
   }
    
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatus status,
                                                                   WebRequest request) {
         Map<String, String> errors = new HashMap<>();
         ex.getBindingResult().getAllErrors().forEach((error) ->{
             String fieldName = ((FieldError)error).getField();
             String message = error.getDefaultMessage();
             errors.put(fieldName, message);
         });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
     }
    
    
   
   }

