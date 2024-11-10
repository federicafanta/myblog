package it.cgmconsulting.myblog.service; // Questo indica che il file TagService.java appartiene al package
                                        // it.cgmconsulting.myblog.service. I package in Java sono utilizzati
                                        // per organizzare le classi in gruppi logici.

import it.cgmconsulting.myblog.entity.Tag; // L'entità del modello.
import it.cgmconsulting.myblog.exception.ConflictException; // Eccezione personalizzata lanciata in caso di conflitto.
import it.cgmconsulting.myblog.repository.TagRepository; // Repository per accedere ai dati del tag.
import it.cgmconsulting.myblog.utils.Msg; // Utilità per i messaggi (come ad esempio messaggi di errore).
import lombok.RequiredArgsConstructor; // Annotazione Lombok che genera un costruttore con tutti i campi final.
import org.springframework.stereotype.Service; // Annotazione Spring che definisce questa classe come un servizio.

import java.util.Optional; // Classe utilizzata per gestire i valori opzionali che potrebbero essere presenti o meno.

@Service // Indica che questa classe è un servizio Spring,
        // il che significa che è un componente gestito dal contesto di Spring.
@RequiredArgsConstructor // Utilizzata per generare un costruttore
                        // che accetta tutti i campi final come parametri, il che facilita l'iniezione delle dipendenze.
public class TagService {

    private final TagRepository tagRepository; // Dichiarazione del repository che verrà utilizzato per accedere ai dati dei tag.
                                                // È iniettato automaticamente grazie all'annotazione @RequiredArgsConstructor.

    public Tag create(String id){ //Metodo per creare un nuovo tag.
        Optional<Tag> tag = tagRepository.findById(id); // Cerca un tag nel repository utilizzando l'ID fornito.
        if(tag.isEmpty())
            return tagRepository.save(new Tag(id)); // Se il tag non esiste, ne crea uno nuovo e lo salva nel repository.
        throw new ConflictException(Msg.TAG_ALREADY_PRESENT); //Se il tag esiste già, lancia un'eccezione di conflitto
                                                            // con un messaggio di errore appropriato.
    }
}
