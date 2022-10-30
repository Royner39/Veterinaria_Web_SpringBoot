package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest extends Medico {

    Medico medico = new Medico();

    @Test
    void testId() {
        medico.setId(1);
        assertEquals(1, medico.getId());
    }

    @Test
    void testNombre() {
        medico.setNombre("Juan");
        assertEquals("Juan", medico.getNombre());
    }

    @Test
    void testEmail() {
        medico.setEmail("medico1@gmail.com");
        assertEquals("medico1@gmail.com", medico.getEmail());
    }

    @Test
    void testPassword() {
        medico.setPassword("1234");
        assertEquals("1234", medico.getPassword());
    }


    @Test
    void testConsultas() {
        Consulta consulta = new Consulta();
        medico.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), medico.getConsultas());
    }
}