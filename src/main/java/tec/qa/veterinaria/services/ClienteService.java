package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.interfaces.ICliente;
import tec.qa.veterinaria.model.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ICliente data;

    @Override
    public List<Cliente> listar() {
        return (List<Cliente>)data.findAll();
    }

    @Override
    public Optional<Cliente> listarId(int cedula) {
        return data.findById(cedula);
    }

    @Override
    public int save(Cliente c) {
        int res = 0;
        Cliente cliente = data.save(c);
        if (!cliente.equals(null)){
            res=1;
        }
        return res;
    }


    @Override
    public void delete(int cedula) {
        data.deleteById(cedula);
    }
}
