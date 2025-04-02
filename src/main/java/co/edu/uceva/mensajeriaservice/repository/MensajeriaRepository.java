package co.edu.uceva.mensajeriaservice.repository;

import co.edu.uceva.mensajeriaservice.model.Mensajeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeriaRepository extends JpaRepository<Mensajeria, Long> {
    //List<Mensajeria> findByIdSemestre(Long idSemestre);
    //List<Mensajeria> findByIdDocente(Long idDocente);
}