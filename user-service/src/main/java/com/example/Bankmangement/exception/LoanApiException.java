package com.example.Bankmangement.exception;





import org.springframework.http.HttpStatus;

 

public class LoanApiException extends RuntimeException{

     final HttpStatus status;
        final String message;

 

        public LoanApiException(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

 

        public LoanApiException(String message, HttpStatus status, String message1) {
            super(message);
            this.status = status;
            this.message = message1;
        }

 

        public HttpStatus getStatus() {
            return status;
        }

 

        @Override
        public String getMessage() {
            return message;
        }

 

}