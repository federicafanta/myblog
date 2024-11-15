package it.cgmconsulting.myblog.service;

import it.cgmconsulting.myblog.utils.GenericMail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service // Indica che questa classe è un servizio e sarà gestita dal contenitore di Spring.
@Slf4j // Aggiunge un logger alla classe grazie a Lombok.
@RequiredArgsConstructor // Genera un costruttore con un argomento per ogni campo finale, facilitando l'iniezione delle dipendenze.
public class EmailService {

    private final JavaMailSender javaMailSender; // Iniezione del bean JavaMailSender per l'invio delle email.

    @Async // Indica che questo metodo deve essere eseguito in modo asincrono.
    public void sendVerificationMail(GenericMail mail) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(); // Creazione di un oggetto SimpleMailMessage per configurare l'email.
        simpleMailMessage.setSubject(mail.getSubject()); // Imposta l'oggetto dell'email.
        simpleMailMessage.setText(mail.getBody()); // Imposta il corpo dell'email.
        simpleMailMessage.setTo(mail.getTo()); // Imposta il destinatario dell'email.

        javaMailSender.send(simpleMailMessage); // Invia l'email utilizzando il bean JavaMailSender.
    }
}
