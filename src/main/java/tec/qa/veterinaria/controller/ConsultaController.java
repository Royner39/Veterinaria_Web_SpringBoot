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
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */


@Controller
@RequestMapping
public class ConsultaController {

    /*
    Se crea una instancia de la interfaz IConsultaService para poder utilizar los metodos.
    */
    @Autowired
    private IConsultaService consultaService;

    /*
    Parametros: modelo, mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de consultas.
    */
    @GetMapping("/verConsultas/{id_mascota}")
    public String listarConsultasCliente(@PathVariable int id_mascota, Model model){
        List<Consulta> consultas = consultaService.listar();
        model.addAttribute("consultas",consultas);
        return "consulta/viewCliente/indexConsulta";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de consultas.
     */
    @GetMapping("/listarConsultas")
    public String listarConsultasMedico(Model model){
        List<Consulta> consultas = consultaService.listar();
        model.addAttribute("consultas",consultas);
        return "consulta/viewMedico/indexConsulta";
    }

    /*
    Parametros: modelo, id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de generar una nueva consulta.
     */
    @GetMapping("/nuevaConsulta/{id_mascota}")
    public String agregarConsulta(@PathVariable int id_mascota, Model model){
        model.addAttribute("consulta",new Consulta());
        return "consulta/viewMedico/formConsulta";
    }

    /*
    Parametros: modelo, consulta y id de la mascota
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz listado de
    consultas asociadas a un cliente
     */
    @PostMapping("/guardarConsulta/{id_mascota}")
    public String guardarConsulta(@PathVariable int id_mascota, @Valid Consulta consulta, Model model){
        consultaService.save(consulta);
        return "redirect:/listarConsultas";
    }

    /*
    Parametros: modelo, id de la consulta
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de editar una consulta.
     */
    @GetMapping("/editarConsulta/{id}")
    public String editarConsulta(@PathVariable int id, Model model){
        Optional<Consulta> consulta = consultaService.listarId(id);
        model.addAttribute("consulta",consulta);
        return "consulta/viewMedico/formConsulta";
    }

    /*
    Parametros: modelo, id de la consulta
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de eliminar una consulta.
     */
    @GetMapping("/eliminarConsulta/{id}")
    public String eliminarConsulta(@PathVariable int id,Model model){
        consultaService.delete(id);
        return "redirect:/listarConsultas";
    }

}
