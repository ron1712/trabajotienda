
package trabajotienda.rnegocio.impl;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.accesodatos.*;
import java.util.*;
import java.sql.*;


public class PersonaImpl implements IPersona {
    
     @Override
    public int insertar(Persona persona) throws Exception {
        int nFilas = 0;
        String csql = "Insert into persona (codigoc, nombre, apellido, telefono) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, persona.getCodigoc()));
        lstP.add(new Parametro(2, persona.getNombre()));
        lstP.add(new Parametro(3, persona.getApellido()));
        lstP.add(new Parametro(4, persona.getTelefono()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }
    
     @Override
    public Persona obtener(String codigo) throws Exception {
        Persona persona = null;
        String csql = "Select codigoc, nombre, apellido, telefono From persona Where codigoc=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                persona=new Persona();
                persona.setCodigoc(rst.getString(1));
                persona.setNombre(rst.getString(2));
                persona.setApellido(rst.getString(3));
                persona.setTelefono(rst.getString(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return persona;
    }
    
    
     @Override
    public ArrayList<Persona> obtener() throws Exception {
        ArrayList<Persona> personas = new ArrayList<>();
        String csql="select codigoc, nombre, apellido, telefono from persona";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Persona persona=null;
            while(rst.next()){
                persona=new Persona();
                persona.setCodigoc(rst.getString(1));
                persona.setNombre(rst.getString(2));
                persona.setApellido(rst.getString(3));
                persona.setTelefono(rst.getString(4));
           
                personas.add(persona);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return personas;
    }
    
}
