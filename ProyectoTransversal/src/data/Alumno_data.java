package data;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class Alumno_data {

    private Connection conexion = null;

    public Alumno_data(Conexion con) {
        this.conexion = con.buscarConexion();
    }

    public void agregarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNac,estado) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El alumno fue cargado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }

    public List listarAlumnosPorApellido(String apellido) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE apellido LIKE ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, apellido + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return alumnos;
    }

    public List listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return alumnos;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        String sql = "SELECT * FROM alumno WHERE dni=?";
        Alumno alumno = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return alumno;
    }

    public void modificarEstadoAlumno(int dni, boolean estado) {
        String sql = "UPDATE alumno SET estado=? WHERE dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setInt(2, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estado del alumno ha sido actualizado");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

    }
    
    public void eliminarAlumno(int dni){
    
        String sql="DELETE FROM alumno WHERE dni=?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        
    }

}
