package com.mycompany.personas;

/**
 * Esta clase genera el objeto respuesta que se adjunta con los resultados de 
 * las actividades de POST.
 * 
 * @author Franco Morbidoni
 */
public class Respuesta {
    private String respuesta;

    /**
     * Constructor del objeto.
     * @param respuesta String correspondiente a la respuesta.
     */
    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * Getter de la respuesta.
     * @return Respuesta asignada al mensaje.
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * Setter de la respuesta. 
     * @param respuesta Mensaje correspondiente a la respuesta.
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
}
