package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class ProductoTest extends Producto {

    //Prueba de la clase Producto
    Producto producto = new Producto();

    /*
    Test
    Descripción: Prueba de set y get de Id
     */
    @Test
    void testSetId() {
        producto.setId(1);
        assertEquals(1, producto.getId());
    }

    /*
    Test
    Descripción: Prueba de set y get de Descipcion
     */
    @Test
    void testSetDescripcion() {
        producto.setDescripcion("Caja de 12 latas");
        assertEquals("Caja de 12 latas", producto.getDescripcion());
    }

    /*
    Test
    Descripción: Prueba de set y get de Precio
     */
    @Test
    void testSetPrecio() {
        producto.setPrecio(1000);
        assertEquals(1000, producto.getPrecio());
    }

    /*
    Test
    Descripción: Prueba de set y get de Stock
     */
    @Test
    void testSetStock() {
        producto.setStock(10);
        assertEquals(10, producto.getStock());
    }

    /*
    Test
    Descripción: Prueba de set y get de Factura
     */
    @Test
    void testSetFactura() {
        Facturacion factura = new Facturacion();
        producto.setFactura(factura);
        assertEquals(factura, producto.getFactura());
    }
}