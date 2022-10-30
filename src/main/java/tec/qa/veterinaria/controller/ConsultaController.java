package tec.qa.veterinaria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tec.qa.veterinaria.interfaceServices.IConsultaService;
import tec.qa.veterinaria.model.Consulta;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;


    @GetMapping("/verConsultas/{id_mascota}")
    public String listarConsultasCliente(@PathVariable int id_mascota, Model model){
        List<Consulta> consultas = consultaService.listar();
        model.addAttribute("consultas",consultas);
        return "consulta/viewCliente/indexConsulta";
    }
    @GetMapping("/listarConsultas")
    public String listarConsultasMedico(Model model){
        List<Consulta> consultas = consultaService.listar();
        model.addAttribute("consultas",consultas);
        return "consulta/viewMedico/indexConsulta";
    }

    @GetMapping("/nuevaConsulta")
    public String agregarConsulta(Model model){
        model.addAttribute("consulta",new Consulta());
        return "consulta/viewMedico/formConsulta";
    }

    @PostMapping("/guardarConsulta")
    public String guardarConsulta(@Valid Consulta consulta, Model model){
        consultaService.save(consulta);
        return "redirect:/listarConsultas";
    }

    @GetMapping("/editarConsulta/{id}")
    public String editarConsulta(@PathVariable int id, Model model){
        Optional<Consulta> consulta = consultaService.listarId(id);
        model.addAttribute("consulta",consulta);
        return "consulta/viewMedico/formConsulta";
    }

    @GetMapping("/eliminarConsulta/{id}")
    public String eliminarConsulta(@PathVariable int id,Model model){
        consultaService.delete(id);
        return "redirect:/listarConsultas";
    }

}
