package tec.qa.veterinaria.interfaceServices;

import tec.qa.veterinaria.model.Consulta;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Repository
public interface IConsultaService {
    List<Consulta> listar();
    Optional<Consulta> listarId(int id);
    boolean save(Consulta consulta);
    boolean delete(int id);
}