
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
    
    public void modificarMateria(String nombre, boolean estado){
        String sql="UPDATE materia SET estado=? WHERE nombre LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setString(2, nombre);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estado de la materia ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    
    }
    
    
}
