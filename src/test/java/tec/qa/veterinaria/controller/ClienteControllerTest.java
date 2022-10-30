package tec.qa.veterinaria.controller;

import org.junit.jupiter.api.Test;
import tec.qa.veterinaria.model.Cliente;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest extends ClienteController {

    @Test
    void testLoginCliente() {
        assertEquals("cliente/formLoginCliente",  loginCliente());
    }

    @Test
    void testCheckCliente() {
        //Consultar como probar esto
    }

    @Test
    void testListarClientes() {
        //Consultar como probar esto
    }

    @Test
    void testAgregarCliente() {
        //Consultar como probar esto
    }

    @Test
    void testGuardarCliente() {
        //Consultar como probar esto
    }

    @Test
    void testEditarCliente() {
        //Consultar como probar esto
    }

    @Test
    void testEliminarCliente() {
        //Consultar como probar esto
    }
}