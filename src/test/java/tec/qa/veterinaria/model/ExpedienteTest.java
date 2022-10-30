package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpedienteTest extends Expediente {


    Expediente expediente = new Expediente();
    @Test
    void testId() {
        expediente.setId(1);
        assertEquals(1, expediente.getId());
    }

    @Test
    void testMascota() {
        Mascota mascota = new Mascota();
        mascota.setId(1);
        expediente.setMascota(mascota);
        assertEquals(mascota, expediente.getMascota());
    }

    @Test
    void testConsultas() {
        Consulta consulta = new Consulta();
        consulta.setId(1);
        expediente.setConsultas(List.of(consulta));
        assertEquals(List.of(consulta), expediente.getConsultas());
    }

}