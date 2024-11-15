package it.cgmconsulting.myblog.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass // Indica che questa classe non sarà mappata come una tabella del database, ma le sue proprietà saranno ereditate dalle sottoclassi.
@Getter @Setter // Genera automaticamente i metodi getter e setter per tutti i campi della classe grazie a Lombok.
public class CreationUpdate implements Serializable { // Implementa Serializable per consentire la serializzazione degli oggetti di questa classe.

    @CreationTimestamp // Annota il campo per assegnargli automaticamente il timestamp di creazione quando l'entità viene salvata per la prima volta.
    @Column(updatable = false) // Indica che questo campo non può essere aggiornato dopo la creazione iniziale.
    private LocalDateTime createdAt; // Campo che memorizza il timestamp di creazione dell'entità.

    @UpdateTimestamp // Annota il campo per assegnargli automaticamente il timestamp di aggiornamento ogni volta che l'entità viene aggiornata.
    private LocalDateTime updatedAt; // Campo che memorizza il timestamp dell'ultimo aggiornamento dell'entità.
}
