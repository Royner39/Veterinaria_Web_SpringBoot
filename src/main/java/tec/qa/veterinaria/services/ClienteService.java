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
    public boolean login(int cedula, String password) {
        if (data.existsById(cedula)) {
            Optional<Cliente> cliente = data.findById(cedula);
            if (cliente.get().getCedula() == cedula && cliente.get().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean save(Cliente c) {

        Cliente cliente = data.save(c);
        if (!cliente.equals(null)){
            return true;
        }
        return false;
    }


    @Override
    public boolean delete(int cedula) {
        if (data.existsById(cedula)) {
            data.deleteById(cedula);
            return true;
        } else {
            return false;
        }

    }
}
