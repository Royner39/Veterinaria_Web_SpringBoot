package tec.qa.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MenuController {

    @GetMapping("/veterinaria")
    public String menu(){

        return "index";
    }
    @GetMapping("/error")
    public String error(){

        return "error";
    }

}