package tec.qa.veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@SpringBootApplication
public class VeterinariaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(VeterinariaApplication.class, args);

        ApplicationContext applicationContext = SpringApplication.run(VeterinariaApplication.class, args);
        SpringBeanLoader.setApplicationContext(applicationContext);
    }
}