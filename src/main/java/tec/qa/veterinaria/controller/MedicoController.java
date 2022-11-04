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

/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Controller
@RequestMapping
public class MedicoController {

    /*
    Se crea una instancia de la interfaz IMedicoService para poder utilizar los metodos.
     */
    @Autowired
    private IMedicoService medicoService;


    /*
    Parametros: Nada
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de login para medicos.
     */
    @GetMapping("/loginMedico")
    public String loginMedico(){
        return "medico/formLoginMedico";
    }

    /*
    Parametros: cédula del medico, contraseña del medico
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de bienvenida para medicos.
     */
    @PostMapping("/checkMedico")
    public String checkMedico(@Valid int id, String password){

        try {
            if (medicoService.login(id, password)){
               return "redirect:/menuMedico";
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/loginMedico";
    }

    /*
    Parametros: Nada
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de menu para medicos.
     */
    @GetMapping("/menuMedico")
    public String menuMedico(){
        return "medico/menuMedico";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de medicos.
     */
    @GetMapping("/listarMedicos")
    public String listarMedicos(Model model){
        List<Medico> medicos = medicoService.listar();
        model.addAttribute("medicos",medicos);
        return "medico/indexMedico";
    }

    /*
    Parametros: modelo
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de agregar medicos.
     */
    @GetMapping("/nuevoMedico")
    public String agregarMedico(Model model){
        model.addAttribute("medico",new Medico());
        return "medico/formMedico";
    }

    /*
    Parametros: modelo, medico
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de medicos
    posterior a agregar un medico.
     */
    @PostMapping("/guardarMedico")
    public String guardarCliente(@Valid Medico m, Model model){
        medicoService.save(m);
        return "redirect:/listarClientes";
    }

    /*
    Parametros: modelo, id del medico
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de editar medicos.
     */
    @GetMapping("/editarMedico/{id}")
    public String editarCliente(@PathVariable int id, Model model){
        Optional<Medico> medico = medicoService.listarId(id);
        model.addAttribute("medico",medico);
        return "medico/formMedico";
    }

    /*
    Parametros: modelo, id del medico
    Retorno: Direccion a nueva interfaz.
    Descripción: Funcion que se encarga de redirigir a la interfaz de listado de medicos
    posterior a eliminar un medico.
     */
    @GetMapping("/eliminarMedico/{id}")
    public String eliminarCliente(@PathVariable int id,Model model){
        medicoService.delete(id);
        return "redirect:/listarClientes";
    }


}