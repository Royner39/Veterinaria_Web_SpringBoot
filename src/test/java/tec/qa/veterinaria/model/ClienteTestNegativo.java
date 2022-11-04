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

    //Crea un cliente nuevo
    Cliente cliente = new Cliente();


    /*
    Test
    Descripción: Prueba la funcion de getCedula y setCedula
    */
    @Test
    void testNegativoCedula() {
        cliente.setCedula(155223654);
        assertEquals(15523654, cliente.getCedula());
    }

    /*
   Test
   Descripción: Prueba la funcion de getNombre y setNombre
    */
    @Test
    void testNegativoNombre() {
        cliente.setNombre("John Doe");
        assertEquals("John Doe", cliente.getNombre());
    }

    /*
    Test
    Descripción: Prueba la funcion de getTelefono y setTelefono
     */
    @Test
    void testNegativoTelefono() {
        cliente.setTelefono(465431321);
        assertEquals(465431321, cliente.getTelefono());
    }

    /*
    Test
    Descripción: Prueba la funcion de getEmail y setEmail
     */
    @Test
    void testNegativoEmail() {
        cliente.setEmail("aaa(a)gmail.com");
        assertEquals("aaa@gmail.com", cliente.getEmail());
    }

    /*
    Test
    Descripción: Prueba la funcion de getPassword y setPassword
     */
    @Test
    void testNegativoPassword() {
        cliente.setPassword("123456");
        assertEquals("contrasena123", cliente.getPassword());
    }


}