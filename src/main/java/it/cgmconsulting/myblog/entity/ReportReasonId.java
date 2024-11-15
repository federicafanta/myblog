package it.cgmconsulting.myblog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable // Indica che questa classe può essere incorporata in altre entità come una chiave primaria composta.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
@EqualsAndHashCode // Genera automaticamente i metodi equals() e hashCode() considerando tutti i campi della classe.
@Builder // Aggiunge un pattern Builder alla classe, facilitando la costruzione di oggetti.
public class ReportReasonId implements Serializable { // Implementa Serializable per consentire la serializzazione degli oggetti di questa classe.

    @Column(nullable = false, length = 30) // Configura la colonna per non accettare valori null e impone una lunghezza massima di 30 caratteri.
    private String reason; // Motivo della segnalazione.

    @Column(nullable = false) // Configura la colonna per non accettare valori null.
    private LocalDate startDate; // Data di inizio validità del motivo della segnalazione.

}
