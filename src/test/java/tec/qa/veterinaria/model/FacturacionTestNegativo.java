package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacturacionTestNegativo extends Facturacion {


    Facturacion facturacion = new Facturacion();

    @Test
    void testNegativoId() {
        facturacion.setId(1);
        assertEquals(1, facturacion.getId());
    }

    @Test
    void testNegativoTotal() {
        facturacion.setTotal(100);
        assertEquals(100, facturacion.getTotal());
    }

    @Test
    void testNegativoProductos() {
        Producto producto = new Producto();
        producto.setPrecio(100);
        producto.setId(1);
        facturacion.setProductos(List.of(producto));
        assertEquals(List.of(producto), facturacion.getProductos());
    }

    @Test
    void testNegativoConsulta() {
        Consulta consulta = new Consulta();
        facturacion.setConsulta(consulta);
        assertEquals(consulta, facturacion.getConsulta());
    }
}