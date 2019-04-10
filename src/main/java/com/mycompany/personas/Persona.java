package com.mycompany.personas;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * La clase Persona representa al objeto que manipulara la base de datos, usando
 * el dni como identificador de cada objeto.
 * 
 * @author Franco Morbidoni
 * @version 1.0
 */
@Entity
public class Persona {
    @Id
    private final int DNI;
    private final String Nombre;
    private final String Apellido;
    private final int Edad;
    private final String Foto;

    /**
     *Constructor de la clase Persona
     * 
     * @param DNI El dni del individuo, ssirve como identificador.
     * @param Nombre El nombre del individio.
     * @param Apellido El apellido del individuo.
     * @param Edad Un numero entero representando la edad del individos en años.
     * @param Foto Direccion url de la ubicación de la foto.
     */
    public Persona(int DNI, String Nombre, String Apellido, int Edad, String Foto) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Foto = Foto;
    }

    /**
     * Método getter del DNI
     * @return DNI del individo.
     */
    public int getDNI() {
        return DNI;
    }

    /**
     * Método getter del Nombre.
     * @return Nombre del individuo.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Método getter del Apellido.
     * @return Apellido del individuo.
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * Método getter de la Edad.
     * @return Edad del individuo.
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * Método getter de la dirección registrada de la Foto.
     * @return String correspondiente a la ubicación de la foto.
     */
    public String getFoto() {
        return Foto;
    }
    
    
}
