package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class ClienteTestNegativo extends Cliente {

    Cliente cliente = new Cliente();


    @Test
    void testNegativoCedula() {
        cliente.setCedula(155223654);
        assertEquals(15523654, cliente.getCedula());
    }

    @Test
    void testNegativoNombre() {
        cliente.setNombre("John Doe");
        assertEquals("John Doe", cliente.getNombre());
    }

    @Test
    void testNegativoTelefono() {
        cliente.setTelefono(465431321);
        assertEquals(465431321, cliente.getTelefono());
    }

    @Test
    void testNegativoEmail() {
        cliente.setEmail("aaa(a)gmail.com");
        assertEquals("aaa@gmail.com", cliente.getEmail());
    }

    @Test
    void testNegativoPassword() {
        cliente.setPassword("123456");
        assertEquals("contrasena123", cliente.getPassword());
    }


}