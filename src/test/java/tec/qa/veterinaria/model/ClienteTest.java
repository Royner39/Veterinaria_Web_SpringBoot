package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest extends Cliente {

    Cliente cliente = new Cliente();
    Mascota mascota = new Mascota();


    @Test
    void testCedula() {
        cliente.setCedula(155223654);
        assertEquals(155223654, cliente.getCedula());
    }

    @Test
    void testNombre() {
        cliente.setNombre("John Doe");
        assertEquals("John Doe", cliente.getNombre());
    }

    @Test
    void testTelefono() {
        cliente.setTelefono(465431321);
        assertEquals(465431321, cliente.getTelefono());
    }

    @Test
    void testEmail() {
        cliente.setEmail("aaa@gmail.com");
        assertEquals("aaa@gmail.com", cliente.getEmail());
    }

    @Test
    void testPassword() {
        cliente.setPassword("contrasena123");
        assertEquals("contrasena123", cliente.getPassword());
    }

    @Test
    void testMascotas() {
        Mascota machita = new Mascota();
        machita.setNombre("Machita");
        machita.setEspecie("Gato");
        machita.setId(1);
        cliente.setMascotas(machita);
        assertEquals(List.of(machita), cliente.getMascotas());
    }
}