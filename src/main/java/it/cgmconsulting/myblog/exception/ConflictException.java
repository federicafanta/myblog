package it.cgmconsulting.myblog.exception;

import lombok.Getter;

@Getter // Genera automaticamente il metodo getter per il campo messageError grazie a Lombok.
public class ConflictException extends RuntimeException { // Estende RuntimeException per creare una custom exception.

    private final String messageError; // Campo per memorizzare il messaggio di errore.

    public ConflictException(String messageError) { // Costruttore che accetta un messaggio di errore come argomento.
        super(String.format(messageError)); // Passa il messaggio di errore formattato alla superclasse RuntimeException.
        this.messageError = messageError; // Inizializza il campo messageError con il valore passato.
    }
}
