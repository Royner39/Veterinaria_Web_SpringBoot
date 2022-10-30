package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacturacionTest extends Facturacion {


    Facturacion facturacion = new Facturacion();

    @Test
    void testId() {
        facturacion.setId(1);
        assertEquals(1, facturacion.getId());
    }

    @Test
    void testTotal() {
        facturacion.setTotal(100);
        assertEquals(100, facturacion.getTotal());
    }

    @Test
    void testProductos() {
        Producto producto = new Producto();
        producto.setPrecio(100);
        producto.setId(1);
        facturacion.setProductos(List.of(producto));
        assertEquals(List.of(producto), facturacion.getProductos());
    }

    @Test
    void testConsulta() {
        Consulta consulta = new Consulta();
        facturacion.setConsulta(consulta);
        assertEquals(consulta, facturacion.getConsulta());
    }
}