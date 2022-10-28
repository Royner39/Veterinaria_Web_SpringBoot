package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Facturacion;

public interface IFacturacion extends CrudRepository<Facturacion,Integer> {
}
