package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Consulta;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class ConsultaServiceTest extends ConsultaService {

    //Prueba de la clase Consulta
    @Autowired
    private ConsultaService consultaService;
    private Consulta consultaPrueba = new Consulta();

    //Se ejecuta antes de cada prueba y crea una consulta
    @BeforeEach
    void setUp() {
        Date fecha = new Date(2020, 10, 10);
        consultaPrueba.setFecha(fecha);
        consultaPrueba.setDescripcion("TEST");
        consultaService.save(consultaPrueba);

    }
    //Se ejecuta despues de cada prueba y elimina la consulta
    @AfterEach
    void tearDown(){
        consultaService.delete(consultaPrueba.getId());
    }

    /*
    Prueba que verifica que la lista de consultas no sea nula
     */
    @Test
    void testListar() {
        List<Consulta> consultas = consultaService.listar();
        Assertions.assertNotNull(consultas);
    }

    /*
    Prueba que verifica que la lista de consultas por id no sea nula
     */
    @Test
    void testListarId() {
        int id = 0;
        List<Consulta> consultas = consultaService.listar();
        for (Consulta consulta:consultas) {
            if (consultaPrueba.getFecha().equals(consulta.getFecha())){
                id = consulta.getId();
            }
        }
        Consulta consulta = consultaService.listarId(id).get();
        Assertions.assertNotNull(consulta);
    }

    /*
    Prueba que verifica que la consulta se guarde correctamente
     */
    @Test
    void testSave() {
        Consulta consulta1 = new Consulta();
        Date fecha = new Date(2020, 10, 10);
        consulta1.setFecha(fecha);
        consulta1.setDescripcion("TEST");
        boolean saveSuccess = consultaService.save(consulta1);
        if (saveSuccess) {
            consultaService.delete(consulta1.getId());
        }
        Assertions.assertTrue(saveSuccess);
    }

    /*
    Prueba que verifica que la consulta se borre correctamente
     */
    @Test
    void testDelete() {
        int id = 0;
        List<Consulta> consultas = consultaService.listar();
        for (Consulta consulta:consultas) {
            if (consultaPrueba.getFecha().equals(consulta.getFecha())){
                id = consulta.getId();
            }
        }
        boolean deleteSuccess = consultaService.delete(id);
        Assertions.assertTrue(deleteSuccess);
    }
}