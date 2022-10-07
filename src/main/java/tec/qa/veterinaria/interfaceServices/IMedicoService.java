package tec.qa.veterinaria.interfaceServices;

import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Medico;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMedicoService {
    List<Medico> listar();
    Optional<Medico> listarId(int id);
    int save(Medico medico);
    void delete(int id);
}