package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Medico;

import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class ClienteServiceTest extends ClienteService {

    //Prueba de la clase Cliente
    @Autowired
    private ClienteService clienteService;
    private Cliente clientePrueba = new Cliente();

    //Antes de cada prueba va a crear un cliente
    @BeforeEach
    void setUp() {

        clientePrueba.setNombre("TEST");
        clientePrueba.setEmail("test@vet.com");
        clientePrueba.setPassword("test123");
        clienteService.save(clientePrueba);

    }
    //Despues de cada prueba va a eliminar el cliente
    @AfterEach
    void tearDown(){
        clienteService.delete(clientePrueba.getCedula());
    }


    /*
    Test
    Prueba de la lista de clientes
     */
    @Test
    void testListar() {
        List<Cliente> clientes = clienteService.listar();
        Assertions.assertNotNull(clientes);
    }

    /*
    Test
    Prueba de la lista de clientes por id
     */
    @Test
    void testListarId() {
        int cedula = 0;
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente:clientes) {
            if (clientePrueba.getNombre().equals(cliente.getNombre())){
                cedula = cliente.getCedula();
            }
        }
        Cliente cliente = clienteService.listarId(cedula).get();
        Assertions.assertNotNull(cliente);
    }

    /*
    Test
    Prueba de logear un cliente
     */
    @Test
    void testLogin() {
        int cedula = 0;
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente:clientes) {
            if (clientePrueba.getNombre().equals(cliente.getNombre())){
                cedula = cliente.getCedula();
            }
        }
        String password = "test123";
        boolean login = clienteService.login(cedula,password);
        Assertions.assertTrue(login);
    }

    /*
    Test
    Prueba de guardar un cliente
     */
    @Test
    void testSave() {
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("SAVETEST");
        cliente1.setEmail("test@vet.com");
        cliente1.setPassword("test123");
        boolean saveSuccess = clienteService.save(cliente1);
        if (saveSuccess) {
            clienteService.delete(cliente1.getCedula());
        }
        Assertions.assertTrue(saveSuccess);
    }

    /*
    Test
    Prueba de eliminar un cliente
     */
    @Test
    void testDelete() {
        int cedula = 0;
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente:clientes) {
            if (clientePrueba.getNombre().equals(cliente.getNombre())){
                cedula = cliente.getCedula();
            }
        }
        boolean deleteSuccess = clienteService.delete(cedula);
        Assertions.assertTrue(deleteSuccess);
    }
}