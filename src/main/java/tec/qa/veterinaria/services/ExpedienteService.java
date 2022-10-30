package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IExpedienteService;
import tec.qa.veterinaria.interfaces.IExpediente;
import tec.qa.veterinaria.interfaces.IMascota;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;

@Service
public class ExpedienteService implements IExpedienteService {
    @Autowired
    private IExpediente data;

    @Override
    public List<Expediente> listar() {

        return (List<Expediente>)data.findAll();
    }

    @Override
    public Optional<Expediente> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public boolean save(Expediente expediente, Mascota mascota) {
        try {
            if (mascota != null) {
                mascota.setExpediente(expediente);
                expediente.setMascota(mascota);
                Expediente expediente1 = data.save(expediente);
                if (expediente1 != null){
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
