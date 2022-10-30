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


@Controller
@RequestMapping
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @GetMapping("/verProductos/{id_mascota}")
    public String listarProductosCliente(@PathVariable int id_mascota, Model model){
        List<Producto> productos = productoService.listar();
        model.addAttribute("productos",productos);
        return "producto/viewCliente/indexProducto";
    }
    @GetMapping("/listarProductos")
    public String listarProductosMedico(Model model){
        List<Producto> productos = productoService.listar();
        model.addAttribute("productos",productos);
        return "producto/viewMedico/indexProducto";
    }

    @GetMapping("/nuevoProducto")
    public String agregarProducto(Model model){
        model.addAttribute("producto",new Producto());
        return "producto/viewMedico/formProducto";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(@Valid Producto producto, Model model){
        productoService.save(producto);
        return "redirect:/listarProductos";
    }

    @GetMapping("/editarProducto/{id}")
    public String editarProducto(@PathVariable int id, Model model){
        Optional<Producto> producto = productoService.listarId(id);
        model.addAttribute("producto",producto);
        return "producto/viewMedico/formProducto";
    }

    @GetMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable int id,Model model){
        productoService.delete(id);
        return "redirect:/listarProductos";
    }

}
