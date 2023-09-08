
package data;

import java.sql.Connection;


public class Inscripcion_data {
    private Connection conexion=null;
    
    public Inscripcion_data(Conexion con){
        this.conexion=con.buscarConexion();   
    }
}
