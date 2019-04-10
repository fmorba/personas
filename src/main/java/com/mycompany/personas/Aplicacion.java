package com.mycompany.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase de inicio de la aplicación.
 * @author Franco Mordidoni
 * @version 1.0
 */
@SpringBootApplication
public class Aplicacion extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Aplicacion.class);
    }
    
    public static void main(String[] args) {
       
       SpringApplication.run(Aplicacion.class, args);
    }
    
}
