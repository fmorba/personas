package com.mycompany.personas;

import com.mycompany.personas.Domicilio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-04-22T14:02:33")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> foto;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile ListAttribute<Persona, Domicilio> domicilios;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, Integer> edad;
    public static volatile SingularAttribute<Persona, Integer> dni;

}