package com.mycompany.personas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que controla las funciones basicas en relación con la base de datos, 
 * incluyendo la conexión, y transferencia de datos.
 * 
 * @author Franco Morbidoni
 * @version 1.0
 */
public class Database {
        
    /**
     * Constructor de la clase, inicia la conexión y crea la tabla inicial.
     */
    public Database(){
        this.Conexion();
        this.CrearTabla();
    }
    
    /**
     * Método que se encarga de realizar la conexion con la base de datos.
     * @return Mensaje correspondiente al estado de la conexión.
     */
    public String Conexion(){
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        String respuesta="";
        
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
            if (con!= null){
                respuesta="Conectado.";
            
            }else{
                respuesta="Fallo al crear.";
            }      
        }catch (Exception e) {
            respuesta=e.getMessage();
        }    
        return respuesta;
    }
    
    /**
     * Método encargado de crear la tabla inicial.
     * @return String correspondiente al estado de la actividad.
     */
    public String CrearTabla(){
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        String respuesta="";
        
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
            stmt = con.createStatement();
         
            result = stmt.executeUpdate("CREATE TABLE personas_tbl (dni INT NOT NULL, nombre VARCHAR(50) NOT NULL, apellido VARCHAR(50) NOT NULL, edad int, foto VARCHAR(350),PRIMARY KEY (dni));");
            respuesta="Tabla creada.";		
         
        } catch (Exception e) {
            respuesta=e.getMessage();
        }    
        return respuesta;      
   }
    
    /**
     * Método que se encarga de ingresar los datos obtenidos a la base de datos.
     * @param persona Objeto de la clase persona, con los datos necesarios.
     * @return String correspondiente al estado de la actividad.
     */
    public String Agregar(Persona persona){
       Connection con = null;
       Statement stmt = null;
       int result = 0;
       String respuesta="";
        
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
            con = DriverManager.getConnection( "jdbc:hsqldb:mem:.", "SA", ""); 
            stmt = con.createStatement(); 
            String query= "INSERT INTO personas_tbl VALUES ("+persona.getDNI()+",\'"+persona.getNombre()+"\',"+"\'"+persona.getApellido()+"\',"+persona.getEdad()+",\'"+persona.getFoto()+"\');";
            result = stmt.executeUpdate(query); 
            con.commit(); 
            respuesta=result+" filas insertadas."; 
        }catch (Exception e) { 
            respuesta=e.getMessage();
        } 
        return respuesta;  
   }
   
    /**
     * Método cuya tarea consiste en generar un listado de las personas 
     * registradas en la base de datos.
     * @return Lista de objetos, o null en caso de no haber ninguno registrado.
     */
    public List Listado(){
       Connection con = null;
       Statement stmt = null;
       int result = 0;
       List<String> respuesta = new ArrayList<>();
       ResultSet resu = null; 
       
       try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
            stmt = con.createStatement();
            resu = stmt.executeQuery("SELECT * FROM personas_tbl;");
         
            while(resu.next()){
                 String aux = resu.getInt("dni")+" | "+resu.getString("nombre")+" | "+resu.getString("apellido") + " | "+resu.getInt("edad")+" | "+resu.getString("foto")+ " |||";
                 respuesta.add(aux);
            }         
        } catch (Exception e) {
            respuesta=null;
        }    
        return respuesta;  
   }
   
    /**
     * Método que genera una lista de objetos en base a un Nombre ingresado.
     * @param Nombre String correspondiente al nombre de una persona.
     * @return Lista de objetos, o null en caso de no haber ninguno registrado.
     */
    public List ListadoNombre(String Nombre){
       Connection con = null;
       Statement stmt = null;
       List<String> respuesta = new ArrayList<>();
       ResultSet resu = null; 
       
       try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
            stmt = con.createStatement();
            resu = stmt.executeQuery("SELECT * FROM personas_tbl WHERE nombre LIKE \'"+Nombre+"%\';");
         
            while(resu.next()){
                 String aux = resu.getInt("dni")+" | "+resu.getString("nombre")+" | "+resu.getString("apellido") + " | "+resu.getInt("edad")+" | "+resu.getString("foto")+ " ||| ";
                 respuesta.add(aux);
            }         
        } catch (Exception e) {
            respuesta=null;
        }    
        return respuesta;  
   }
   
    /**
     * Método que genera un listado de objetos en base a un dni ingresado.
     * @param dni Variable int correspondiente al dni de una persona.
     * @return Lista de objetos, o null en caso de no haber ninguno registrado.
     */
    public List ListadoDNI(int dni){
       Connection con = null;
       Statement stmt = null;
       List<String> respuesta = new ArrayList<>();
       ResultSet resu = null; 
       
       try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
            stmt = con.createStatement();
            resu = stmt.executeQuery("SELECT * FROM personas_tbl WHERE dni LIKE \'"+dni+"%\';");
         
            while(resu.next()){
                 String aux = resu.getInt("dni")+" | "+resu.getString("nombre")+" | "+resu.getString("apellido") + " | "+resu.getInt("edad")+" | "+resu.getString("foto")+ " ||| ";
                 respuesta.add(aux);
            }         
        } catch (Exception e) {
            respuesta=null;
        }    
        return respuesta;  
   }
   
    /**
     * Método que genera un listado de objetos en base a una edad ingresada.
     * @param edad Variable int correspondiente a la edad de una persona.
     * @return Lista de objetos, o null en caso de no haber ninguno registrado.
     */
    public List ListadoEdad(int edad){
       Connection con = null;
       Statement stmt = null;       
       List<String> respuesta = new ArrayList<>();
       ResultSet resu = null; 
       
       try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
            stmt = con.createStatement();
            resu = stmt.executeQuery("SELECT * FROM personas_tbl WHERE edad LIKE \'"+edad+"%\';");
         
            while(resu.next()){
                 String aux = resu.getInt("dni")+" | "+resu.getString("nombre")+" | "+resu.getString("apellido") + " | "+resu.getInt("edad")+" | "+resu.getString("foto")+ " ||| ";
                 respuesta.add(aux);
            }         
        } catch (Exception e) {
            respuesta=null;
        }    
        return respuesta;  
   }
    
}
