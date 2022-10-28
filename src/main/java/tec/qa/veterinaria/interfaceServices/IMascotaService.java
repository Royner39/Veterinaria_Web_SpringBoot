package tec.qa.veterinaria.interfaceServices;


import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMascotaService {
    List<Mascota> listar();
    List<Mascota> listarByCliente(Cliente cliente);
    Optional<Mascota> listarId(int id);
    int save(Mascota mascota);
    void delete(int id);

}