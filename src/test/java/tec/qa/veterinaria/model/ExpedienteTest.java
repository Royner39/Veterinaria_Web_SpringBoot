package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class ExpedienteTest extends Expediente {

    //Test para verificar que se pueda crear un expediente
    Expediente expediente = new Expediente();

    /*
    Test
    Descrición: Gets y Sets de ID
     */
    @Test
    void testId() {
        expediente.setId(1);
        assertEquals(1, expediente.getId());
    }

    /*
    Test
    Descrición: Gets y Sets de Mascota
     */
    @Test
    void testMascota() {
        Mascota mascota = new Mascota();
        mascota.setId(1);
        expediente.setMascota(mascota);
        assertEquals(mascota, expediente.getMascota());
    }

    /*
    Test
    Descrición: Gets y Sets de Consulta
     */
    @Test
    void testConsultas() {
        Consulta consulta = new Consulta();
        consulta.setId(1);
        expediente.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), expediente.getConsultas());
    }

}