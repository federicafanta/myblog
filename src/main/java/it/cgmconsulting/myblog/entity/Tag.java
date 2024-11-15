package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class Tag extends CreationUpdate { // La classe Tag estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    @Column(length = 30) // Configura la colonna per accettare una lunghezza massima di 30 caratteri.
    private String id; // Identificatore univoco del tag.

    private boolean visible = true; // Indica se il tag è visibile. Di default è true.

    public Tag(String id) { // Costruttore che prende un argomento id.
        this.id = id; // Inizializza il campo id con il valore passato.
        this.visible = true; // Inizializza il campo visible a true.
    }
}
