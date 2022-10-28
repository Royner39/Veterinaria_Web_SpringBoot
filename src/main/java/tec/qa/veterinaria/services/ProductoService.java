package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IProductoService;
import tec.qa.veterinaria.model.Producto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    @Override
    public List<Producto> listar() {
        return null;
    }

    @Override
    public Optional<Producto> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Producto producto) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
