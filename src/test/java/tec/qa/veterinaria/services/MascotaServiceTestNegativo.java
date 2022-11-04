package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;

import java.sql.Date;
import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class MascotaServiceTestNegativo extends MascotaService {

    // Prueba la clase Mascota
    @Autowired
    private MascotaService mascotaService;

    private Mascota mascotaPrueba = new Mascota();

    //Se ejecuta antes de cada prueba y crea una mascota
    @BeforeEach
    void setUp() {
        Date fecha = new Date(2020, 10, 10);
        mascotaPrueba.setNombre("TEST");
        mascotaPrueba.setEspecie("TEST");
        mascotaPrueba.setFechaNacimiento("2020/10/10");
        mascotaPrueba.setSexo("Male");
        mascotaService.save(mascotaPrueba);

    }
    //Se ejecuta despues de cada prueba y elimina la mascota
    @AfterEach
    void tearDown(){
        mascotaService.delete(mascotaPrueba.getId());
    }

    /*
    Prueba que verifica que la lista de mascotas
     */
    @Test
    void testNegativoListar() {
        List<Mascota> mascotas = mascotaService.listar();
        Assertions.assertNotNull(mascotas);
    }

    /*
    Prueba que verifica que la lista de mascotas por id
     */
    @Test
    void testNegativoListarId() {
        int id = 0;
        List<Mascota> mascotas = mascotaService.listar();
        for (Mascota mascota:mascotas) {
            if (mascotaPrueba.getNombre().equals(mascota.getNombre())){
                id = mascota.getId();
            }
        }
        Mascota mascota = mascotaService.listarId(id).get();
        Assertions.assertNotNull(mascota);
    }

    /*
   Prueba que verifica que la mascota se guarde correctamente
    */
    @Test
    void testNegativoSave() {
        Mascota mascota1 = new Mascota();
        Date fecha = new Date(2020, 10, 10);
        mascota1.setNombre("TEST");
        mascota1.setEspecie("TEST");
        mascota1.setFechaNacimiento("2020/10/10");
        mascota1.setSexo("Male");
        boolean saveSuccess = mascotaService.save(mascota1);
        if (saveSuccess) {
            mascotaService.delete(mascota1.getId());
        }
        Assertions.assertTrue(saveSuccess);
    }

    /*
    Prueba que verifica que la mascota se borre correctamente
     */
    @Test
    void testNegativoDelete() {
        int id = 0;
        List<Mascota> mascotas = mascotaService.listar();
        for (Mascota mascota:mascotas) {
            if (mascotaPrueba.getNombre().equals(mascota.getNombre())){
                id = mascota.getId();
            }
        }
        boolean deleteSuccess = mascotaService.delete(id);
        Assertions.assertTrue(deleteSuccess);
    }


    /*
   Prueba que verifica que la lista por cliente contenga el cliente
    */
    @Test
    void testNegativoListarByCliente() {
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("TEST");
        cliente1.setEmail("test@vet.com");
        cliente1.setPassword("test123");
        cliente1.setMascotas(mascotaPrueba);
        Assertions.assertTrue(mascotaService.listarByCliente(cliente1).contains(mascotaPrueba));
    }
}