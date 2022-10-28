package tec.qa.veterinaria.interfaceServices;

import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoService {
    List<Producto> listar();
        Optional<Producto> listarId(int id);
        int save(Producto producto);
        void delete(int id);
}