package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IConsultaService;
import tec.qa.veterinaria.model.Consulta;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {
    @Override
    public List<Consulta> listar() {
        return null;
    }

    @Override
    public Optional<Consulta> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Consulta consulta) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
