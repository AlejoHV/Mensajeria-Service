package co.edu.uceva.mensajeriaservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mensajes")
public class Mensajeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Asunto;

    @Column(nullable = false)
    private String correoDestinatario;

    @Column(nullable = false)
    private String cuerpoCorreo;

    @Column(nullable = false, updatable = false)
    private LocalDate fechaEnvio = LocalDate.now();
}
