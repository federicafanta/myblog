package it.cgmconsulting.myblog.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automaticamente i metodi getter, setter, toString, equals e hashCode grazie a Lombok.
@AllArgsConstructor // Genera automaticamente un costruttore con un argomento per ogni campo della classe.
@NoArgsConstructor // Genera automaticamente un costruttore senza argomenti.
public class TagResponse {

    private String id; // Identificatore del tag.

    private boolean visible; // Indica se il tag è visibile.
}
