
package data;

import java.sql.Connection;


public class Materia_data {
    
    private Connection conexion=null;
    
    public Materia_data(Conexion con){
    
        this.conexion=con.buscarConexion();
        
    }
    
    public void agregarMateria(){
    
    }
}
