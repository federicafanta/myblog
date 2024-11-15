package it.cgmconsulting.myblog.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable // Indica che questa classe può essere incorporata in altre entità come una chiave primaria composta.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@EqualsAndHashCode // Genera automaticamente i metodi equals() e hashCode() considerando tutti i campi della classe.
public class RatingId implements Serializable { // Implementa Serializable per consentire la serializzazione degli oggetti di questa classe.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità User.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private User user; // Riferimento all'utente che ha effettuato la valutazione.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità Post.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private Post post; // Riferimento al post che è stato valutato.

}
