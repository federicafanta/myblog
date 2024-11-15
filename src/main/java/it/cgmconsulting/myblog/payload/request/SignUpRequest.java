package it.cgmconsulting.myblog.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignUpRequest(

        @NotBlank(message = "Username cannot be null or blank") // Verifica che il campo username non sia nullo o vuoto.
        @Size(max = 20, min = 3, message = "Username must be between 3 and 20 characters") // Verifica che il campo username sia compreso tra 3 e 20 caratteri.
        String username,

        @NotBlank(message = "Email cannot be null or blank") // Verifica che il campo email non sia nullo o vuoto.
        @Email(message = "Email not well-formed") // Verifica che il campo email abbia un formato valido.
        String email,

        @NotBlank(message = "Password cannot be null or blank") // Verifica che il campo password non sia nullo o vuoto.
        @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters") // Verifica che il campo password sia compreso tra 8 e 16 caratteri.
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$£%^&+=!]).*$",
                message = "Password must contain at least one digit, one lowercase, one uppercase letter and one special character") // Verifica che la password contenga almeno una cifra, una lettera minuscola, una lettera maiuscola e un carattere speciale.
        String password
) {
}
