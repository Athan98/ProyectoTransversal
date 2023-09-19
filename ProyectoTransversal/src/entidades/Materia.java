
package entidades;


public class Materia {
    private int id_materia=-1;
    private String nombre;
    private int anio;
    private boolean estado;

    public Materia(int id_materia, String nombre, int anio, boolean estado) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Materia(String nombre, int anio, boolean estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia() {
        this.id_materia=-1;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    @Override
    public String toString() {
        if (id_materia!=-1){
            return nombre + ", Año: " + anio + ", Estado: "+estado;
        }
        else{
        return "Seleccione materia";}
        
    }
    
}
