package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IMedicoService;
import tec.qa.veterinaria.interfaces.IMedico;
import tec.qa.veterinaria.model.Medico;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Service
public class MedicoService implements IMedicoService {

    //Inyección de dependencias
    @Autowired
    private IMedico data;

    /*
    Parametros: N/A
    Retorno: Lista de medicos
    Descripción: Retorna una lista de todos los medicos
     */
    @Override
    public List<Medico> listar() {
        return (List<Medico>)data.findAll();
    }

    /*
    Parametros: Id del medico
    Retorno: Medico
    Descripción: Retorna un medico con el id especificado
     */
    @Override
    public Optional<Medico> listarId(int id) {
        return data.findById(id);
    }

    /*
    Parametros: Id del medico, Password del medico
    Retorno: Booleano
    Descripción: Retorna true si el medico existe y la contraseña es correcta
     */
    @Override
    public boolean login(int id, String password) {
        try {
            if (data.existsById(id)) {
                Optional<Medico> medico = data.findById(id);
                if (medico.isPresent()) {
                    if (medico.get().getId() == id && medico.get().getPassword().equals(password)) {
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
    Parametros: Medico
    Retorno: Booleano
    Descripción: Guarda un medico en la base de datos
     */
    @Override
    public boolean save(Medico m) {

        try {
            if (m != null) {
                if (data.existsById(m.getId())) {
                    return false;
                } else {
                    Medico medico = data.save(m);
                    if (medico != null){
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
    Parametros: Id del medico
    Retorno: Booleano
    Descripción: Elimina un medico de la base de datos
     */
    @Override
    public boolean delete(int id) {
        try {
            if (data.existsById(id)) {
                data.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
