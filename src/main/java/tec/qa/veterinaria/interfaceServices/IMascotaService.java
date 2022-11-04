package tec.qa.veterinaria.interfaceServices;


import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Repository
public interface IMascotaService {
    List<Mascota> listar();
    List<Mascota> listarByCliente(Cliente cliente);
    Optional<Mascota> listarId(int id);
    boolean update(Mascota mascota);
    boolean save(Mascota mascota);
    boolean delete(int id);

}