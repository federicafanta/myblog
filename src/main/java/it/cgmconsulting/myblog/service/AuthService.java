package it.cgmconsulting.myblog.service;

import it.cgmconsulting.myblog.entity.Authority;
import it.cgmconsulting.myblog.entity.User;
import it.cgmconsulting.myblog.entity.enumeration.AuthorityName;
import it.cgmconsulting.myblog.exception.ConflictException;
import it.cgmconsulting.myblog.exception.ResourceNotFoundException;
import it.cgmconsulting.myblog.payload.request.SignUpRequest;
import it.cgmconsulting.myblog.repository.AuthorityRepository;
import it.cgmconsulting.myblog.repository.UserRepository;
import it.cgmconsulting.myblog.utils.GenericMail;
import it.cgmconsulting.myblog.utils.Msg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // Indica che questa classe è un servizio Spring, quindi gestisce la logica di business dell'applicazione.
@RequiredArgsConstructor // Genera un costruttore con argomenti per tutti i campi finali, facilitando l'iniezione delle dipendenze.
public class AuthService {

    private final UserRepository userRepository; // Iniezione del repository degli utenti tramite costruttore.
    private final AuthorityRepository authorityRepository; // Iniezione del repository delle autorità tramite costruttore.
    private final EmailService emailService; // Iniezione del servizio email tramite costruttore.

    public String signup(SignUpRequest request) {
        // Controlla se un utente con lo stesso username o email esiste già.
        if (userRepository.existsByUsernameOrEmail(request.username(), request.email())) {
            throw new ConflictException(Msg.USER_ALREADY_PRESENT); // Lancia un'eccezione se l'utente esiste già.
        }

        // Trova l'autorità di default che è visibile.
        Authority authority = authorityRepository.findByDefaultAuthorityTrueAndVisibleTrue()
                .orElseThrow(() -> new ResourceNotFoundException("Authority", "defaultAuthority", true));

        // Crea un nuovo utente con i dettagli forniti e un codice di conferma univoco.
        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(request.password())
                .enabled(false)
                .authority(authority)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        userRepository.save(user); // Salva il nuovo utente nel database.

        // Prepara e invia un'email di verifica all'utente.
        GenericMail mail = new GenericMail(Msg.MAIL_SIGNUP_SUBJECT, Msg.MAIL_SIGNUP_BODY.concat(user.getConfirmCode()), user.getEmail());
        emailService.sendVerificationMail(mail);

        return Msg.USER_SIGNUP_FIRST_STEP; // Ritorna un messaggio di conferma.
    }

    public String verifyEmail(String confirmCode) {
        // Ricerca l'utente tramite il codice di conferma.
        User user = userRepository.findByConfirmCode(confirmCode)
                .orElseThrow(() -> new ResourceNotFoundException("User", "confirm code", confirmCode));

        // Abilita l'utente, imposta il ruolo a MEMBER, e resetta il codice di conferma.
        user.setEnabled(true);
        user.setConfirmCode(null);
        user.setAuthority(authorityRepository.findByAuthorityNameAndVisibleTrue(AuthorityName.MEMBER)
                .orElseThrow(() -> new ResourceNotFoundException("Authority", "name", AuthorityName.MEMBER.name())));

        userRepository.save(user); // Salva le modifiche dell'utente nel database.

        return Msg.USER_SIGNUP_SECOND_STEP; // Ritorna un messaggio di conferma.
    }
}
