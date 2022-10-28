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

    public List<Mascota> listarByCliente(Cliente cliente) {

        return cliente.getMascotas();
    }

    @Override
    public Optional<Mascota> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Mascota m) {
        int res = 0;
        Mascota mascota = data.save(m);
        if (!mascota.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}