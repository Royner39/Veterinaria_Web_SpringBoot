package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Consulta;

public interface IConsulta extends CrudRepository<Consulta,Integer> {
}
