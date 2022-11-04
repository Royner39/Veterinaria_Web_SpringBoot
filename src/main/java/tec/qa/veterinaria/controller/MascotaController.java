package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tec.qa.veterinaria.interfaceServices.IClienteService;
import tec.qa.veterinaria.interfaceServices.IExpedienteService;
import tec.qa.veterinaria.interfaceServices.IMascotaService;
import tec.qa.veterinaria.model.Cliente;
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

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
public class MascotaController {

    /*
    Se crea una instancia de la interfaz IMascotaService para poder utilizar los metodos.
     */
    @Autowired
    private IMascotaService mascotaService;

    /*
    Se crea una instancia de la interfaz IClienteService para poder utilizar los metodos.
     */
    @Autowired
    private IClienteService clienteService;

    /*
    Se crea una instancia de la interfaz IExpedienteService para poder utilizar los metodos.
     */
    @Autowired
    private IExpedienteService expedienteService;

    /*
    Parametros: modelo, cédula del cliente
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de mascotas
    asociadas a un cliente.
     */
    @GetMapping("/verMascotas/{cedula_cliente}")
    public String listarMascotasCliente(@PathVariable int cedula_cliente, Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula_cliente);
        List<Mascota> mascotas = mascotaService.listarByCliente(cliente.get());
        model.addAttribute("mascotas",mascotas);
        return "mascota/viewCliente/indexMascota";
    }

    /*
    Parametros: modelo, cédula del cliente
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de registro de mascotas
    asociadas a un medico.
     */
    @GetMapping("/listarMascotas/{cedula_cliente}")
    public String listarMascotasMedico(@PathVariable int cedula_cliente, Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula_cliente);
        List<Mascota> mascotas = mascotaService.listarByCliente(cliente.get());
        model.addAttribute("mascotas",mascotas);
        model.addAttribute("cliente",cliente.get());
        return "mascota/viewMedico/indexMascota";
    }

    /*
    Parametros: modelo, cédula del cliente
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de registro de mascotas
     */
    @GetMapping("/nuevaMascota/{cedula_cliente}")
    public String agregarMascota(@PathVariable int cedula_cliente,Model model){
        Optional<Cliente> cliente = clienteService.listarId(cedula_cliente);
        model.addAttribute("mascota",new Mascota());
        model.addAttribute("cliente", cliente.get());
        return "mascota/viewMedico/formMascota";
    }

    /*
    Parametros: modelo, cédula del cliente, mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de registro de mascotas
     */
    @PostMapping("/guardarMascota/{cedula_cliente}")
    public String guardarMascota(@PathVariable int cedula_cliente, @Valid Mascota mascota, Model model){
        Optional<Cliente> cliente1 = clienteService.listarId(cedula_cliente);
        if (cliente1.isPresent()) {
            cliente1.get().setMascotas(mascota);
            if (mascotaService.save(mascota)) {
                return "redirect:/nuevoExpediente/"+mascota.getId();
            }
        }
        return "redirect:/error";
    }

    /*
    Parametros: modelo, cédula del cliente, mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de mascotas
    posterior a la actualizacion de una mascota.
     */
    @PostMapping("/actualizarMascota/{id}")
    public String actualizarMascota(@PathVariable int id, @Valid Mascota mascota, Model model){

        Optional<Mascota> mascota1 = mascotaService.listarId(id);
        if (mascota1.isPresent()){
            int cedulaCliente = mascota1.get().getCliente().getCedula();
            if (mascotaService.update(mascota)){
                return "redirect:/listarMascotas/"+cedulaCliente;
            }
            return "redirect:/menuMedico";
        }
        return "redirect:/error";
    }

    /*
    Parametros: modelo, cédula del cliente
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de edicion
    de informacion sobre mascotas
     */
    @GetMapping("/editarMascota/{id}")
    public String editarMascota(@PathVariable int id, Model model){
        Optional<Mascota> mascota = mascotaService.listarId(id);
        model.addAttribute("mascota",mascota.get());
        return "mascota/viewMedico/formActualizarMascota";
    }

    /*
    Parametros: modelo, cédula del cliente
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de mascotas
    posterior a la eliminacion de una mascota.
     */
    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable int id,Model model){
        if (mascotaService.delete(id)) {
            return "redirect:/listarMascotas";
        }
        return "redirect:/error";
    }

}