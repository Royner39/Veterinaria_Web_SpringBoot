package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Cliente;

import java.util.List;

@SpringBootTest
class ClienteServiceTestNegativo extends ClienteService {

    @Autowired
    private ClienteService clienteService;

    private Cliente clientePrueba = new Cliente();

    @BeforeEach
    void setUp() {

        clientePrueba.setNombre("TEST");
        clientePrueba.setEmail("test@vet.com");
        clientePrueba.setPassword("test123");
        clienteService.save(clientePrueba);

    }
    @AfterEach
    void tearDown(){
        clienteService.delete(clientePrueba.getCedula());
    }


    @Test
    void testNegativoListar() {
        List<Cliente> clientes = clienteService.listar();
        Assertions.assertNull(clientes);
    }


    @Test
    void testNegativoListarId() {
        int cedula = 0;
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente:clientes) {
            if (clientePrueba.getNombre().equals(cliente.getNombre())){
                cedula = cliente.getCedula();
            }
        }
        Cliente cliente = clienteService.listarId(cedula).get();
        Assertions.assertNull(cliente);
    }

    @Test
    void testNegativoLogin() {
        int cedula = 0;
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente:clientes) {
            if (clientePrueba.getNombre().equals(cliente.getNombre())){
                cedula = cliente.getCedula();
            }
        }
        String password = "test123";
        boolean login = clienteService.login(cedula,password);
        Assertions.assertFalse(login);
    }

    @Test
    void testNegativoSave() {
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("SAVETEST");
        cliente1.setEmail("test@vet.com");
        cliente1.setPassword("test123");
        boolean saveSuccess = clienteService.save(cliente1);
        if (saveSuccess) {
            clienteService.delete(cliente1.getCedula());
        }
        Assertions.assertFalse(saveSuccess);
    }

    @Test
    void testNegativoDelete() {
        int cedula = 0;
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente:clientes) {
            if (clientePrueba.getNombre().equals(cliente.getNombre())){
                cedula = cliente.getCedula();
            }
        }
        boolean deleteSuccess = clienteService.delete(cedula);
        Assertions.assertFalse(deleteSuccess);
    }
}