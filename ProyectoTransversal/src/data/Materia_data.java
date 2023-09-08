
package data;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;



public class Materia_data {
    
    private Connection conexion=null;
    
    public Materia_data(Conexion con){
    
        this.conexion=con.buscarConexion();
        
    }
    
    public void agregarMateria(Materia materia){
        
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?,?,?);";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2,materia.getAnio());
            ps.setBoolean(3,materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));           
                JOptionPane.showMessageDialog(null,"Materia agregada exitosamente");
            }else{
                JOptionPane.showMessageDialog(null,"Error al obtener el ID");
            }           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia");
        }
    }
    
    public void buscarMateriaPorId(int id ){
        
    }
    
    public List listarMateria(String apellido){
        
        
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
