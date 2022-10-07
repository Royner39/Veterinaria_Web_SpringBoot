package tec.qa.veterinaria.services;

import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IMascotaService;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {
    @Override
    public List<Mascota> listar() {
        return null;
    }

    @Override
    public Optional<Mascota> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Mascota mascota) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
