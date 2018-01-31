
package trabajotienda.rnegocio.impl;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.accesodatos.*;
import  java.util.*;
import java.sql.*;


public class TiendaImpl implements ITienda {
    
    @Override
    public int insertar(Tienda tienda) throws Exception {
        int Filas = 0;
        String csql = "Insert into tienda (codigoc, codigop, nombre, direccion) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, tienda.getPersona().getCodigoc()));
        lstP.add(new Parametro(2, tienda.getProducto().getCodigop()));
        lstP.add(new Parametro(3, tienda.getNombre()));
        lstP.add(new Parametro(4, tienda.getDireccion()));
      
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Filas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return Filas;
    }
    
    
    @Override
    public Tienda obtener(String codigo) throws Exception {
        Tienda trata = null;
        Persona persona=null;
        IPersona personaDao = new PersonaImpl();
        Producto producto=null;
        IProducto producDao=new ProductoImpl();
        String csql = "Select codigoc, codigop, nombre, direccion From tienda Where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                persona=new Persona();
                persona=personaDao.obtener(rst.getString(1));
                producto =new Producto();
                producto = producDao.obtener(rst.getString(2));
                trata=new Tienda();
                trata.setPersona(persona);
                trata.setProducto(producto);
                trata.setNombre(rst.getString(3));
                trata.setDireccion(rst.getString(4));
               
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return trata;
    }
    
    
    @Override
    public ArrayList<Tienda> obtener() throws Exception {
        ArrayList<Tienda> comps = new ArrayList<>();
        Persona persona=null;
        IPersona personaDao=new PersonaImpl();
        Producto producto=null;
        IProducto productoDao=new ProductoImpl();
        String csql="select codigoc, codigop, nombre, direccion from tienda";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Tienda comp=null;
            while(rst.next()){
                persona=new Persona();
                persona=personaDao.obtener(rst.getString(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getString(2));
                comp=new Tienda();
                comp.setPersona(persona);
                comp.setProducto(producto);
                comp.setNombre(rst.getString(3));
                comp.setDireccion(rst.getString(4));
             
                comps.add(comp);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return comps;
    }
}
