package com.mycompany.personas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Clase encargada del almacenaje y busqueda de los datos almacenados en 
 * memoria mediante persistencia.
 * 
 * @author Franco Morbidoni
 */
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    
    List<Persona> findByDniLike(int DNI);
    
    List<Persona> findByNombreIgnoreCaseLike(String Nombre);
    
    List<Persona> findByEdadLike(int Edad);

}