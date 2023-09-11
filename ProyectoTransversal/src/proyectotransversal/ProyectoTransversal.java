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
import java.util.ArrayList;
import java.util.List;

public class ProyectoTransversal {


    public static void main(String[] args) {

        Conexion con=new Conexion("jdbc:mariadb://localhost:3306/proyecto_transversal","root","");
        Alumno_data ad=new Alumno_data(con);
        Materia_data md=new Materia_data(con);
        Alumno alumno=new Alumno(41339109,"Roldan","Nicolas",LocalDate.of(1998, 10, 26),true);
//        ad.agregarAlumno(alumno);
//        ad.modificarEstadoAlumno(41339109, true);
//        PRUEBA LISTAR
        Alumno alumno2=new Alumno(13467088,"Rodriguez","Ignacio",LocalDate.of(1958, 7, 26),true);
//        ad.agregarAlumno(alumno2);
        Alumno alumno3=new Alumno(39993976,"Rech","Pablo",LocalDate.of(1996, 1, 20),true);
//        ad.agregarAlumno(alumno3);
        Alumno alumno4=new Alumno(40222369,"Fernandez","Juan",LocalDate.of(1997, 12, 01),true);
//        ad.agregarAlumno(alumno4);
//        List<Alumno>alumnos=ad.listarAlumnosPorApellido("R");
//        for(Alumno a:alumnos){
//            System.out.println(a.toString());
//        }
//        
//        System.out.println(ad.buscarAlumnoPorDni(41339109));

         Inscripcion_data id=new Inscripcion_data(con);
//         System.out.println(id.listarInscripciones());
//         System.out.println(id.listarInscripcionesPorAlumno(39993976));
//         System.out.println(id.listarMateriasNOCursadasPorAlumno(39993976));
//          System.out.println(id.listarMateriasCursadasPorAlumno(39993976));
//           System.out.println(id.listarAlumnosPorMateria("Calculo"));

//           id.eliminarInscripcion(41339109, "Calculo");

//           System.out.println(ad.listarAlumnos());
     
    }
    
}
