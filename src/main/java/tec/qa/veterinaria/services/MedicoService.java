package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IMedicoService;
import tec.qa.veterinaria.interfaces.IMedico;
import tec.qa.veterinaria.model.Medico;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedico data;

    @Override
    public List<Medico> listar() {
        return (List<Medico>)data.findAll();
    }

    @Override
    public Optional<Medico> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public boolean login(int id, String password) {
        if (data.existsById(id)) {
            Optional<Medico> medico = data.findById(id);
            if (medico.get().getId() == id && medico.get().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean save(Medico m) {

        Medico medico = data.save(m);
        if (!medico.equals(null)){
            return true;
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        if (data.existsById(id)) {
            data.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
