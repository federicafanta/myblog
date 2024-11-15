package it.cgmconsulting.myblog.entity;

import it.cgmconsulting.myblog.entity.common.CreationUpdate;
import it.cgmconsulting.myblog.entity.enumeration.ReportStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class Report extends CreationUpdate { // La classe Report estende CreationUpdate, ereditando i campi createdAt e updatedAt.

    @Id // Indica che questo campo è la chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore del campo id sarà generato automaticamente dal database.
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private int id; // Identificatore univoco del report.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità Comment.
    private Comment comment; // Riferimento al commento segnalato.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità MadeByYou.
    private MadeByYou madeByYou; // Riferimento all'elemento MadeByYou segnalato.

    private int counter; // Contatore di segnalazioni.

    @Enumerated(EnumType.STRING) // Mappa l'enum ReportStatus come una stringa nel database.
    @Column(nullable = false, length = 18) // Configura la colonna per non accettare valori null e impone una lunghezza massima di 18 caratteri.
    private ReportStatus status; // Stato della segnalazione.

    @ManyToOne // Definisce una relazione molti-a-uno con l'entità ReportReason.
    @JoinColumns({ // Specifica le colonne di join per la relazione.
            @JoinColumn(name = "reason"), // Colonna per il motivo della segnalazione.
            @JoinColumn(name = "start_date") // Colonna per la data di inizio della segnalazione.
    })
    private ReportReason reportReason; // Riferimento al motivo della segnalazione.

}
