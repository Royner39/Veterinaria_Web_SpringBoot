
package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

import java.util.List;

@SpringBootTest
class ExpedienteServiceTestNegativo extends ExpedienteService {


    @Autowired
    private ExpedienteService expedienteService;
    private Expediente expedientePrueba = new Expediente();
    @BeforeEach
    void setUp() {
        expedientePrueba.setId(1);
        expedienteService.save(expedientePrueba);
    }
    @AfterEach
    void tearDown(){
        expedienteService.delete(expedientePrueba.getId());
    }

    @Test
    void testNegativoListar() {
        List<Expediente> expedientes = expedienteService.listar();
        Assertions.assertNull(expedientes);
    }

    @Test
    void testNegativoListarId() {
        int id = 0;
        List<Expediente> expedientes = expedienteService.listar();
        for (Expediente expediente:expedientes) {
            if (expedientePrueba.getId() == expediente.getId()){
                id = expediente.getId();
            }
        }
        Expediente expediente = expedienteService.listarId(id).get();
        Assertions.assertNull(expediente);
    }

    @Test
    void testNegativoSave() {
        Expediente expediente1 = new Expediente();
        expediente1.setId(2);
        boolean saveSuccess = expedienteService.save(expediente1);
        if (saveSuccess) {
            expedienteService.delete(expediente1.getId());
        }
        Assertions.assertFalse(saveSuccess);
    }

    @Test
    void testNegativoDelete() {
        int id = 0;
        List<Expediente> expedientes = expedienteService.listar();
        for (Expediente expediente:expedientes) {
            if (expedientePrueba.getId() == expediente.getId()){
                id = expediente.getId();
            }
        }
        boolean deleteSuccess = expedienteService.delete(id);
        Assertions.assertFalse(deleteSuccess);
    }

    //REVISAR ESTE testNegativo
    @Test
    void testNegativoListarByMascota() {
        Mascota mascota1 = new Mascota();
        mascota1.setId(2);
        mascota1.setFechaNacimiento("2020-01-01");
        mascota1.setNombre("Mascota1");
        mascota1.setEspecie("Raza1");
        expedientePrueba.setMascota(mascota1);
        Expediente expediente = expedienteService.listarByMascota(mascota1);
        Assertions.assertNull(expediente);
    }
}