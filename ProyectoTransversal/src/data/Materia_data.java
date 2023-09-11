
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
    
    
    public List listarMateria(String apellido){
        List<Materia> lista = new ArrayList();
        Materia materia = null;
        String sql = "SELECT FROM materia WHERE apellido LIKE ?";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1, apellido + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado")); 
                lista.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return lista;
    }
    
    
    public void modificarMateria(String nombre){
        String sql="UPDATE materia SET ";
        
        String cambioEstado="estado=? WHERE nombre LIKE "+nombre;
        //String cambioNombre="nombre=? WHERE nombre LIKE "+nombre;
        //String cambioAnio="anio=? WHERE nombre LIKE "+nombre;

        sql=sql+cambioEstado;
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setBoolean(1, false);
            //ps.setString(1, "nuevoNombre");
            //ps.setInt(1, nuevoAnio);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estado de la materia ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }    
    }    
    
}
