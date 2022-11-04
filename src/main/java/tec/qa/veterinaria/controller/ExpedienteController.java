package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class ExpedienteController {

    /*
    Se crea una instancia de la interfaz IExpedienteService para poder utilizar los metodos.
     */
    @Autowired
    private IExpedienteService expedienteService;

    /*
    Se crea una instancia de la interfaz IMascotaService para poder utilizar los metodos.
     */
    @Autowired
    private IMascotaService mascotaService;

    /*
    Parametros: modelo, id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de expedientes asociados
    a un cliente.
     */
    @GetMapping("/verExpediente/{id_mascota}")
    public String listarExpedienteCliente(@PathVariable int id_mascota, Model model){
        Optional<Mascota> mascota = mascotaService.listarId(id_mascota);
        if (mascota.isPresent()) {
            Expediente expediente = expedienteService.listarByMascota(mascota.get());
            model.addAttribute("expediente",expediente);
            return "expediente/viewCliente/indexExpediente";
        }
        return "redirect:/error";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de expedientes
    asociados a un medico.
     */
    @GetMapping("/listarExpedientes")
    public String listarExpedientesMedico(Model model) {
        List<Expediente> expedientes = expedienteService.listar();
        model.addAttribute("expedientes", expedientes);
        return "expediente/viewMedico/indexExpediente";
    }

    /*
    Parametros: modelo, id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de creacion de un expediente.
     */
    @GetMapping("/nuevoExpediente/{id_mascota}")
    public String agregarExpediente(@PathVariable int id_mascota, Model model) {
        Optional<Mascota> mascota = mascotaService.listarId(id_mascota);
        if (mascota.isPresent()) {
            model.addAttribute("expediente", new Expediente());
            model.addAttribute("mascota", mascota.get());
            return "expediente/viewMedico/formExpediente";
        }
        return "redirect:/error";
    }

    /*
    Parametros: modelo, id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listar expedientes
    despues de guardar de un expediente.
     */
    @PostMapping("/guardarExpediente/{id_mascota}")
    public String guardarExpediente(@PathVariable int id_mascota, @Valid Expediente expediente, Model model) {
        Optional<Mascota> mascota = mascotaService.listarId(id_mascota);
        if (mascota.isPresent()) {
            if (expedienteService.save(expediente)) {
                mascota.get().setExpediente(expediente);
                return "redirect:/listarMascotas/"+mascota.get().getCliente().getCedula();
            }
        }
        return "redirect:/error";
    }

    /*
    Parametros: modelo, id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de editar un expediente.
     */
    @GetMapping("/editarExpediente/{id}")
    public String editarExpediente(@PathVariable int id, Model model) {
        Optional<Expediente> expediente = expedienteService.listarId(id);
        model.addAttribute("expediente", expediente);
        return "expediente/viewMedico/formExpediente";
    }

    /*
    Parametros: modelo, id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listar expedientes
    despues de eliminar un expediente.
     */
    @GetMapping("/eliminarExpediente/{id}")
    public String eliminarExpediente(@PathVariable int id, Model model) {
        expedienteService.delete(id);
        return "redirect:/listarExpediente";
    }
}
