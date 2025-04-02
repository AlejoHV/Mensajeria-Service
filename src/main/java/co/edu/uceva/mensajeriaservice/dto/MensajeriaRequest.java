package co.edu.uceva.mensajeriaservice.dto;

import jakarta.validation.constraints.*;

public record MensajeriaRequest(
        @NotBlank String Asunto,
        @NotBlank String correoDestinatario,
        @NotBlank String cuerpoCorreo
) {}