package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tec.qa.veterinaria.interfaceServices.IProductoService;
import tec.qa.veterinaria.model.Producto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Controller
@RequestMapping
public class ProductoController {

    /*
    Se crea una instancia de la interfaz IProductoService para poder utilizar los metodos.
     */
    @Autowired
    private IProductoService productoService;

    /*
    Parametros: id de la mascota, modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de productos.
     */
    @GetMapping("/verProductos/{id_mascota}")
    public String listarProductosCliente(@PathVariable int id_mascota, Model model){
        List<Producto> productos = productoService.listar();
        model.addAttribute("productos",productos);
        return "producto/viewCliente/indexProducto";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de productos.
    */
    @GetMapping("/listarProductos")
    public String listarProductosMedico(Model model){
        List<Producto> productos = productoService.listar();
        model.addAttribute("productos",productos);
        return "producto/viewMedico/indexProducto";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de creacion de productos.
     */
    @GetMapping("/nuevoProducto")
    public String agregarProducto(Model model){
        model.addAttribute("producto",new Producto());
        return "producto/viewMedico/formProducto";
    }

    /*
    Parametros: producto, modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de productos
    posterior a la creacion de un producto.
     */
    @PostMapping("/guardarProducto")
    public String guardarProducto(@Valid Producto producto, Model model){
        productoService.save(producto);
        return "redirect:/listarProductos";
    }

    /*
    Parametros: id del producto, modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de edicion de productos.
     */
    @GetMapping("/editarProducto/{id}")
    public String editarProducto(@PathVariable int id, Model model){
        Optional<Producto> producto = productoService.listarId(id);
        model.addAttribute("producto",producto);
        return "producto/viewMedico/formProducto";
    }

    /*
    Parametros: id del producto, modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de productos
    posterior a la eliminacion de un producto.
     */
    @GetMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable int id,Model model){
        productoService.delete(id);
        return "redirect:/listarProductos";
    }

}
