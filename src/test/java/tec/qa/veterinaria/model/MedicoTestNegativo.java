package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicoTestNegativo extends Medico {

    Medico medico = new Medico();

    @Test
    void testNegativoId() {
        medico.setId(1);
        assertEquals(1, medico.getId());
    }

    @Test
    void testNegativoNombre() {
        medico.setNombre("Juan");
        assertEquals("Juan", medico.getNombre());
    }

    @Test
    void testNegativoEmail() {
        medico.setEmail("medico1@gmail.com");
        assertEquals("medico1@gmail.com", medico.getEmail());
    }

    @Test
    void testNegativoPassword() {
        medico.setPassword("1234");
        assertEquals("1234", medico.getPassword());
    }


    @Test
    void testNegativoConsultas() {
        Consulta consulta = new Consulta();
        medico.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), medico.getConsultas());
    }
}