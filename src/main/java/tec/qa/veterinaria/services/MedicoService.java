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
