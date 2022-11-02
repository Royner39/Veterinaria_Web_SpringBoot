package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MascotaTestNegativo extends Mascota {


    Mascota mascota = new Mascota();
    @Test
    void testNegativoId() {
        mascota.setId(1);
        assertEquals(1, mascota.getId());
    }
    

    @Test
    void testNegativoEspecie() {
        mascota.setEspecie("Perro");
        assertEquals("Perro", mascota.getEspecie());
    }
    

    @Test
    void testNegativoNombre() {
        mascota.setNombre("Firulais");
        assertEquals("Firulais", mascota.getNombre());
    }
    
    @Test
    void testNegativoFechaNacimiento() {
        mascota.setFechaNacimiento("01/01/2020");
        assertEquals("01/01/2020", mascota.getFechaNacimiento());
    }

    @Test
    void testNegativoSexo() {
        mascota.setSexo("Macho");
        assertEquals("Macho", mascota.getSexo());
    }
    
    @Test
    void testNegativoExpediente() {
        Expediente expediente = new Expediente();
        mascota.setExpediente(expediente);
        assertEquals(expediente, mascota.getExpediente());
    }
    
    @Test
    void testNegativoCliente() {
        Cliente cliente = new Cliente();
        mascota.setCliente(cliente);
        assertEquals(cliente, mascota.getCliente());
    }

    @Test
    void testNegativoConsultas() {
        Consulta consulta = new Consulta();
        mascota.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), mascota.getConsultas());
    }
}