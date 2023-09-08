/*
La Universidad de La Punta cree necesario utilizar un sistema para poder llevar el registro de
los alumnos de la institución y las materias que se dictan en la misma. Adicionalmente se
necesita poder registrar las materias que cursa cada alumno. El sistema debe permitir cargar la
calificación obtenida (nota) cuando un alumno rinde un examen final. Para cada materia que
cursa un alumno solo se registrará la última calificación obtenida, o sea no se mantiene registro
de las notas obtenidas anteriormente, por lo que, si un alumno rinde el examen final de una
materia y obtiene una calificación de “2”, y luego rinde nuevamente el examen para la materia
y obtiene una calificación de “9” solo quedará registro de esta última.

Funcionalidad: el sistema deberá
1. Permitir al personal administrativo listar las materias que cursa un alumno.
2. Permitir al personal administrativo listar los alumnos inscriptos en una determinada materia.
3. Permitir que un alumno se pueda inscribir o des-inscribir en las materias que desee.
4. Permitir registrar la calificación final de una materia que está cursando un alumno.
5. Permitir el alta, baja y modificación de los alumnos y las materias.
 */
package proyectotransversal;


import java.time.LocalDate;
import data.*;
import entidades.*;

public class ProyectoTransversal {


    public static void main(String[] args) {
        Conexion con=new Conexion("jdbc:mariadb://localhost:3306/proyecto_transversal","root","");
        Alumno_data ad=new Alumno_data(con);
        Materia_data md=new Materia_data(con);
        Alumno alumno=new Alumno(41339109,"Roldan","Nicolas",LocalDate.of(1998, 10, 26),true);
        //ad.agregarAlumno(alumno);
        Materia materia = new Materia("Algebra 1",1,true);
        //md.agregarMateria(materia);
    }
    
}
