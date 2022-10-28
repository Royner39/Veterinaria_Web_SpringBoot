package tec.qa.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @GetMapping("/listarMascotas/{cliente}")
    public String listarMascotas(Model model, Cliente cliente){
        List<Mascota> mascotas = mascotaService.listarByCliente(cliente);
        model.addAttribute("mascotas",mascotas);
        return "sites/indexMascota";
    }

    @GetMapping("/nuevaMascota")
    public String agregarMascota(Model model){
        model.addAttribute("mascota",new Mascota());
        return "forms/formMascota";
    }

    @PostMapping("/guardarMascota")
    public String guardarMascota(@Valid Mascota mascota, Model model){
        mascotaService.save(mascota);
        return "redirect:/listarMascotas";
    }

    @GetMapping("/editarCliente/{id}")
    public String editarMascota(@PathVariable int id, Model model){
        Optional<Mascota> mascota = mascotaService.listarId(id);
        model.addAttribute("mascota",mascota);
        return "forms/formMascota";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarMascota(@PathVariable int id,Model model){
        mascotaService.delete(id);
        return "redirect:/listarMascotas";
    }

}