package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IMascotaService;
import tec.qa.veterinaria.interfaces.IMascota;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascota data;

    @Override
    public List<Mascota> listar() {

        return (List<Mascota>)data.findAll();
    }
    @Override
    public List<Mascota> listarByCliente(Cliente cliente) {

        return cliente.getMascotas();
    }

    @Override
    public Optional<Mascota> listarId(int id) {
        return data.findById(id);
    }

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

    @Override
    public boolean save(Mascota m, Cliente c) {
        try {
            if (c != null) {
                Mascota mascota = data.save(m);

                if (mascota != null){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

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