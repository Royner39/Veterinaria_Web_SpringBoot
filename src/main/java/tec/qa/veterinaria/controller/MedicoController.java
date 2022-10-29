package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tec.qa.veterinaria.interfaceServices.IMedicoService;
import tec.qa.veterinaria.model.Medico;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class MedicoController {


    @Autowired
    private IMedicoService medicoService;


    @GetMapping("/loginMedico")
    public String loginMedico(){
        return "medico/formLoginMedico";
    }

    @PostMapping("/checkMedico")
    public String checkMedico(@Valid int id, String password){
        if (medicoService.login(id, password)){
            return "redirect:/menuMedico";
        }
        return "redirect:/loginMedico";
    }
    @GetMapping("/menuMedico")
    public String menuMedico(){
        return "medico/menuMedico";
    }

    @GetMapping("/listarMedicos")
    public String listarMedicos(Model model){
        List<Medico> medicos = medicoService.listar();
        model.addAttribute("medicos",medicos);
        return "medico/indexMedico";
    }

    @GetMapping("/nuevoMedico")
    public String agregarMedico(Model model){
        model.addAttribute("medico",new Medico());
        return "medico/formMedico";
    }

    @PostMapping("/guardarMedico")
    public String guardarCliente(@Valid Medico m, Model model){
        medicoService.save(m);
        return "redirect:/listarClientes";
    }

    @GetMapping("/editarMedico/{id}")
    public String editarCliente(@PathVariable int id, Model model){
        Optional<Medico> medico = medicoService.listarId(id);
        model.addAttribute("medico",medico);
        return "medico/formMedico";
    }

    @GetMapping("/eliminarMedico/{id}")
    public String eliminarCliente(@PathVariable int id,Model model){
        medicoService.delete(id);
        return "redirect:/listarClientes";
    }


}