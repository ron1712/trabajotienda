package trabajotienda.rnegocio.impl;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.entidades.Tienda;
import trabajotienda.rnegocio.dao.ITienda;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.accesodatos.Conexion;
import trabajotienda.accesodatos.Parametro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TiendaImp implements ITienda{

    @Override
    public int insertar(Tienda tienda ) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into tienda values"+ "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, tienda.getCod_tienda()));
        lstPar.add(new Parametro(3, tienda.getNombre()));
        lstPar.add(new Parametro(4, tienda.getDireccion()));
        lstPar.add(new Parametro(5, tienda.getTelefono()));
        lstPar.add(new Parametro(2, tienda.getPersona().getCodigo()));
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
    public List<Tienda> obtener() throws Exception{
        List<Tienda> lista = new ArrayList<>();
        
        String sql="SELECT * FROM tienda;";
        Conexion con = null;
        try{
            Tienda tienda = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            while (rst.next()){
                tienda = new Tienda();
                tienda.setCod_tienda(rst.getInt(1));
                tienda.setNombre(rst.getString(3));
                tienda.setDireccion(rst.getString(4));
               tienda.setTelefono(rst.getString(5));
               IPersona personadao = new PersonaImp();
                Persona persona = personadao.obtener(rst.getInt(2));
                tienda.setPersona(persona);
                lista.add(tienda);
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
    public Tienda obtener(int codigo) throws Exception{
        
        return null;
    }  
}