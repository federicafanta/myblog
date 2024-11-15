package it.cgmconsulting.myblog.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice // Indica che questa classe fornisce una gestione centralizzata delle eccezioni per l'intera applicazione.
public class ExceptionManagement {

    @ExceptionHandler({ConflictException.class}) // Gestisce le eccezioni di tipo ConflictException.
    public ResponseEntity<String> conflictExceptionManagement(ConflictException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // Restituisce una risposta con lo stato HTTP 409 (Conflict) e il messaggio dell'eccezione.
    }

    @ExceptionHandler({ResourceNotFoundException.class}) // Gestisce le eccezioni di tipo ResourceNotFoundException.
    public ResponseEntity<String> resourceNotFoundExceptionManagement(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // Restituisce una risposta con lo stato HTTP 404 (Not Found) e il messaggio dell'eccezione.
    }

    // Per la gestione delle eccezioni sollevate dalle annotazioni di validazione con @Validated.
    @ExceptionHandler({ConstraintViolationException.class}) // Gestisce le eccezioni di tipo ConstraintViolationException.
    public ResponseEntity<Map<String, String>> constraintViolationExceptionManagement(ConstraintViolationException ex) {
        Map<String, String> errors = ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> {
                            String path = violation.getPropertyPath().toString(); // Ottiene il percorso della proprietà che ha violato il vincolo.
                            return path.substring(path.lastIndexOf('.') + 1); // Estrae il nome del campo che ha violato il vincolo.
                        },
                        violation -> violation.getMessage())); // Ottiene il messaggio di errore per ogni vincolo violato.
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Restituisce una risposta con lo stato HTTP 400 (Bad Request) e una mappa degli errori.
    }

    // Per la gestione delle eccezioni sollevate dalle annotazioni di validazione con @Valid.
    @ExceptionHandler(MethodArgumentNotValidException.class) // Gestisce le eccezioni di tipo MethodArgumentNotValidException.
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())); // Popola la mappa degli errori con il nome del campo e il messaggio di errore.
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Restituisce una risposta con lo stato HTTP 400 (Bad Request) e una mappa degli errori.
    }
}
