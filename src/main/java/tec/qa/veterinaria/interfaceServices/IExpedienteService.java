package tec.qa.veterinaria.interfaceServices;

import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Expediente;

import java.util.List;
import java.util.Optional;

@Repository
public interface IExpedienteService {
    List<Expediente> listar();
    Optional<Expediente> listarId(int id);
    int save(Expediente expediente);
    void delete(int id);
}