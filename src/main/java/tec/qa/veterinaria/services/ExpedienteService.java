package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IExpedienteService;
import tec.qa.veterinaria.model.Expediente;

import java.util.List;
import java.util.Optional;

@Service
public class ExpedienteService implements IExpedienteService {
    @Override
    public List<Expediente> listar() {
        return null;
    }

    @Override
    public Optional<Expediente> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Expediente expediente) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
