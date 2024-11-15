package it.cgmconsulting.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // Indica che questa è una classe di configurazione principale di Spring Boot e abilita le funzionalità di auto-configurazione, component scanning, e configurazione delle proprietà di Spring Boot.
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args); // Metodo principale che avvia l'applicazione Spring Boot.
	}

}
