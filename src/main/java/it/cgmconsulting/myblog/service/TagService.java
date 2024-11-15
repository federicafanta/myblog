package it.cgmconsulting.myblog.service;

import it.cgmconsulting.myblog.entity.Tag;
import it.cgmconsulting.myblog.exception.ConflictException;
import it.cgmconsulting.myblog.exception.ResourceNotFoundException;
import it.cgmconsulting.myblog.payload.response.TagResponse;
import it.cgmconsulting.myblog.repository.TagRepository;
import it.cgmconsulting.myblog.utils.Msg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service // Indica che questa classe è un servizio e sarà gestita dal contenitore di Spring.
@RequiredArgsConstructor // Genera un costruttore con un argomento per ogni campo finale, facilitando l'iniezione delle dipendenze.
public class TagService {

    private final TagRepository tagRepository; // Iniezione del repository TagRepository.

    public Tag create(String id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isEmpty()) {
            return tagRepository.save(new Tag(id)); // Se il tag non esiste, lo salva nel database.
        }
        throw new ConflictException(Msg.TAG_ALREADY_PRESENT); // Se il tag esiste già, lancia un'eccezione di conflitto.
    }

    public Tag switchVisibility(String id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id)); // Se il tag non esiste, lancia un'eccezione di risorsa non trovata.
        tag.setVisible(!tag.isVisible()); // Cambia la visibilità del tag.
        return tagRepository.save(tag); // Salva il tag aggiornato nel database.
    }

    public List<TagResponse> getTags() {
        return tagRepository.getAll(); // Restituisce una lista di tutti i tag.
    }
}
