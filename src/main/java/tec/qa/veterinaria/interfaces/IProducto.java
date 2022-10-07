package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Producto;

public interface IProducto extends CrudRepository<Producto,Integer> {
}
