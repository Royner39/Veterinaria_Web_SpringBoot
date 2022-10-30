package tec.qa.veterinaria.interfaceServices;

import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;

@Repository
public interface IExpedienteService {
    List<Expediente> listar();
    Optional<Expediente> listarId(int id);
    boolean save(Expediente expediente, Mascota mascota);
    boolean delete(int id);
}