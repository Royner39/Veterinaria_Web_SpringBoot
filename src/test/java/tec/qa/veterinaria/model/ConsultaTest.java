package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class ConsultaTest extends Consulta {

    //Prueba de la clase Consulta
    Consulta consulta = new Consulta();

    /*
    Test
    Descripción: Prueba de set y get de Id
    */
    @Test
    void testId() {
        consulta.setId(1);
        assertEquals(1, consulta.getId());
    }

    /*
    Test
    Descripción: Prueba de set y get de Descipcion
     */
    @Test
    void testDescripcion() {
        consulta.setDescripcion("Descripcion");
        assertEquals("Descripcion", consulta.getDescripcion());
    }

    /*
    Test
    Descripción: Prueba de set y get de Fecha
     */
    @Test
    void testFecha() {
        Date fecha = new Date(2020, 10, 10);
        consulta.setFecha(fecha);
        assertEquals(fecha, consulta.getFecha());
    }

    /*
    Test
    Descripción: Prueba de set y get de Medico
     */
    @Test
    void testMedico() {
        Medico medico = new Medico();
        medico.setId(1);
        consulta.setMedico(medico);
        assertEquals(medico, consulta.getMedico());
    }

    /*
    Test
    Descripción: Prueba de set y get de Expediente
     */
    @Test
    void testExpediente() {
        Expediente expediente = new Expediente();
        expediente.setId(1);
        consulta.setExpediente(expediente);
        assertEquals(expediente, consulta.getExpediente());
    }

    /*
    Test
    Descripción: Prueba de set y get de Mascota
     */
    @Test
    void testMascota() {
        Mascota mascota = new Mascota();
        mascota.setId(1);
        consulta.setMascota(mascota);
        assertEquals(mascota, consulta.getMascota());
    }


}