package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.interfaces.ICliente;
import tec.qa.veterinaria.model.Cliente;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Service
public class ClienteService implements IClienteService {

    //Inyección de dependencias
    @Autowired
    private ICliente data;

    /*
    Parametros: N/A
    Retorno: Lista de clientes
    Descripción: Método que retorna una lista de todos los clientes
    */
    @Override
    public List<Cliente> listar() {
        return (List<Cliente>)data.findAll();
    }

    /*
    Parametros: Cedula
    Retorno: Cliente
    Descripción: Método que retorna un cliente específico
     */
    @Override
    public Optional<Cliente> listarId(int cedula) {
        return data.findById(cedula);
    }

    /*
    Parametros: Cedula, Password
    Retorno: Un booleano
    Descripción: Método que verifica si el cliente existe y lo logea
     */
    @Override
    public boolean login(int cedula, String password) {
        try {
            if (data.existsById(cedula)) {
                Optional<Cliente> cliente = data.findById(cedula);
                if (cliente.isPresent()){
                    if (cliente.get().getCedula() == cedula && cliente.get().getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    Parametros: Cliente
    Retorno: Un booleano
    Descripción: Método que guarda un cliente
     */
    @Override
    public boolean save(Cliente cliente) {

        try {
            if (cliente != null) {
                Cliente cliente1 = data.save(cliente);
                if (cliente1 != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    Parametros: Cedula
    Retorno: Un booleano
    Descripción: Método que elimina un cliente
     */
    @Override
    public boolean delete(int cedula) {
        try {
            if (data.existsById(cedula)) {
                data.deleteById(cedula);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
