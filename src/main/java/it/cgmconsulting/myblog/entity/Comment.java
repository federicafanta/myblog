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
public class Comment extends CreationUpdate { // La classe Comment estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore del campo id sarà generato automaticamente dal database.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private int id; // Identificatore univoco del commento.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità User.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private User user; // Riferimento all'utente che ha scritto il commento.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità Post.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private Post post; // Riferimento al post a cui è associato il commento.

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private String comment; // Testo del commento.

    private boolean censored; // Indica se il commento è stato censurato.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità Comment. Utilizzato per rappresentare commenti annidati (thread).
    private Comment parent; // Riferimento al commento genitore, se questo è un commento di risposta.

}
