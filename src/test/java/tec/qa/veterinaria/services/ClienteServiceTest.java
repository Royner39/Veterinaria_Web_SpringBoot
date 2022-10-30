package tec.qa.veterinaria.services;

import org.junit.jupiter.api.Test;
import tec.qa.veterinaria.model.Cliente;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest extends ClienteService {

    @Test
    void testListar() {
        List<Cliente> clientes = listar();
        assertNotNull(clientes);
    }

    @Test
    void testListarId() {
        int cedula = 1;
        Cliente cliente = listarId(cedula).get();
        assertNotNull(cliente);
    }

    @Test
    void testLogin() {
        int cedula = 1;
        String password = "123";
        boolean login = login(cedula, password);
        assertTrue(login);
    }

    @Test
    void testSave() {
        Cliente cliente = new Cliente();
        cliente.setCedula(1);
        cliente.setNombre("Juan");
        cliente.setTelefono(12345678);
        cliente.setEmail("prueba@gmail.com");
        cliente.setPassword("123");
        boolean save = save(cliente);
        assertTrue(save);
    }

    @Test
    void testDelete() {
        int cedula = 1;
        boolean delete = delete(cedula);
        assertTrue(delete);
    }
}