package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Cliente;

public interface ICliente extends CrudRepository<Cliente,Integer> {
}
