package com.mycompany.personas;

import com.mycompany.personas.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-04-16T16:25:25")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ { 

    public static volatile SingularAttribute<Domicilio, Integer> codigo_postal;
    public static volatile SingularAttribute<Domicilio, Persona> persona;
    public static volatile SingularAttribute<Domicilio, Integer> numero;
    public static volatile SingularAttribute<Domicilio, String> calle;
    public static volatile SingularAttribute<Domicilio, String> localidad;
    public static volatile SingularAttribute<Domicilio, Integer> id;

}