package co.edu.uceva.mensajeriaservice.repository;

import co.edu.uceva.mensajeriaservice.model.Mensajeria;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.Optional;

public interface MensajeriaRepository extends JpaRepository<Mensajeria, Long> {
    //List<Mensajeria> findMensajeriaById(Long id);
    //Optional<Mensajeria> findById(Long id);
}