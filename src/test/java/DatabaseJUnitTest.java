import com.mycompany.personas.Aplicacion;
import com.mycompany.personas.Persona;
import com.mycompany.personas.PersonaRepository;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Franco Morbidoni
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacion.class)
public class DatabaseJUnitTest {
    @Autowired
    PersonaRepository personaRepository;
    
    public DatabaseJUnitTest() {        
        
    }
    
    /**
    * Test para verificar la generacion de listados completos.
    */
    @Test
    public void listadoTest(){
        personaRepository.save(new Persona(324,"Juan","Perez",33,"Sin Foto"));
        personaRepository.save(new Persona(314,"Luis","Perez",23,"Sin Foto"));
        List<Persona> test = (List<Persona>) personaRepository.findAll();
        assertEquals(test.size(), 2);
    }
    
    /**
     * Test para verificar el listado limitado por dni.
     */
    @Test
    public void listadoDniTest(){
        personaRepository.save(new Persona(324,"Juan","Perez",33,"Sin Foto"));
        personaRepository.save(new Persona(314,"Luis","Perez",23,"Sin Foto"));
        List<Persona> test = (List<Persona>) personaRepository.findByDniLike(314);
        assertEquals(test.size(), 1);
    }
   
    /**
     * Test para verificar listado filtrado por nombre.
     */
    @Test
    public void listadoNombreTest(){
        personaRepository.save(new Persona(324,"Juan","Perez",33,"Sin Foto"));
        personaRepository.save(new Persona(314,"Luis","Perez",23,"Sin Foto"));
        List<Persona> test = (List<Persona>) personaRepository.findByNombreIgnoreCaseLike("Luis");
        assertEquals(test.size(), 1);
    }
   
    /**
     * Test para verificar el listado filtrado por edad.
     */
    @Test
    public void listadoEdadTest(){
        personaRepository.save(new Persona(324,"Juan","Perez",33,"Sin Foto"));
        personaRepository.save(new Persona(314,"Luis","Perez",23,"Sin Foto"));
        List<Persona> test = (List<Persona>) personaRepository.findByEdadLike(33);
        assertEquals(test.size(), 1);
    }
}
