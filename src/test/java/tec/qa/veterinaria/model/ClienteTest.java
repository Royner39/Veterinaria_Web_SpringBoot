package tec.qa.veterinaria.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
class ClienteTest extends Cliente {

    //Crea un cliente nuevo
    Cliente cliente = new Cliente();

    /*
    Test
    Descripción: Prueba la funcion de getCedula y setCedula
    */
    @Test
    void testCedula() {
        cliente.setCedula(155223654);
        assertEquals(155223654, cliente.getCedula());
    }

    /*
    Test
    Descripción: Prueba la funcion de getNombre y setNombre
     */
    @Test
    void testNombre() {
        cliente.setNombre("John Doe");
        assertEquals("John Doe", cliente.getNombre());
    }

    /*
    Test
    Descripción: Prueba la funcion de getTelefono y setTelefono
     */
    @Test
    void testTelefono() {
        cliente.setTelefono(465431321);
        assertEquals(465431321, cliente.getTelefono());
    }

    /*
    Test
    Descripción: Prueba la funcion de getEmail y setEmail
     */
    @Test
    void testEmail() {
        cliente.setEmail("aaa@gmail.com");
        assertEquals("aaa@gmail.com", cliente.getEmail());
    }

    /*
    Test
    Descripción: Prueba la funcion de getPassword y setPassword
     */
    @Test
    void testPassword() {
        cliente.setPassword("contrasena123");
        assertEquals("contrasena123", cliente.getPassword());
    }


}