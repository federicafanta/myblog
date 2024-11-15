package it.cgmconsulting.myblog.controller;

import it.cgmconsulting.myblog.payload.request.SignUpRequest;
import it.cgmconsulting.myblog.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Indica che questa classe è un controller REST, quindi gestisce richieste HTTP restituendo risposte JSON.
@RequestMapping("/v1/auth") // Definisce il percorso di base per tutte le richieste gestite da questo controller.
@RequiredArgsConstructor // Genera un costruttore con tutti i campi finali come argomenti, utile per l'iniezione delle dipendenze.
public class AuthControllerV1 {

    private final AuthService authService; // Iniezione del servizio di autenticazione tramite costruttore.

    @PostMapping("/signup") // Mappa le richieste POST a /v1/auth/signup a questo metodo.
    public ResponseEntity<String> signup(@RequestBody @Valid SignUpRequest request) {
        // @RequestBody mappa il corpo della richiesta HTTP a un oggetto SignUpRequest.
        // @Valid verifica che il payload della richiesta soddisfi i vincoli di validazione definiti in SignUpRequest.
        return ResponseEntity.ok(authService.signup(request)); // Chiamata al servizio di autenticazione per elaborare la richiesta di registrazione.
    }

    @PatchMapping("/confirm/{confirmCode}") // Mappa le richieste PATCH a /v1/auth/confirm/{confirmCode} a questo metodo.
    public ResponseEntity<String> verifyEmail(@PathVariable String confirmCode) {
        // @PathVariable estrae il valore di confirmCode dal percorso dell'URL.
        return ResponseEntity.ok(authService.verifyEmail(confirmCode)); // Chiamata al servizio di autenticazione per verificare l'email utilizzando il codice di conferma.
    }

}
