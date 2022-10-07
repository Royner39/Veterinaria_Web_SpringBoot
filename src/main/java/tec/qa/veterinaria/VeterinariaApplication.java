package tec.qa.veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VeterinariaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(VeterinariaApplication.class, args);

        ApplicationContext applicationContext = SpringApplication.run(VeterinariaApplication.class, args);
        SpringBeanLoader.setApplicationContext(applicationContext);
    }
}