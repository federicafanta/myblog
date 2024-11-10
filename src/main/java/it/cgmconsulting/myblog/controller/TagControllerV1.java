package it.cgmconsulting.myblog.controller; // Questo indica che il file TagControllerV1.java appartiene al package
                                            // it.cgmconsulting.myblog.controller. I package in Java aiutano a organizzare
                                            // le classi in gruppi logici.

// Questi import dichiarano le classi e le annotazioni utilizzate nel controller:
import it.cgmconsulting.myblog.entity.Tag; // Entità del modello.
import it.cgmconsulting.myblog.service.TagService; // Servizio che contiene la logica di business per i tag.
import it.cgmconsulting.myblog.utils.Msg; // Utilità per i messaggi
import lombok.RequiredArgsConstructor; // Annotazione Lombok per generare un costruttore con tutti i campi final.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica che questa classe è un controller RESTful.
@RequestMapping("/v1/tags") // Mappa le richieste HTTP a /v1/tags a questo controller.
@RequiredArgsConstructor // Genera un costruttore per tutti i campi final.
                        // In questo caso, tagService è iniettato tramite costruttore.
public class TagControllerV1 {

    private final TagService tagService; // Dichiarazione di un servizio TagService iniettato automaticamente.

    @PostMapping //Gestisce le richieste HTTP POST all'endpoint /v1/tags.
    public ResponseEntity<Tag> create(@RequestParam String id){ //Metodo per creare un nuovo tag.
        // @RequestParam String id: Riceve un parametro di richiesta chiamato id.
        // tagService.create(id): Chiama il servizio per creare un nuovo tag con l'ID specificato.
        // new ResponseEntity<>(tagService.create(id), HttpStatus.CREATED): Restituisce una risposta
        // con lo stato HTTP 201 (CREATED).
        return new ResponseEntity<>(tagService.create(id), HttpStatus.CREATED);
    }




    // modifica visibilità
    // get dei tag distinguendo tra visibili e non visibili)


}
