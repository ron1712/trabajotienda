
package trabajotienda.rnegocio.impl;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.accesodatos.*;
import java.util.*;
import java.sql.*;


public class ProductoImpl implements IProducto {
    public int insertar(Producto producto) throws Exception {
        int nFilas = 0;
        String csql = "Insert into producto (codigop, nombre) Values (?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, producto.getCodigop()));
        lstP.add(new Parametro(2, producto.getNombre()));
        
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
       public Producto obtener(String codigo) throws Exception {
        Producto producto = null;
        String csql = "Select codigop, nombre from producto where codigop=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                producto=new Producto();
                producto.setCodigop(rst.getString(1));
                producto.setNombre(rst.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return producto;
    }
    
      @Override
    public ArrayList<Producto> obtener() throws Exception {
        ArrayList<Producto> productos = new ArrayList<>();
        String csql="select codigop, nombre from producto";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar(); 
            ResultSet rst=con.ejecutarQuery(csql, null);
            Producto producto=null;
            while(rst.next()){
                producto=new Producto();
                producto.setCodigop(rst.getString(1));
                producto.setNombre(rst.getString(2));
                
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return productos;
    }
    
    
}
