package it.cgmconsulting.myblog; //Questo indica che il file MyblogApplication.java appartiene
// al package it.cgmconsulting.myblog. I package in Java sono usati
// per organizzare le classi in gruppi logici.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //Questa annotazione indica che la classe MyblogApplication è l'entry point
// della tua applicazione Spring Boot. Combina tre annotazioni:
// @EnableAutoConfiguration: Abilita la configurazione automatica di Spring Boot.
// @ComponentScan: Scansiona i package per trovare componenti, configurazioni e servizi Spring.
// @Configuration: Permette di registrare bean in Spring context.
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

} //Questo è il metodo principale che avvia la tua applicazione Spring Boot.
// SpringApplication.run avvia il contesto dell'applicazione,
// che a sua volta avvia l'intera applicazione Spring Boot.
