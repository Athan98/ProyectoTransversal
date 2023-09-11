
package entidades;


public class Inscripcion {
    private int id_inscripcion=-1;
    private int nota;
    private Alumno id_alumno;
    private Materia id_materia;
    
    

    public Inscripcion(int id_inscripcion, int nota, Alumno id_alumno, Materia id_materia) {
        this.id_inscripcion = id_inscripcion;
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public Inscripcion(int nota, Alumno id_alumno, Materia id_materia) {
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public Inscripcion() {
        this.id_inscripcion=-1;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Alumno id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Materia getId_materia() {
        return id_materia;
    }

    public void setId_materia(Materia id_materia) {
        this.id_materia = id_materia;
    }

    @Override
    public String toString() {
        return "ID : "+id_inscripcion+", Apellido: "+id_alumno.getApellido()+", Nombre: "+id_alumno.getNombre()+", DNI: "+id_alumno.getDni()+", Materia: "+id_materia.getNombre();
    }
    
    
}
