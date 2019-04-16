package com.mycompany.personas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que modela al objeto domicilio.
 * 
 * @author Franco Morbidoni
 * @version 1.4
 */
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {
   @Id
   @GeneratedValue( strategy= GenerationType.AUTO ) 
   private int id;
   @Column(name = "calle")
   private String calle;
   @Column(name = "numero")
   private int numero;
   @Column(name = "codigo_postal")
   private int codigo_postal;
   @Column(name = "localidad")
   private String localidad;
   
   @ManyToOne
   private Persona persona;

    /**
     * Constructor vacio.
     */
    public Domicilio() {
   }

    /**
     * Contructor inicial del objeto, para introducir sus caracteristicas 
     * básicas.
     * 
     * @param calle String correspondiente al nombre de la calle del domicilio.
     * @param numero int correspondiente al numero del domicilio.
     * @param codigo_postal int correspondiente al codigo postal de la 
     * localidad donde se alla el domicilio.
     * @param localidad String correspondiente al nombre de dicha localidad.
     */
    public Domicilio(String calle, int numero, int codigo_postal, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.localidad = localidad;
   }

    /**
     * Método getter del identificador del objeto.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Método setter del identificador.
     * @param id identificador del objeto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método getter de la calle del domicilio.
     * @return String correspondiente al nombre de la calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método setter del nombre de la calle.
     * @param calle String correspondiente al nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método getter del nombre del domicilio.
     * @return int correspondiente al numero registrado.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método setter del numero de la calle.
     * @param numero int correspondiente al numero.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método getter del código postal de la localidad.
     * @return int correspondiente al código postal.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Método setter del código postal.
     * @param codigo_postal numero del código postal.
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Método getter del nombre de la localidad.
     * @return String correspondiente al nombre de la localidad.
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Método  setter de la localidad.
     * @param localidad Nombre de la localidad.
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Método getter para recuperar la información de la persona a la que le 
     * pertenece el domicilio.
     * @return Objeto persona.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método setter para introducir los datos del dueño del domicilio.
     * @param persona Objeto persona correspodiente al dueño del domicilio.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
   
   
   
}
