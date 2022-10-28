package tec.qa.veterinaria.interfaceServices;

import tec.qa.veterinaria.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IClienteService {
    List<Cliente> listar();
    Optional<Cliente> listarId(int cedula);
    int save(Cliente c);
    void delete(int cedula);
}