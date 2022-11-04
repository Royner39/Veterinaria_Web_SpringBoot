package tec.qa.veterinaria.interfaceServices;

import tec.qa.veterinaria.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */

@Repository
public interface IClienteService {
    List<Cliente> listar();
    Optional<Cliente> listarId(int cedula);
    boolean login(int cedula, String password);
    boolean save(Cliente cliente);
    boolean delete(int cedula);
}