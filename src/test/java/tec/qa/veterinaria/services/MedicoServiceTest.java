package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Medico;

import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */

@SpringBootTest
class MedicoServiceTest extends MedicoService {

    //Prueba de la clase Medico
    @Autowired
    private MedicoService medicoService;
    private  Medico medicoPrueba = new Medico();

    //Antes de cada prueba va a crear un medico
    @BeforeEach
    void setUp() {

        medicoPrueba.setNombre("TEST");
        medicoPrueba.setEmail("test@vet.com");
        medicoPrueba.setPassword("test123");
        medicoService.save(medicoPrueba);

    }
    //Despues de cada prueba va a eliminar el medico
    @AfterEach
    void tearDown(){
        medicoService.delete(medicoPrueba.getId());
    }

    /*
    Prueba que verifica que la lista de medicos no sea nula
     */
    @Test
    void testListar() {
        List<Medico> medicos = medicoService.listar();
        Assertions.assertNotNull(medicos);
    }

    /*
    Prueba que verifica que la lista de medicos por id no sea nula
     */
    @Test
    void testListarId() {
        int id = 0;
        List<Medico> medicos = medicoService.listar();
        for (Medico medico:medicos) {
            if (medicoPrueba.getNombre().equals(medico.getNombre())){
                id = medico.getId();
            }
        }
        Medico medico = medicoService.listarId(id).get();
        Assertions.assertNotNull(medico);
    }

    /*
    Prueba que verifica que se pueda logear un medico
     */
    @Test
    void testLogin() {
        int id = 0;
        List<Medico> medicos = medicoService.listar();
        for (Medico medico:medicos) {
            if (medicoPrueba.getNombre().equals(medico.getNombre())){
                id = medico.getId();
            }
        }
        String password = "test123";
        boolean loginSucces = medicoService.login(id,password);
        Assertions.assertTrue(loginSucces);
    }

    /*
    Prueba que verifica que se pueda guardar un medico
     */
    @Test
    void testSave() {
        Medico medico1 = new Medico();
        medico1.setNombre("SAVETEST");
        medico1.setEmail("test@vet.com");
        medico1.setPassword("test123");
        boolean saveSuccess = medicoService.save(medico1);
        if (saveSuccess) {
            medicoService.delete(medico1.getId());
        }
        Assertions.assertTrue(saveSuccess);
    }

    /*
    Prueba que verifica que se pueda borrar un medico
     */
    @Test
    void testDelete() {
        int id = 0;
        List<Medico> medicos = medicoService.listar();
        for (Medico medico:medicos) {
            if (medicoPrueba.getNombre().equals(medico.getNombre())){
                id = medico.getId();
            }
        }
        boolean deleteSuccess = medicoService.delete(id);
        Assertions.assertTrue(deleteSuccess);
    }
}