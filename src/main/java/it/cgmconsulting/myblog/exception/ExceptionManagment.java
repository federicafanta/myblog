package it.cgmconsulting.myblog.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice // Indica che questa classe fornisce una gestione centralizzata delle eccezioni per l'intera applicazione.
public class ExceptionManagment {

    @ExceptionHandler({ConflictException.class}) // Gestisce le eccezioni di tipo ConflictException.
    public ResponseEntity<String> conflictExceptionManagement(ConflictException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // Restituisce una risposta con lo stato HTTP 409 (Conflict) e il messaggio dell'eccezione.
    }

    @ExceptionHandler({ConstraintViolationException.class}) // Gestisce le eccezioni di tipo ConstraintViolationException.
    public ResponseEntity<List<String>> constraintViolationExceptionManagement(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<String> errors = violations.stream()
                .map(ConstraintViolation::getMessage) // Ottiene i messaggi di errore per ogni vincolo violato.
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Restituisce una risposta con lo stato HTTP 400 (Bad Request) e una lista di messaggi di errore.
    }

    @ExceptionHandler({ResourceNotFoundException.class}) // Gestisce le eccezioni di tipo ResourceNotFoundException.
    public ResponseEntity<String> resourceNotFoundExceptionManagement(ConflictException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // Restituisce una risposta con lo stato HTTP 404 (Not Found) e il messaggio dell'eccezione.
    }
}
