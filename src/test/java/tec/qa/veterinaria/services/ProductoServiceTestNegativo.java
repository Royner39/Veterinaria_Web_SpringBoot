package tec.qa.veterinaria.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.qa.veterinaria.model.Producto;

import java.util.List;

/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootTest
class ProductoServiceTestNegativo extends ProductoService {

    //Prueba de la clase Producto
    @Autowired
    private ProductoService productoService;

    private Producto productoPrueba = new Producto();

    //Antes de cada prueba va a crear un producto
    @BeforeEach
    void setUp() {
        productoPrueba.setId(1);
        productoPrueba.setDescripcion("Producto de prueba");
        productoPrueba.setPrecio(100);
        productoPrueba.setStock(10);
        productoService.save(productoPrueba);
    }
    //Despues de cada prueba va a eliminar el producto
    @AfterEach
    void tearDown(){
        productoService.delete(productoPrueba.getId());
    }

    /*
    Prueba que verifica la lista de productos
     */
    @Test
    void testNegativoListar() {
        List<Producto> productos = productoService.listar();
        Assertions.assertNotNull(productos);
    }

    /*
    Prueba que verifica la lista de productos por id
     */
    @Test
    void testNegativoListarId() {
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

    /*
    Verifica que el guardado de un producto
     */
    @Test
    void testNegativoSave() {
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

    /*
   Prueba que verifica que el producto no se haya eliminado
    */
    @Test
    void testNegativoDelete() {
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