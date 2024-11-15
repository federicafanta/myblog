package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class Post extends CreationUpdate { // La classe Post estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore del campo id sarà generato automaticamente dal database.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private int id; // Identificatore univoco del post.

    @Column(unique = true, nullable = false) // Configura la colonna per essere unica e non accettare valori null.
    private String title; // Titolo del post.

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private String overview; // Riepilogo del post.

    @Column(length = 10000, nullable = false) // Configura la colonna per accettare fino a 10000 caratteri e non accettare valori null.
    private String content; // Contenuto del post.

    private String image; // Nome del file dell'immagine con estensione.

    private LocalDate publishedAt; // Data di pubblicazione del post.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità User.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private User user; // Riferimento all'utente che ha scritto il post.

    @ManyToMany // Definisce una relazione molti-a-molti con l'entità Tag.
    @JoinTable(name = "post_tags", // Definisce la tabella di join per la relazione molti-a-molti.
            joinColumns = @JoinColumn(name = "post_id"), // Colonna di join per il post.
            inverseJoinColumns = @JoinColumn(name = "tag_id") // Colonna di join per il tag.
    )
    private Set<Tag> tags = new HashSet<>(); // Insieme di tag associati al post.

}
