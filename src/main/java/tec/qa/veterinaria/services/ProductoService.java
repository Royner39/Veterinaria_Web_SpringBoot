package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.interfaceServices.IProductoService;
import tec.qa.veterinaria.interfaces.IMascota;
import tec.qa.veterinaria.interfaces.IProducto;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;
import tec.qa.veterinaria.model.Medico;
import tec.qa.veterinaria.model.Producto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProducto data;

    @Override
    public List<Producto> listar() {

        return (List<Producto>)data.findAll();
    }

    @Override
    public Optional<Producto> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public boolean save(Producto p) {

        Producto producto = data.save(p);
        if (!producto.equals(null)){
            return true;
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        if (data.existsById(id)) {
            data.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}