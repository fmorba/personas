/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.personas.Database;
import com.mycompany.personas.Persona;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase encargada del testeo del funcionamiento de la base de datos.
 * @author Franco Morbidoni
 * @version 1.0
 */
public class DatabaseJUnitTest {
    private Database DBTest = new Database();
    
    /**
     * Test para verificar la conexión con la base de datos.
     */
    @Test
    public void databaseConexion(){
        String resultado = DBTest.Conexion();
        assertEquals(resultado,"Conectado.");
    }
    
    /**
     * Test para verificar la creación de la tabla inicial.
     */
    @Test
    public void databaseCrearTabla(){
	String resultado = DBTest.CrearTabla();
        assertTrue(resultado.contains("personas_tbl"));
    }
    
    /**
     * Test de verificación del ingreso de datos.
     */
    @Test
    public void databaseAgregar(){
        Persona personaTest = new Persona(35669789, "Luis", "Rocco", 30, "https://defin.com/content/uploads/2016/foto.jpg");
	String resultado = DBTest.Agregar(personaTest);
        assertEquals(resultado, "1 filas insertadas.");
    }
    
    /**
     * Test de generación de listado de objetos registrados.
     */
    @Test
    public void databaseListado(){
        List<String> resultado = new ArrayList();
        resultado = DBTest.Listado();
        assertNotNull(resultado);
    }
    
    /**
     * Test de generación de listado filtrado por nombre de los registros. 
     */
    @Test
    public void databaseListadoNombre(){
        List<String> resultado = new ArrayList();
        resultado = DBTest.ListadoNombre("Luis");
        assertNotNull(resultado);
    }
    
    /**
     *Test de generación de listado filtrado por dni de los registros. 
     */
    @Test
    public void databaseListadoDNI(){
        List<String> resultado = new ArrayList();
        resultado = DBTest.ListadoDNI(35669789);
        assertNotNull(resultado);
    }
    
    /**
     * Test de generación de listado filtrado por edad de los registros. 
     */
    @Test
    public void databaseListadoEdad(){
        List<String> resultado = new ArrayList();
        resultado = DBTest.ListadoEdad(30);
        assertNotNull(resultado);
    }

}
