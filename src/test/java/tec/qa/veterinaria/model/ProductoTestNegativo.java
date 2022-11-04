package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class ProductoTestNegativo extends Producto {


    Producto producto = new Producto();
    @Test
    void testNegativoSetId() {
        producto.setId(1);
        assertEquals(1, producto.getId());
    }

    @Test
    void testNegativoSetDescripcion() {
        producto.setDescripcion("Caja de 12 latas");
        assertEquals("Caja de 12 latas", producto.getDescripcion());
    }

    @Test
    void testNegativoSetPrecio() {
        producto.setPrecio(1000);
        assertEquals(1000, producto.getPrecio());
    }

    @Test
    void testNegativoSetStock() {
        producto.setStock(10);
        assertEquals(10, producto.getStock());
    }

    @Test
    void testNegativoSetFactura() {
        Facturacion factura = new Facturacion();
        producto.setFactura(factura);
        assertEquals(factura, producto.getFactura());
    }
}