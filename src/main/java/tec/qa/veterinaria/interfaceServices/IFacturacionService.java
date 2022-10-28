package tec.qa.veterinaria.interfaceServices;

import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Facturacion;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFacturacionService {
    List<Facturacion> listar();
        Optional<Facturacion> listarId(int id);
        int save(Facturacion factura);
        void delete(int id);
}