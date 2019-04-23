package com.mycompany.personas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase encargada de detectar y reccionar ante los pedidos de los usuarios.
 *
 * @author Franco Morbidoni
 * @version 1.4
 */
@RestController
public class Controlador {

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    DomicilioRepository domicilioRepository;
    
    /**
     * Método que detecta cuando el usuario desea agregar un objeto persona a la
     * base de datos.     *
     * 
     * @param persona Objeto persona a registrar en la base de datos.
     * @return Respuesta obtenida por el gestor de la base de datos.
     */
    @RequestMapping(value = "/personas", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity Agregar(@RequestBody Persona persona) {
        
        Respuesta respuesta = new Respuesta("Registrado.");
        ResponseEntity response = new ResponseEntity(respuesta, HttpStatus.CREATED);
        
        personaRepository.save(persona);
        return response;
    }

    /**
     * Método que detecta cuando los usuarios piden un listado de las personas
     * registradas en la base de datos.
     *
     * @return Listado de objetos Persona en la base de datos.
     */
    @RequestMapping(value = "/personas", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> Listado() {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findAll();
        
        ResponseEntity response = new ResponseEntity(listado, HttpStatus.FOUND);
        return response;
    }

    /**
     * Método que detecta cuando el usuario desea una lista filtrada por el dni.
     *
     * @param Dni Valor correspondiente al dni el usuario.
     * @return Listado de objetos Persona encontrados.
     */
    @RequestMapping(value = "/personas", method = RequestMethod.GET, params = "dni")
    public ResponseEntity<Persona> Listado(@RequestParam(value = "dni", defaultValue = "  ") int Dni) {
        Persona persona = personaRepository.findByDni(Dni);
        
        ResponseEntity response = new ResponseEntity(persona, HttpStatus.FOUND);
        return response;
    }

    /**
     * Método que detecta cuando el usuario desea una lista filtrada por un
     * nombre ingresado.
     *
     * @param Nombre String correspondiente al nombre de la persona.
     * @return Listado de objetos Persona encontrados.
     */
    @RequestMapping(value = "/personas", method = RequestMethod.GET, params = "nombre")
    public ResponseEntity<List<Persona>> Listado(@RequestParam(value = "nombre", defaultValue = "  ") String Nombre) {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findByNombreIgnoreCaseLike(Nombre);
        
        ResponseEntity response = new ResponseEntity(listado, HttpStatus.FOUND);
        return response;
    }

    /**
     * Método que genera una lista filtrada de personas según una edad ingresada
     * por parte del usuario.
     *
     * @param Edad int correspondiente a la edad de la persona.
     * @return Listado de objetos Persona encontrados.
     */
    @RequestMapping(value = "/personas", method = RequestMethod.GET, params = "edad")
    public ResponseEntity<List<Persona>> ListadoEdad(@RequestParam(value = "edad", defaultValue = "  ") int Edad) {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findByEdadLike(Edad);
        
        ResponseEntity response = new ResponseEntity(listado, HttpStatus.FOUND);
        return response;
    }
    
    /**
     * Método que registra un domicilio para una determinada persona segun su
     * dni.
     * 
     * @param dni Identificador de la persona.
     * @param domicilio Objeto domicilio a registrar.
     * @return Mensaje de confirmación.
     */
    @RequestMapping(value = "/personas/{dni}/domicilios", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Respuesta> AgregarDomicilio(@PathVariable("dni") int dni,
            @RequestBody Domicilio domicilio) {
        
        Persona persona = personaRepository.findByDni(dni);
     
        domicilio.setPersona(persona);
        
        Respuesta respuesta = new Respuesta("Registrado.");
        ResponseEntity response = new ResponseEntity(respuesta, HttpStatus.CREATED);
        
        domicilioRepository.save(domicilio);
        
        return response;
    }
    
    /**
     * Método que genera el listado de domicilios registrados para un individuo
     * en particular, segun su dni.
     * 
     * @param dni Identificador de la persona.
     * @return Listado de objetos domicilios encontrados.
     */
    @RequestMapping(value = "/personas/{dni}/domicilios", method = RequestMethod.GET)
    public ResponseEntity<List<Domicilio>> ListadoDomicilios(@PathVariable("dni") int dni){
        List<Domicilio> listado = new ArrayList<>();
        Persona persona = personaRepository.findByDni(dni);
        listado = domicilioRepository.findByPersona(persona);
        
        ResponseEntity response = new ResponseEntity(listado, HttpStatus.FOUND);
        return response;
    }
}
