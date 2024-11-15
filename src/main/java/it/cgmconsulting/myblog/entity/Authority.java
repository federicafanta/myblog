package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import it.cgmconsulting.myblog.entity.enumeration.AuthorityName;
import jakarta.persistence.*;
import lombok.*;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class Authority extends CreationUpdate { // La classe Authority estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore del campo id sarà generato automaticamente dal database.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private byte id; // Identificatore univoco dell'autorità.

    @Enumerated(EnumType.STRING) // Mappa l'enum AuthorityName come una stringa nel database.
    @Column(unique = true, length = 9, nullable = false) // Configura la colonna per essere unica, con una lunghezza massima di 9 caratteri e non nullable.
    private AuthorityName authorityName; // Nome dell'autorità come valore enum.

    private boolean defaultAuthority; // Campo booleano per indicare se questa è un'autorità di default.

    private boolean visible = true; // Campo booleano per indicare se l'autorità è visibile. Di default è true.

}
