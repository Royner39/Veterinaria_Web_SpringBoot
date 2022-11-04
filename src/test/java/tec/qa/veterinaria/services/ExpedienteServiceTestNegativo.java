
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
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class ExpedienteServiceTestNegativo extends ExpedienteService {

    //Prueba la clase de Expediente
    @Autowired
    private ExpedienteService expedienteService;
    private Expediente expedientePrueba = new Expediente();

    //Se ejecuta antes de cada prueba para crear un expediente
    @BeforeEach
    void setUp() {
        expedientePrueba.setId(1);
        expedienteService.save(expedientePrueba);
    }

    //Se ejecuta después de cada prueba para eliminar el expediente
    @AfterEach
    void tearDown(){
        expedienteService.delete(expedientePrueba.getId());
    }

    /*
    Prueba que la lista de expedientes no sea nula
     */
    @Test
    void testNegativoListar() {
        List<Expediente> expedientes = expedienteService.listar();
        Assertions.assertNull(expedientes);
    }

    /*
   Prueba que el expediente no sea nulo cuando se busca por ID
    */
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

    /*
    Prueba que el expediente se haya guardado correctamente
     */
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

    /*
    Prueba que el expediente se haya eliminado correctamente
     */
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

    /*
   Prueba que se pueda listar un expediente por mascota
    */
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