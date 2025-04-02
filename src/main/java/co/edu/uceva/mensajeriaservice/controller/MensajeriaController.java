package co.edu.uceva.mensajeriaservice.controller;

import co.edu.uceva.mensajeriaservice.dto.MensajeriaRequest;
import co.edu.uceva.mensajeriaservice.service.MensajeriaService;
import co.edu.uceva.mensajeriaservice.dto.MensajeriaResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@RequiredArgsConstructor
@Tag(name = "Controlador de mensajes", description = "API para la gestión de los mensajes")
public class MensajeriaController {

    private final MensajeriaService mensajeriaService;

    @PostMapping
    public ResponseEntity<MensajeriaResponse> crearMensaje(
            @Valid @RequestBody MensajeriaRequest mensajeriaRequest) {
        MensajeriaResponse response = mensajeriaService.crearMensaje(mensajeriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MensajeriaResponse>> listarTodosLosMensajes() {
        List<MensajeriaResponse> mensajes = mensajeriaService.listarMensajes();
        return ResponseEntity.ok(mensajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeriaResponse> obtenerMensajePorId(
            @Parameter(description = "ID del mensaje a buscar")
            @PathVariable Long id) {
        MensajeriaResponse response = mensajeriaService.obtenerMensaje(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensajeriaResponse> actualizarMensaje(
            @Parameter(description = "ID del mensaje a actualizar")
            @PathVariable Long id,
            @Valid @RequestBody MensajeriaRequest mensajeriaRequest) {
        MensajeriaResponse response = mensajeriaService.actualizarMensaje(id, mensajeriaRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(
            @Parameter(description = "ID del mensaje a eliminar")
            @PathVariable Long id) {
        mensajeriaService.eliminarMensaje(id);
        return ResponseEntity.noContent().build();
    }
}