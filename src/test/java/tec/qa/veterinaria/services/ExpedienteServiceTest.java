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

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class ExpedienteServiceTest extends ExpedienteService {


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
    void testListar() {
        List<Expediente> expedientes = expedienteService.listar();
        Assertions.assertNotNull(expedientes);
    }

    @Test
    void testListarId() {
        int id = 0;
        List<Expediente> expedientes = expedienteService.listar();
        for (Expediente expediente:expedientes) {
            if (expedientePrueba.getId() == expediente.getId()){
                id = expediente.getId();
            }
        }
        Expediente expediente = expedienteService.listarId(id).get();
        Assertions.assertNotNull(expediente);
    }

    @Test
    void testSave() {
        Expediente expediente1 = new Expediente();
        expediente1.setId(2);
        boolean saveSuccess = expedienteService.save(expediente1);
        if (saveSuccess) {
            expedienteService.delete(expediente1.getId());
        }
        Assertions.assertTrue(saveSuccess);
    }

    @Test
    void testDelete() {
        int id = 0;
        List<Expediente> expedientes = expedienteService.listar();
        for (Expediente expediente:expedientes) {
            if (expedientePrueba.getId() == expediente.getId()){
                id = expediente.getId();
            }
        }
        boolean deleteSuccess = expedienteService.delete(id);
        Assertions.assertTrue(deleteSuccess);
    }

    //REVISAR ESTE TEST
    @Test
    void testListarByMascota() {
        Mascota mascota1 = new Mascota();
        mascota1.setId(2);
        mascota1.setFechaNacimiento("2020-01-01");
        mascota1.setNombre("Mascota1");
        mascota1.setEspecie("Raza1");
        expedientePrueba.setMascota(mascota1);
        Expediente expediente = expedienteService.listarByMascota(mascota1);
        Assertions.assertNotNull(expediente);
    }
}