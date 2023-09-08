
package data;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class Alumno_data {
    private Connection conexion=null;
    
    public Alumno_data(Conexion con){
        this.conexion=con.buscarConexion();   
    }
    
    public void agregarAlumno(Alumno alumno){
    
        String sql="INSERT INTO alumno(dni,apellido,nombre,fechaNac,estado) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
            alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El alumno fue cargado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }
    
    public void buscarAlumnoPorId(int id ){}
    
    public List listarAlumnos(String apellido){
        
        
        return null;
    }
    
    public void buscarAlumnoPorDni(int dni){
        
    
    }
    
    public void actualizarEstadoAlumno(int dni){
        String sql="UPDATE alumno SET estado=0 WHERE dni=?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estado del alumno ha sido actualizado");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    
    }
    
    
    
    
}
