package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IExpedienteService;
import tec.qa.veterinaria.interfaces.IExpediente;
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Service
public class ExpedienteService implements IExpedienteService {

    //Inyección de dependencias
    @Autowired
    private IExpediente data;

    /*
    Parametros: N/A
    Retorno: Lista de expedientes
    Descripción: Método que retorna una lista de expedientes
     */
    @Override
    public List<Expediente> listar() {
        return (List<Expediente>)data.findAll();
    }

    /*
    Parametros: Mascota
    Retorno: Expediente de una mascota
    Descripción: Método que lista el expediente de una mascota
     */
    @Override
    public Expediente listarByMascota(Mascota mascota) {
        return mascota.getExpediente();
    }

    /*
    Parametros: Id de un expediente
    Retorno: Expediente
    Descripción: Método que retorna un expediente por medio de su id
     */
    @Override
    public Optional<Expediente> listarId(int id) {
        return data.findById(id);
    }

    /*
    Parametros: Expediente
    Retorno: Booleano
    Descripción: Método que guarda un expediente
     */
    @Override
    public boolean save(Expediente expediente) {
        try {
                if (expediente != null) {
                    data.save(expediente);

                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;

    }

    /*
    Parametros: Id de un expediente
    Retorno: Booleano
    Descripción: Método que elimina un expediente por medio de su id
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
