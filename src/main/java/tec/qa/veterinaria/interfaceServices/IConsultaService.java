package tec.qa.veterinaria.interfaceServices;

import tec.qa.veterinaria.model.Consulta;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IConsultaService {
    List<Consulta> listar();
    Optional<Consulta> listarId(int id);
    int save(Consulta consulta);
    void delete(int id);
}