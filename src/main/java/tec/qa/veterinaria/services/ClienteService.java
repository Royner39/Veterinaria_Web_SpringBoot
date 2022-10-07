package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.model.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public Optional<Cliente> listarId(int cedula) {
        return Optional.empty();
    }

    @Override
    public int save(Cliente c) {
        return 0;
    }

    @Override
    public void delete(int cedula) {

    }
}
