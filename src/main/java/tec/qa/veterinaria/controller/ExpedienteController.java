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
import tec.qa.veterinaria.model.Expediente;
import tec.qa.veterinaria.model.Mascota;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ExpedienteController {

    @Autowired
    private IExpedienteService expedienteService;

    @Autowired
    private IMascotaService mascotaService;

    @GetMapping("/listarExpedientes")
    public String listarExpedientesMedico(Model model) {
        List<Expediente> expedientes = expedienteService.listar();
        model.addAttribute("expedientes", expedientes);
        return "expediente/viewMedico/indexExpediente";
    }

    @GetMapping("/nuevoExpediente")
    public String agregarExpediente(Model model) {
        model.addAttribute("expediente", new Expediente());
        return "expediente/viewMedico/formExpediente";
    }

    @PostMapping("/guardarExpediente/{id}")
    public String guardarExpediente(@PathVariable int id, @Valid Expediente expediente, Model model) {
        Optional<Mascota> mascota = mascotaService.listarId(id);
        if (mascota.isPresent()){
            expedienteService.save(expediente, mascota.get());
        }
        return "redirect:/listarExpedientes";
    }

    @GetMapping("/editarExpediente/{id}")
    public String editarExpediente(@PathVariable int id, Model model) {
        Optional<Expediente> expediente = expedienteService.listarId(id);
        model.addAttribute("expediente", expediente);
        return "expediente/viewMedico/formExpediente";
    }

    @GetMapping("/eliminarExpediente/{id}")
    public String eliminarExpediente(@PathVariable int id, Model model) {
        expedienteService.delete(id);
        return "redirect:/listarExpediente";
    }
}
