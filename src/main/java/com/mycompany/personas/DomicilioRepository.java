package com.mycompany.personas;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase que maneja el repositorio de los objetos pertenecientes a la clase 
 * domicilio.
 * 
 * @author Franco Morbidoni
 * @version 1.4
 */
@Repository
public interface DomicilioRepository extends CrudRepository<Domicilio, Long> {
    
    List<Domicilio> findByPersona(Persona persona);
}
