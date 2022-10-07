package tec.qa.veterinaria.interfaces;

import org.springframework.data.repository.CrudRepository;
import tec.qa.veterinaria.model.Mascota;

public interface IMascota extends CrudRepository<Mascota,Integer> {
}
