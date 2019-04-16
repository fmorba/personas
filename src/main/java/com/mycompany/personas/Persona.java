package com.mycompany.personas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * La clase Persona representa al objeto que manipulara la base de datos, usando
 * el dni como identificador de cada objeto.
 * 
 * @author Franco Morbidoni
 * @version 1.4
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    @Id
    private int dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;
    @Column(name = "foto", length=16777216)
    private String foto;

    /**
     * Constructor vacio.
     */
    protected Persona() {}
    
    /**
     *Constructor de la clase Persona
     * 
     * @param dni El dni del individuo, ssirve como identificador.
     * @param nombre El nombre del individio.
     * @param apellido El apellido del individuo.
     * @param edad Un numero entero representando la edad del individos en años.
     * @param foto Direccion url de la ubicación de la foto.
     */
    public Persona(int dni, String nombre, String apellido, int edad, String foto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.foto = foto;
    }

    /**
     * Método getter del dni
     * @return dni del individo.
     */
    public int getDni() {
        return dni;
    }

    /**
     * Método getter del Nombre.
     * @return Nombre del individuo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getter del Apellido.
     * @return Apellido del individuo.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método getter de la Edad.
     * @return Edad del individuo.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método getter de la dirección registrada de la Foto.
     * @return String correspondiente a la ubicación de la foto.
     */
    public String getFoto() {
        return foto;
    }
    
    
}
