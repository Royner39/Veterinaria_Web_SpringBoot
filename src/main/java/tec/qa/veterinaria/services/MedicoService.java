package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IMedicoService;
import tec.qa.veterinaria.model.Medico;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements IMedicoService {
    @Override
    public List<Medico> listar() {
        return null;
    }

    @Override
    public Optional<Medico> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Medico medico) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
