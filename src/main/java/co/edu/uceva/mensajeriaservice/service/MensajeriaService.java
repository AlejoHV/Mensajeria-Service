package co.edu.uceva.mensajeriaservice.service;

import co.edu.uceva.mensajeriaservice.dto.MensajeriaRequest;
import co.edu.uceva.mensajeriaservice.dto.MensajeriaResponse;
import co.edu.uceva.mensajeriaservice.exception.ResourceNotFoundException;
import co.edu.uceva.mensajeriaservice.model.Mensajeria;
import co.edu.uceva.mensajeriaservice.repository.MensajeriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MensajeriaService {

    private final MensajeriaRepository mensajeriaRepository;

    @Transactional
    public MensajeriaResponse crearMensaje(MensajeriaRequest request) {
        validarDatosMensaje(request);

        Mensajeria mensaje = new Mensajeria();
        mensaje.setAsunto(request.Asunto());
        mensaje.setCorreoDestinatario(request.correoDestinatario());
        mensaje.setCuerpoCorreo(request.cuerpoCorreo());
        mensaje.setFechaEnvio(LocalDate.now());

        mensaje = mensajeriaRepository.save(mensaje);
        return mapToResponse(mensaje);
    }

    @Transactional(readOnly = true)
    public List<MensajeriaResponse> listarMensajes() {
        return mensajeriaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MensajeriaResponse obtenerMensaje(Long id) {
        Mensajeria mensaje = mensajeriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mensaje no encontrado con ID: " + id));
        return mapToResponse(mensaje);
    }

    @Transactional
    public MensajeriaResponse actualizarMensaje(Long id, MensajeriaRequest request) {
        validarDatosMensaje(request);

        Mensajeria mensaje = mensajeriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mensaje no encontrado con ID: " + id));

        mensaje.setAsunto(request.Asunto());
        mensaje.setCorreoDestinatario(request.correoDestinatario());
        mensaje.setCuerpoCorreo(request.cuerpoCorreo());

        mensaje = mensajeriaRepository.save(mensaje);
        return mapToResponse(mensaje);
    }

    @Transactional
    public void eliminarMensaje(Long id) {
        if (!mensajeriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Mensaje no encontrado con ID: " + id);
        }
        mensajeriaRepository.deleteById(id);
    }

    private MensajeriaResponse mapToResponse(Mensajeria mensajeria) {
        return new MensajeriaResponse(
                mensajeria.getId(),
                mensajeria.getAsunto(),
                mensajeria.getCorreoDestinatario(),
                mensajeria.getCuerpoCorreo(),
                mensajeria.getFechaEnvio()
        );
    }

    private void validarDatosMensaje(MensajeriaRequest request) {
    }
}
