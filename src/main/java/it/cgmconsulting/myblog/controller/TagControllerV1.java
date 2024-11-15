package it.cgmconsulting.myblog.controller;

import it.cgmconsulting.myblog.entity.Tag;
import it.cgmconsulting.myblog.payload.response.TagResponse;
import it.cgmconsulting.myblog.service.TagService;
import it.cgmconsulting.myblog.utils.Msg;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController // Indica che questa classe è un controller REST, quindi gestisce richieste HTTP restituendo risposte JSON.
@RequestMapping("/v1/tags") // Definisce il percorso di base per tutte le richieste gestite da questo controller.
@RequiredArgsConstructor // Genera un costruttore con tutti i campi finali come argomenti, utile per l'iniezione delle dipendenze.
@Validated // Abilita la validazione dei parametri a livello di metodo.
public class TagControllerV1 {

    private final TagService tagService; // Iniezione del servizio dei tag tramite costruttore.

    @PostMapping // Mappa le richieste POST a /v1/tags a questo metodo.
    public ResponseEntity<Tag> create(@RequestParam
                                      @NotBlank(message = "Tag cannot be blank or null") // Verifica che il parametro non sia vuoto o nullo.
                                      @Size(max = 30, min = 3, message="The value must be between 3 and 30 characters") String id) { // Verifica che la lunghezza del parametro sia tra 3 e 30 caratteri.
        return new ResponseEntity<>(tagService.create(id.toUpperCase()), HttpStatus.CREATED); // Chiama il servizio per creare il tag e restituisce una risposta con stato HTTP 201 (Created).
    }

    @PatchMapping // Mappa le richieste PATCH a /v1/tags a questo metodo.
    public ResponseEntity<Tag> switchVisibility(@RequestParam
                                                @NotBlank(message = "Tag cannot be blank or null") // Verifica che il parametro non sia vuoto o nullo.
                                                @Size(max = 30, min = 3, message="The value must be between 3 and 30 characters") String id) { // Verifica che la lunghezza del parametro sia tra 3 e 30 caratteri.
        return new ResponseEntity<>(tagService.switchVisibility(id.toUpperCase()), HttpStatus.OK); // Chiama il servizio per cambiare la visibilità del tag e restituisce una risposta con stato HTTP 200 (OK).
    }

    @GetMapping // Mappa le richieste GET a /v1/tags a questo metodo.
    public ResponseEntity<List<TagResponse>> getTags() {
        return new ResponseEntity<>(tagService.getTags(), HttpStatus.OK); // Chiama il servizio per ottenere la lista dei tag e restituisce una risposta con stato HTTP 200 (OK).
    }

}
