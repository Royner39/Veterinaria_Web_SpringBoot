package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Medico;

public interface IMedico extends CrudRepository<Medico,Integer> {
}
