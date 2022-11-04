package tec.qa.veterinaria.interfaceServices;

import org.springframework.stereotype.Repository;
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Repository
public interface IExpedienteService {
    List<Expediente> listar();
    Optional<Expediente> listarId(int id);
    Expediente listarByMascota(Mascota mascota);
    boolean save(Expediente expediente);
    boolean delete(int id);
}