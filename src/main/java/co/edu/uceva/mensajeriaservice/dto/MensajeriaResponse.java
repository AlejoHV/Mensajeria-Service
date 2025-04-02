package co.edu.uceva.mensajeriaservice.dto;

import java.time.LocalDate;

public record MensajeriaResponse(
        Long id,
        String Asunto,
        String correoDestinatario,
        String cuerpoCorreo,
        LocalDate fechaEnvio
) {}