package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Expediente;

public interface IExpediente extends CrudRepository<Expediente,Integer> {
}
