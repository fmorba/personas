# personas

Test Técnico 
 
Problema
Implementar una solución que permita guardar y listar una/s  Entidad/es Persona/s con las siguientes características:
PERSONA
A ) DNI (ID)
B) Nombre
C) Apellido
D) Edad
E) Foto

A implementar:
Listado de personas: METHOD GET (Respetar convenciones en la url)
Listado filtrado por A B y D: METHOD GET (Utilizar query parameters y respetar convenciones)
Alta de persona: METHOD POST (Respetar convenciones en la url). Que reciba la foto también.

Consideraciones:
Utilizar maven 
Definir un pom y hacer uso de Dependency Management de maven 
Utilizar Spring Framework
Usar annotations 
Las Entidades denotadas con el estándar JPA  (paquete  javax.persistence.*)
manejo de excepciones
Unit test completo con JUNIT
Utilizar DB en memoria hsqldb o mysql (a libre elección)
El proyecto tiene que ser deployable en JBOSS o Wildfly 

