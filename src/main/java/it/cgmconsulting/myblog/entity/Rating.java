package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Check;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class Rating extends CreationUpdate { // La classe Rating estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @EmbeddedId // Indica che questo campo è una chiave primaria composta (embedded id).
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private RatingId ratingId; // Identificatore composto dell'entità Rating.

    @Check(constraints = "rate > 0 AND rate < 6") // Vincolo sul database che impedisce l'inserimento di valori al di fuori del range specificato.
    private byte rate; // Valutazione espressa in stelline da 1 a 5.

}
