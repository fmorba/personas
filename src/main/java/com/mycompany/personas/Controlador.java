package com.mycompany.personas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Clase encargada de detectar y reccionar ante los pedidos de los usuarios.
 *
 * @author Franco Morbidoni
 * @version 1.0
 */
@RestController
public class Controlador {

    ImagenGenerador imagenGenerador = new ImagenGenerador();
    @Autowired
    PersonaRepository personaRepository;

    /**
     * Método que detecta cuando el usuario desea agregar un objeto persona a la
     * base de datos.
     *
     * @param Dni Identificador, dni de la persona.
     * @param Nombre String correspondiente al nombre de la persona.
     * @param Apellido String correspondiente al apellido de la persona.
     * @param edad int correspondiente a la edad de la persona.
     * @param filePart correspondiente a la ubicacion de la foto.
     * @return Respuesta obtenida por el gestor de la base de datos.
     */
    @RequestMapping(value = "/agregar", method = RequestMethod.POST,consumes = "multipart/form-data")
    public String Agregar(@RequestParam(value = "dni") int Dni,
            @RequestParam(value = "nombre", required = false) String Nombre,
            @RequestParam(value = "apellido", required = false) String Apellido,
            @RequestParam(value = "edad", required = false) int edad,
            @RequestParam(value = "file", required = false) MultipartFile filePart) {
        String foto= "Sin foto.";

        if (filePart!=null && filePart.getSize()> 0) {
           try {
                InputStream fileContent = filePart.getInputStream();
                Image image = ImageIO.read(fileContent);
                BufferedImage bi = imagenGenerador.createResizedCopy(image, 120, 120, true);
                foto = imagenGenerador.encodeToString(bi, "png");
            } catch (Exception e) {
                foto = "Sin foto.";
            }
        }

        Persona persona = new Persona(Dni, Nombre, Apellido, edad, foto);
        personaRepository.save(persona);
        return "Agregado.";
    }

    /**
     * Método que detecta cuando los usuarios piden un listado de las personas
     * registradas en la base de datos.
     *
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado")
    public List<Persona> Listado() {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findAll();
        return listado;
    }

    /**
     * Método que detecta cuando el usuario desea una lista filtrada por el dni.
     *
     * @param Dni Valor correspondiente al dni el usuario.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado_dni")
    public List<Persona> Listado(@RequestParam(value = "dni", defaultValue = "  ") int Dni) {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findByDniLike(Dni);
        return listado;
    }

    /**
     * Método que detecta cuando el usuario desea una lista filtrada por un
     * nombre ingresado.
     *
     * @param Nombre String correspondiente al nombre de la persona.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado_nombre")
    public List<Persona> Listado(@RequestParam(value = "nombre", defaultValue = "  ") String Nombre) {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findByNombreIgnoreCaseLike(Nombre);
        return listado;
    }

    /**
     * Método que genera una lista filtrada de personas según una edad ingresada
     * por parte del usuario.
     *
     * @param Edad int correspondiente a la edad de la persona.
     * @return Listado de objetos Persona, null en caso de estar vacio.
     */
    @RequestMapping("/listado_edad")
    public List<Persona> ListadoEdad(@RequestParam(value = "edad", defaultValue = "  ") int Edad) {
        List<Persona> listado = new ArrayList<>();
        listado = (List<Persona>) personaRepository.findByEdadLike(Edad);
        return listado;
    }

}
