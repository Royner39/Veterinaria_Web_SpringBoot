package tec.qa.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Controller
@RequestMapping
public class MenuController {

    /*
    Parametros: N/A
    Retorno: String
    Descripción: Método que retorna el  menu principal
     */
    @GetMapping("/veterinaria")
    public String menu(){

        return "index";
    }
    /*
    Parametros: N/A
    Retorno: String
    Descripción: Funcion que se encarga de redirigir a la interfaz de ERROR.
     */
    @GetMapping("/error")
    public String error(){

        return "error";
    }

}