package it.cgmconsulting.myblog.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity // Indica che questa classe è un'entità JPA e sarà mappata a una tabella del database.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Genera automaticamente i metodi equals() e hashCode() considerando solo i campi esplicitamente inclusi.
public class ReportReason {

    @EmbeddedId // Indica che questo campo è una chiave primaria composta (embedded id).
    @EqualsAndHashCode.Include // Include questo campo nel calcolo dei metodi equals() e hashCode().
    private ReportReasonId reportReasonId; // Identificatore composto dell'entità ReportReason.

    private LocalDate endDate; // Data di fine validità del motivo di segnalazione.

    private int severity; // Gravità del motivo di segnalazione.

}
