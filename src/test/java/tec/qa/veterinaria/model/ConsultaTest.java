package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaTest extends Consulta {

    Consulta consulta = new Consulta();

    @Test
    void testId() {
        consulta.setId(1);
        assertEquals(1, consulta.getId());
    }

    @Test
    void testDescripcion() {
        consulta.setDescripcion("Descripcion");
        assertEquals("Descripcion", consulta.getDescripcion());
    }

    @Test
    void testFecha() {
        Date fecha = new Date(2020, 10, 10);
        consulta.setFecha(fecha);
        assertEquals(fecha, consulta.getFecha());
    }

    @Test
    void testMedico() {
        Medico medico = new Medico();
        medico.setId(1);
        consulta.setMedico(medico);
        assertEquals(medico, consulta.getMedico());
    }

    @Test
    void testExpediente() {
        Expediente expediente = new Expediente();
        expediente.setId(1);
        consulta.setExpediente(expediente);
        assertEquals(expediente, consulta.getExpediente());
    }

    @Test
    void testMascota() {
        Mascota mascota = new Mascota();
        mascota.setId(1);
        consulta.setMascota(mascota);
        assertEquals(mascota, consulta.getMascota());
    }


}