package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class MedicoTestNegativo extends Medico {

    //Prueba de la clase Medico
    Medico medico = new Medico();

    /*
    Test
    Descripción: Prueba de set y get de Id
     */
    @Test
    void testNegativoId() {
        medico.setId(1);
        assertEquals(1, medico.getId());
    }

    /*
    Test
    Descripción: Prueba de set y get de Nombre
     */
    @Test
    void testNegativoNombre() {
        medico.setNombre("Juan");
        assertEquals("Juan", medico.getNombre());
    }

    /*
   Test
   Descripción: Prueba de set y get de Email
    */
    @Test
    void testNegativoEmail() {
        medico.setEmail("medico1@gmail.com");
        assertEquals("medico1@gmail.com", medico.getEmail());
    }

    /*
   Test
   Descripción: Prueba de set y get de Password
    */
    @Test
    void testNegativoPassword() {
        medico.setPassword("1234");
        assertEquals("1234", medico.getPassword());
    }

    /*
    Test
    Descripción: Prueba de set y get de Consultas
     */
    @Test
    void testNegativoConsultas() {
        Consulta consulta = new Consulta();
        medico.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), medico.getConsultas());
    }
}