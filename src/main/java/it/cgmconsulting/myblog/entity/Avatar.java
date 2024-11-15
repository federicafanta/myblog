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
public class Avatar extends CreationUpdate { // La classe Avatar estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private int id; // Identificatore univoco dell'avatar.

    @OneToOne // Definisce una relazione uno-a-uno con l'entità User.
    @MapsId // Specifica che l'ID di questa entità è anche l'ID dell'entità User collegata.
    @JoinColumn(name = "id") // Definisce la colonna di join per la relazione uno-a-uno.
    private User user; // Riferimento all'entità User.

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private String filename; // Nome del file dell'avatar.

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private String filetype; // Tipo MIME del file.

    @Lob // Indica che questo campo è un Large Object (BLOB - Binary Large Object).
    @Column(nullable = false, columnDefinition = "BLOB") // Configura la colonna per non accettare valori null e specifica il tipo di colonna come BLOB.
    private byte[] data; // Dati binari dell'avatar.

}
