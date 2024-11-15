package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
@Table(name = "_user") // Specifica il nome della tabella nel database a cui questa entità verrà mappata.
public class User extends CreationUpdate { // La classe User estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore del campo id sarà generato automaticamente dal database.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private int id; // Identificatore univoco dell'utente.

    @Column(unique = true, nullable = false) // Configura la colonna per essere unica e non accettare valori null.
    private String email; // Email dell'utente.

    @Column(unique = true, nullable = false, length = 20) // Configura la colonna per essere unica, non accettare valori null e avere una lunghezza massima di 20 caratteri.
    private String username; // Nome utente dell'utente.

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private String password; // Password dell'utente.

    private boolean enabled = false; // Indica se l'utente è abilitato. Di default è false.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità Authority.
    @JoinColumn(nullable = false) // Specifica la colonna di join per la relazione molti-a-uno. La colonna non può essere nulla.
    private Authority authority; // Riferimento all'autorità dell'utente.

    @OneToOne(mappedBy = "user") // Definisce una relazione uno-a-uno con l'entità Avatar. Il campo mappedBy indica che la relazione è mappata dall'altra parte.
    private Avatar avatar; // Riferimento all'avatar dell'utente.

    private String confirmCode; // Codice di conferma per l'utente.

    @ManyToMany // Definisce una relazione molti-a-molti con l'entità Post.
    @JoinTable(name = "preferred_posts", // Definisce la tabella di join per la relazione molti-a-molti.
            joinColumns = @JoinColumn(name = "user_id"), // Colonna di join per l'utente.
            inverseJoinColumns = @JoinColumn(name = "post_id") // Colonna di join per il post.
    )
    private Set<Post> preferredPosts = new HashSet<>(); // Insieme di post preferiti dall'utente.

}
