package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.interfaceServices.IMascotaService;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Mascota;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @Autowired
    private IClienteService clienteService;


    @GetMapping("/verMascotas/{cedula_cliente}")
    public String listarMascotasCliente(@PathVariable int cedula_cliente, Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula_cliente);
        List<Mascota> mascotas = mascotaService.listarByCliente(cliente.get());
        model.addAttribute("mascotas",mascotas);
        return "mascota/viewCliente/indexMascota";
    }

    @GetMapping("/listarMascotas/{cedula_cliente}")
    public String listarMascotasMedico(@PathVariable int cedula_cliente, Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula_cliente);
        List<Mascota> mascotas = mascotaService.listarByCliente(cliente.get());
        model.addAttribute("mascotas",mascotas);
        model.addAttribute("cliente",cliente.get());
        return "mascota/viewMedico/indexMascota";
    }

    @GetMapping("/nuevaMascota/{cedula_cliente}")
    public String agregarMascota(@PathVariable int cedula_cliente,Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula_cliente);
        model.addAttribute("mascota",new Mascota());
        model.addAttribute("cliente", cliente.get());
        return "mascota/viewMedico/formMascota";
    }

    @PostMapping("/guardarMascota/{cedula_cliente}")
    public String guardarMascota(@PathVariable int cedula_cliente, @Valid Mascota mascota, Model model){
        Optional<Cliente> cliente1 = clienteService.listarId(cedula_cliente);
        if (cliente1.isPresent()) {
            mascotaService.save(mascota, cliente1.get());
        }
        return "redirect:/listarMascotas/"+cedula_cliente;
    }

    @PostMapping("/actualizarMascota/{id}")
    public String actualizarMascota(@PathVariable int id, @Valid Mascota mascota, Model model){

        Optional<Mascota> mascota1 = mascotaService.listarId(id);
        if (mascota1.isPresent()){
            int cedulaCliente = mascota1.get().getCliente().getCedula();
            mascotaService.update(mascota);
            return "redirect:/listarMascotas/"+cedulaCliente;
        }
        return "redirect:/menuMedico";
    }

    @GetMapping("/editarMascota/{id}")
    public String editarMascota(@PathVariable int id, Model model){
        Optional<Mascota> mascota = mascotaService.listarId(id);
        model.addAttribute("mascota",mascota.get());
        return "mascota/viewMedico/formActualizarMascota";
    }

    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable int id,Model model){
        mascotaService.delete(id);
        return "redirect:/listarMascotas";
    }

}