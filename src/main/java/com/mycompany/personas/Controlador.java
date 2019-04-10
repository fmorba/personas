package com.mycompany.personas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.pkcs11.Secmod;

/**
 * Clase encargada de detectar y reccionar ante los pedidos de los usuarios.
 * @author Franco Morbidoni
 * @version 1.0
 */
@RestController
public class Controlador {
    Database DB = new Database();
       
    /**
     * Método que detecta cuando el usuario desea agregar un objeto persona a la
     * base de datos.
     * 
     * @param Dni Identificador, dni de la persona.
     * @param Nombre String correspondiente al nombre de la persona.
     * @param Apellido String correspondiente al apellido de la persona.
     * @param edad int correspondiente a la edad de la persona.
     * @param foto String correspondiente a la ubicacion de la foto.
     * @return Respuesta obtenida por el gestor de la base de datos.
     */
    @RequestMapping("/agregar")
    public String Agregar(@RequestParam(value ="dni",defaultValue ="  ") int Dni, 
            @RequestParam(value ="nombre",defaultValue ="  ") String Nombre, 
            @RequestParam(value ="apellido",defaultValue ="  ") String Apellido, 
            @RequestParam(value ="edad",defaultValue ="  ") int edad,
            @RequestParam(value ="foto",defaultValue ="  ") String foto){
        
        Persona persona = new Persona(Dni, Nombre, Apellido, edad, foto);        
        String Respuesta=DB.Agregar(persona);
        return Respuesta;
    }
    
    /**
     * Método que detecta cuando los usuarios piden un listado de las personas 
     * registradas en la base de datos.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado")
    public List<String> Listado(){
        List<String> listado = new ArrayList<>();
        listado=DB.Listado();
        return listado;
    }
    
    /**
     * Método que detecta cuando el usuario desea una lista filtrada por el dni.
     * @param Dni Valor correspondiente al dni el usuario.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado_dni")
    public List<String> Listado(@RequestParam(value ="dni",defaultValue ="  ") int Dni){
        List<String> listado = new ArrayList<>();
        listado=DB.ListadoDNI(Dni);
        return listado;
    }
    
    /**
     * Método que detecta cuando el usuario desea una lista filtrada por un 
     * nombre ingresado.
     * @param Nombre String correspondiente al nombre de la persona.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado_nombre")
    public List<String> Listado(@RequestParam(value ="nombre",defaultValue ="  ") String Nombre){
        List<String> listado = new ArrayList<>();
        listado=DB.ListadoNombre(Nombre);
        return listado;
    }
    
    /**
     * Método que genera una lista filtrada de personas según una edad ingresada
     * por parte del usuario.
     * @param Edad int correspondiente a la edad de la persona.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado_edad")
    public List<String> ListadoEdad(@RequestParam(value ="edad",defaultValue ="  ") int Edad){
        List<String> listado = new ArrayList<>();
        listado=DB.ListadoEdad(Edad);
        return listado;
    }
    
}
