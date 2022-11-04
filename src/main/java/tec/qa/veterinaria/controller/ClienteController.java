package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.model.Cliente;

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
public class ClienteController {

    /*
    Se crea una instancia de la interfaz IClienteService para poder utilizar los metodos de la
    misma
    */
    @Autowired
    private IClienteService clienteService;

    /*
    Parametros: Nada
    Retorno: Direccion a nueva interfaz.
    Descripción: Este metodo se encarga de redirigir a la interfaz de login para clientes.
     */
    @GetMapping("/loginCliente")
    public String loginCliente(){
        return "cliente/formLoginCliente";
    }

    /*
    Parametros: Credencial de identificacion y contraseña del cliente.
    Retorno: Direccion a nueva interfaz.
    Descripción: Este metodo se encarga de redigir a los clientes a su respectiva interfaz
    posterior a el login.
     */
    @PostMapping("/checkCliente")
    public String checkCliente(@Valid int cedula, String password){
        if (clienteService.login(cedula, password)){
            return "cliente/menuCliente";
        }
        return "redirect:/loginCliente";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de clientes.
     */
    @GetMapping("/listarClientes")
    public String listarClientes(Model model){
        List<Cliente> clientes = clienteService.listar();
        model.addAttribute("clientes",clientes);
        return "cliente/indexCliente";
    }

    /*
   Parametros: modelo
   Retorno: Direccion a nueva interfaz.
   Descripción: Redirecciona a la interfaz de agregar un nuevo cliente.
    */
    @GetMapping("/nuevoCliente")
    public String agregarCliente(Model model){
        model.addAttribute("cliente",new Cliente());
        return "cliente/formCliente";
    }

    /*
   Parametros: modelo, cliente
   Retorno: Direccion a nueva interfaz.
   Descripción: Funcion que se encarga de redirigir a la interfaz de listado de
   las mascotas de un cliente.
    */
    @PostMapping("/guardarCliente")
    public String guardarCliente(@Valid Cliente c, Model model){
        int cedula = c.getCedula();
        if (clienteService.save(c)) {
            return "redirect:/verMascotas/"+cedula;
        }
        return "redirect:/error";
    }

    /*
   Parametros: modelo, cedula
   Retorno: Direccion a nueva interfaz.
   Descripción: Funcion que se encarga de redirigir a la interfaz de edición
   de los datos de un cliente.
    */
    @GetMapping("/editarCliente/{cedula}")
    public String editarCliente(@PathVariable int cedula, Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula);
        model.addAttribute("cliente",cliente);
        return "cliente/formCliente";
    }

    /*
   Parametros: modelo, cedula
   Retorno: Direccion a nueva interfaz.
   Descripción: funcion que se encarga de redirigir a la interfaz de listado de
   clientes luego de eliminar un cliente.
    */
    @GetMapping("/eliminarCliente/{cedula}")
    public String eliminarCliente(@PathVariable int cedula,Model model){
        if (clienteService.delete(cedula)) {
            return "redirect:/listarClientes";
        }
        return "redirect:/error";
    }


}