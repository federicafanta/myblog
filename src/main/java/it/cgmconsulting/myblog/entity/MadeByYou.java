package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.*;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class MadeByYou extends CreationUpdate { // La classe MadeByYou estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore del campo id sarà generato automaticamente dal database.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private int id; // Identificatore univoco dell'elemento "MadeByYou".

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private String image; // Percorso o nome del file dell'immagine.

    @Column(length = 100) // Configura la colonna per accettare fino a 100 caratteri.
    private String description; // Descrizione dell'immagine.

    private boolean censored; // Indica se l'elemento è stato censurato.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità User.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private User user; // Riferimento all'utente che ha caricato l'immagine.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità Post.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private Post post; // Riferimento al post associato all'immagine.

}
