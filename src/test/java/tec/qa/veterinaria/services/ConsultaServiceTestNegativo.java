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
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class ConsultaServiceTestNegativo extends ConsultaService {

    @Autowired
    private ConsultaService consultaService;

    private Consulta consultaPrueba = new Consulta();

    @BeforeEach
    void setUp() {
        Date fecha = new Date(2020, 10, 10);
        consultaPrueba.setFecha(fecha);
        consultaPrueba.setDescripcion("TEST");
        consultaService.save(consultaPrueba);

    }
    @AfterEach
    void tearDown(){
        consultaService.delete(consultaPrueba.getId());
    }

    @Test
    void testNegativoListar() {
        List<Consulta> consultas = consultaService.listar();
        Assertions.assertNull(consultas);
    }

    @Test
    void testNegativoListarId() {
        int id = 0;
        List<Consulta> consultas = consultaService.listar();
        for (Consulta consulta:consultas) {
            if (consultaPrueba.getFecha().equals(consulta.getFecha())){
                id = consulta.getId();
            }
        }
        Consulta consulta = consultaService.listarId(id).get();
        Assertions.assertNull(consulta);
    }

    @Test
    void testNegativoSave() {
        Consulta consulta1 = new Consulta();
        Date fecha = new Date(2020, 10, 10);
        consulta1.setFecha(fecha);
        consulta1.setDescripcion("TEST");
        boolean saveSuccess = consultaService.save(consulta1);
        if (saveSuccess) {
            consultaService.delete(consulta1.getId());
        }
        Assertions.assertFalse(saveSuccess);
    }

    @Test
    void testNegativoDelete() {
        int id = 0;
        List<Consulta> consultas = consultaService.listar();
        for (Consulta consulta:consultas) {
            if (consultaPrueba.getFecha().equals(consulta.getFecha())){
                id = consulta.getId();
            }
        }
        boolean deleteSuccess = consultaService.delete(id);
        Assertions.assertFalse(deleteSuccess);
    }
}