package data;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Inscripcion_data {

    private Connection conexion = null;

    public Inscripcion_data(Conexion con) {
        this.conexion = con.buscarConexion();
    }

    public void inscribirAlumno(Alumno alumno, Materia materia) {
        Inscripcion inscripcion = new Inscripcion();

        String sql = "INSERT INTO inscripcion(nota,id_alumno,id_materia) VALUES (?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 0);
            ps.setInt(2, alumno.getId_alumno());
            ps.setInt(3, materia.getId_materia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setId_inscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion agregada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo agregar la inscripcion");
        }

    }

    public void calificarAlumno(int nota, int dni, String nombreMateria) {

        String sql = "UPDATE inscripcion i JOIN alumno a ON(i.id_alumno=a.id_alumno) "
                + "JOIN materia m ON(i.id_materia=m.id_materia) SET nota=?  WHERE a.dni=? "
                + "AND m.nombreMateria LIKE ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, dni);
            ps.setString(3, nombreMateria);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, sentencia invalida");
        }
    }

    public List listarInscripciones() {
        List<Inscripcion> inscripcionesList = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion JOIN alumno ON (inscripcion.id_alumno=alumno.id_alumno) JOIN materia ON (inscripcion.id_materia=materia.id_materia)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();
                inscripcion.setId_inscripcion(rs.getInt("id_Inscripcion"));
                inscripcion.setId_alumno(alumno);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                inscripcion.setId_materia(materia);
                materia.setNombre(rs.getString("nombreMateria"));
                inscripcion.setNota(rs.getInt("nota"));

                inscripcionesList.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return inscripcionesList;
    }

    public List listarInscripcionesPorAlumno(int dni) {
        List<Inscripcion> inscripcionesList = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion JOIN alumno ON (inscripcion.id_alumno=alumno.id_alumno) JOIN materia ON (inscripcion.id_materia=materia.id_materia) WHERE alumno.dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();
                inscripcion.setId_inscripcion(rs.getInt("id_Inscripcion"));
                inscripcion.setId_alumno(alumno);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setId_alumno(rs.getInt("id_alumno"));
                materia.setAnio(rs.getInt("anio"));
                materia.setId_materia(rs.getInt("id_materia"));
                inscripcion.setId_materia(materia);
                materia.setNombre(rs.getString("nombreMateria"));
                inscripcion.setNota(rs.getInt("nota"));
                inscripcionesList.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia XD");
        }
        return inscripcionesList;
    }

    public List listarMateriasNOCursadasPorAlumno(int dni) {
        List<Materia> materiasList = new ArrayList<>();
        String sql = "SELECT * FROM materia m WHERE m.id_materia NOT IN ( SELECT i.id_materia FROM inscripcion i JOIN alumno a ON i.id_alumno = a.id_alumno WHERE a.dni = ? )";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombreMateria"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));
                materiasList.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return materiasList;
    }

    public List listarMateriasCursadasPorAlumno(int dni) {
        List<Materia> materiasList = new ArrayList<>();
        String sql = "SELECT * FROM materia m WHERE m.id_materia IN ( SELECT i.id_materia FROM inscripcion i JOIN alumno a ON i.id_alumno = a.id_alumno WHERE a.dni = ? )";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombreMateria"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));
                materiasList.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return materiasList;
    }

    public List listarAlumnosPorMateria(String nombreMateria) {

        List<Alumno> alumnosList = new ArrayList<>();
        String sql = "SELECT * FROM alumno a JOIN inscripcion i ON (a.id_alumno = i.id_alumno) JOIN materia m ON (i.id_materia = m.id_materia) WHERE m.nombreMateria LIKE ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreMateria + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosList.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return alumnosList;
    }

    public void eliminarInscripcion(int dni, String nombreMateria) {
        String sql = "DELETE FROM inscripcion WHERE id_alumno IN (SELECT id_alumno FROM alumno WHERE dni = ?) AND id_materia IN (SELECT id_materia FROM materia WHERE nombreMateria LIKE ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.setString(2, nombreMateria + "%");
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "La inscripcion ha sido eliminada exitosamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

    }
}
