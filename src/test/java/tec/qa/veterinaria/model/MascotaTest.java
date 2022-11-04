package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class MascotaTest extends Mascota {

    //Test para verificar que se pueda crear una mascota
    Mascota mascota = new Mascota();

    /*
    Test
    Descripción: Gets y Sets de ID
     */
    @Test
    void testId() {
        mascota.setId(1);
        assertEquals(1, mascota.getId());
    }

    /*
    Test
    Descripción: Gets y Sets de Especie
     */
    @Test
    void testEspecie() {
        mascota.setEspecie("Perro");
        assertEquals("Perro", mascota.getEspecie());
    }
    
    /*
    Test
    Descripción: Gets y Sets de Nombre
     */
    @Test
    void testNombre() {
        mascota.setNombre("Firulais");
        assertEquals("Firulais", mascota.getNombre());
    }

    /*
    Test
    Descripción: Gets y Sets de Fecha de Nacimiento
     */
    @Test
    void testFechaNacimiento() {
        mascota.setFechaNacimiento("01/01/2020");
        assertEquals("01/01/2020", mascota.getFechaNacimiento());
    }


    @Test
    void testSexo() {
        mascota.setSexo("Macho");
        assertEquals("Macho", mascota.getSexo());
    }
    
    @Test
    void testExpediente() {
        Expediente expediente = new Expediente();
        mascota.setExpediente(expediente);
        assertEquals(expediente, mascota.getExpediente());
    }
    
    @Test
    void testCliente() {
        Cliente cliente = new Cliente();
        mascota.setCliente(cliente);
        assertEquals(cliente, mascota.getCliente());
    }

    @Test
    void testConsultas() {
        Consulta consulta = new Consulta();
        mascota.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), mascota.getConsultas());
    }
}