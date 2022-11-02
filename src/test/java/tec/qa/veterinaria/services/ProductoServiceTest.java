package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Producto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductoServiceTest extends ProductoService {



    @Autowired
    private ProductoService productoService;

    private Producto productoPrueba = new Producto();

    @BeforeEach
    void setUp() {
        productoPrueba.setId(1);
        productoPrueba.setDescripcion("Producto de prueba");
        productoPrueba.setPrecio(100);
        productoPrueba.setStock(10);
        productoService.save(productoPrueba);
    }
    @AfterEach
    void tearDown(){
        productoService.delete(productoPrueba.getId());
    }

    @Test
    void testListar() {
        List<Producto> productos = productoService.listar();
        Assertions.assertNotNull(productos);
    }

    @Test
    void testListarId() {
        int id = 0;
        List<Producto> productos = productoService.listar();
        for (Producto producto:productos) {
            if (productoPrueba.getId() == producto.getId()){
                id = producto.getId();
            }
        }
        Producto producto = productoService.listarId(id).get();
        Assertions.assertNotNull(producto);
    }

    @Test
    void testSave() {
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setDescripcion("Producto de prueba");
        producto1.setPrecio(100);
        producto1.setStock(10);
        boolean saveSuccess = productoService.save(producto1);
        if (saveSuccess) {
            productoService.delete(producto1.getId());
        }
        Assertions.assertTrue(saveSuccess);
    }

    @Test
    void testDelete() {
        int id = 0;
        List<Producto> productos = productoService.listar();
        for (Producto producto:productos) {
            if (productoPrueba.getId() == producto.getId()){
                id = producto.getId();
            }
        }
        boolean deleteSuccess = productoService.delete(id);
        Assertions.assertTrue(deleteSuccess);
    }
}