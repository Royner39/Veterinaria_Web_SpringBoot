package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IConsultaService;
import tec.qa.veterinaria.interfaces.IConsulta;
import tec.qa.veterinaria.model.Consulta;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Service
public class ConsultaService implements IConsultaService {

    //Inyección de dependencias
    @Autowired
    private IConsulta data;

    /*
    Parametros: N/A
    Retorno: Lista de consultas
    Descripción: Método que retorna una lista de consultas
     */
    @Override
    public List<Consulta> listar() {

        return (List<Consulta>)data.findAll();
    }

    /*
    Parametros: Id de la consulta
    Retorno: Consulta
    Descripción: Método que retorna una consulta
     */
    @Override
    public Optional<Consulta> listarId(int id) {
        return data.findById(id);
    }

    /*
    Parametros: Consulta
    Retorno: Booleano
    Descripción: Método que guarda una consulta
     */
    @Override
    public boolean save(Consulta consulta) {

        try {
            if (consulta != null) {
                Consulta consulta1 = data.save(consulta);
                if (consulta1 != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    Parametros: Id de la consulta
    Retorno: Booleano
    Descripción: Método que elimina una consulta
     */
    @Override
    public boolean delete(int id) {
        try {
            if (data.existsById(id)) {
                data.deleteById(id);
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
