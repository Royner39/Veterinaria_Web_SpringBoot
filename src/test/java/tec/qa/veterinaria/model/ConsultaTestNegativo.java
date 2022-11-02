package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsultaTestNegativo extends Consulta {

    Consulta consulta = new Consulta();

    @Test
    void testNegativoId() {
        consulta.setId(1);
        assertEquals(1, consulta.getId());
    }

    @Test
    void testNegativoDescripcion() {
        consulta.setDescripcion("Descripcion");
        assertEquals("Descripcion", consulta.getDescripcion());
    }

    @Test
    void testNegativoFecha() {
        Date fecha = new Date(2020, 10, 10);
        consulta.setFecha(fecha);
        assertEquals(fecha, consulta.getFecha());
    }

    @Test
    void testNegativoMedico() {
        Medico medico = new Medico();
        medico.setId(-32234234);
        consulta.setMedico(medico);
        assertEquals(medico, consulta.getMedico());
    }

    @Test
    void testNegativoExpediente() {
        Expediente expediente = new Expediente();
        expediente.setId(1);
        consulta.setExpediente(expediente);
        assertEquals(expediente, consulta.getExpediente());
    }

    @Test
    void testNegativoMascota() {
        Mascota mascota = new Mascota();
        mascota.setId(1);
        consulta.setMascota(mascota);
        assertEquals(mascota, consulta.getMascota());
    }

    @Test
    void testNegativoFacturas() {
        Facturacion facturacion = new Facturacion();
        facturacion.setId(1);
        consulta.setFacturas(List.of(facturacion));
        assertEquals(List.of(facturacion), consulta.getFacturas());

    }

}