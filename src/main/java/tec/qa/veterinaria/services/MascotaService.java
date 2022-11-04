package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IMascotaService;
import tec.qa.veterinaria.interfaces.IMascota;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Service
public class MascotaService implements IMascotaService {

    //Inyección de dependencias
    @Autowired
    private IMascota data;

    /*
    Parametros: N/A
    Retorno: Lista de mascotas
    Descripción: Método que retorna una lista de mascotas
     */
    @Override
    public List<Mascota> listar() {

        return (List<Mascota>)data.findAll();
    }

    /*
    Parametros: Cliente
    Retorno: Mascota
    Descripción: Método que retorna una lista de mascotas de un cliente
     */
    @Override
    public List<Mascota> listarByCliente(Cliente cliente) {
        return cliente.getMascotas();
    }

    /*
    Parametros: Id de la mascota
    Retorno: Mascota
    Descripción: Método que retorna una mascota por su id
     */
    @Override
    public Optional<Mascota> listarId(int id) {
        return data.findById(id);
    }

    /*
    Parametros: Mascota
    Retorno: Booleano
    Descripción: Método que actualiza una mascota
     */
    @Override
    public boolean update(Mascota m) {
        try {
            if (m != null) {
                Optional<Mascota> mascota = data.findById(m.getId());
                if (mascota.isPresent()) {
                    mascota.get().setNombre(m.getNombre());
                    mascota.get().setEspecie(m.getEspecie());
                    mascota.get().setSexo(m.getSexo());
                    mascota.get().setFechaNacimiento(m.getFechaNacimiento());
                    data.save(mascota.get());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    Parametros: Mascota
    Retorno: Booleano
    Descripción: Método que guarda una mascota
     */
    @Override
    public boolean save(Mascota mascota) {
        try {
            if (mascota != null) {
                data.save(mascota);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /*
    Parametros: Id de la mascota
    Retorno: Booleano
    Descripción: Método que elimina una mascota
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