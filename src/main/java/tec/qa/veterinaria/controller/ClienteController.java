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


@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @GetMapping("/loginCliente")
    public String loginCliente(){
        return "cliente/formLoginCliente";
    }

    @PostMapping("/checkCliente")
    public String checkCliente(@Valid int cedula, String password){
        if (clienteService.login(cedula, password)){
            return "redirect:/listarMascotas/"+cedula;
        }
        return "redirect:/loginCliente";
    }


    @GetMapping("/listarClientes")
    public String listarClientes(Model model){
        List<Cliente> clientes = clienteService.listar();
        model.addAttribute("clientes",clientes);
        return "cliente/indexCliente";
    }

    @GetMapping("/nuevoCliente")
    public String agregarCliente(Model model){
        model.addAttribute("cliente",new Cliente());
        return "cliente/formCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@Valid Cliente c, Model model){
        clienteService.save(c);
        return "redirect:/listarClientes";
    }

    @GetMapping("/editarCliente/{cedula}")
    public String editarCliente(@PathVariable int cedula, Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula);
        model.addAttribute("cliente",cliente);
        return "cliente/formCliente";
    }

    @GetMapping("/eliminarCliente/{cedula}")
    public String eliminarCliente(@PathVariable int cedula,Model model){
        clienteService.delete(cedula);
        return "redirect:/listarClientes";
    }


}