package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IFacturacionService;
import tec.qa.veterinaria.model.Facturacion;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService implements IFacturacionService {
    @Override
    public List<Facturacion> listar() {
        return null;
    }

    @Override
    public Optional<Facturacion> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Facturacion factura) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
