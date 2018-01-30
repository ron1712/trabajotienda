package trabajotienda.rnegocio.impl;
import trabajotienda.rnegocio.entidades.Producto;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.rnegocio.dao.IProducto;
import trabajotienda.accesodatos.Conexion;
import trabajotienda.accesodatos.Parametro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoImp implements IProducto{

    @Override
    public int insertar(Producto producto ) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into producto values"+ "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCod_producto()));
        lstPar.add(new Parametro(3, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getStock()));
        lstPar.add(new Parametro(2, producto.getPersona().getCodigo()));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return numFilasAfectadas;
    }
    @Override
    public List<Producto> obtener() throws Exception{
        List<Producto> lista = new ArrayList<>();
        
        String sql="SELECT * FROM producto;";
        Conexion con = null;
        try{
            Producto producto = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            while (rst.next()){
                producto = new Producto();
                producto.setCod_producto(rst.getInt(1));
                producto.setNombre(rst.getString(3));
                producto.setStock(rst.getString(4));
                IPersona personadao = new PersonaImp();
                Persona persona = personadao.obtener(rst.getInt(2));
                producto.setPersona(persona);
                lista.add(producto);
           }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }  
    @Override
    public Producto obtener(int codigo) throws Exception{
        return null;
        
    }  
}