package it.cgmconsulting.myblog.exception;

import lombok.Getter;

@Getter // Genera automaticamente i metodi getter per tutti i campi della classe grazie a Lombok.
public class ResourceNotFoundException extends RuntimeException { // Estende RuntimeException per creare una custom exception.

    private final String resourceName; // Nome della risorsa non trovata.
    private final String fieldName; // Nome del campo che ha causato la mancata individuazione della risorsa.
    private final Object value; // Valore del campo che ha causato la mancata individuazione della risorsa.

    public ResourceNotFoundException(String resourceName, String fieldName, Object value) { // Costruttore che accetta il nome della risorsa, il nome del campo e il valore come argomenti.
        super(String.format("%s not found with %s: %s", resourceName, fieldName, value)); // Passa un messaggio formattato alla superclasse RuntimeException.
        this.resourceName = resourceName; // Inizializza il campo resourceName con il valore passato.
        this.fieldName = fieldName; // Inizializza il campo fieldName con il valore passato.
        this.value = value; // Inizializza il campo value con il valore passato.
    }
}
