package it.cgmconsulting.myblog.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManagement {

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<String> conflictExceptionManagement(ConflictException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
