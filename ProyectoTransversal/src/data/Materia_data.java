
package data;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vistas.GestionMateria;



public class Materia_data {
    
    private Connection conexion=null;
    
    public Materia_data(Conexion con){
    
        this.conexion=con.buscarConexion();
        
    }
    
    public List listarMaterias(){
        List  <Materia> materiaList = new ArrayList<>();
        String  sql="SELECT * FROM materia ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombreMateria"));
                materia.setEstado(rs.getBoolean("estado"));
                materia.setAnio(rs.getInt("anio"));
                materiaList.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return materiaList;
        
        
     
    }    
    
    
    public void agregarMateria(Materia materia){
        
        String sql = "INSERT INTO materia (nombreMateria, anio, estado) VALUES (?,?,?);";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2,materia.getAnio());
            ps.setBoolean(3,materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));           
            }else{
                JOptionPane.showMessageDialog(null,"Error al obtener el ID");
            }           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia");
        }
    }    
    

    public Materia buscarMateria(String nombreMateria){
        Materia materia = null;
        
        String sql="SELECT * FROM materia WHERE nombreMateria LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1, nombreMateria + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                materia=new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombreMateria"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));                 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }        
        return materia;
    }
    
    public void modificarMateria(String nombreMateria, int anio, boolean estado){
        String sql="UPDATE materia SET anio=?,estado=? WHERE nombreMateria LIKE ?";

        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);            
            ps.setInt(1, anio);
            ps.setBoolean(2, estado);
            ps.setString(3, nombreMateria);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La materia ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }    
    }

    public void modificarEstado(String nombreMateria, boolean estado){
        String sql="UPDATE materia SET estado=? WHERE nombreMateria LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2, nombreMateria);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estado de la materia ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }
    
    public void eliminarMateria(String nombre){
    

        String sql="DELETE FROM materia WHERE nombreMateria LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La materia ha sido eliminada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error. La materia se encuentra vinculada");
        } catch (Exception e){
          JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
    
}
