package trabajotienda.rnegocio.impl;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.accesodatos.Conexion;
import trabajotienda.accesodatos.Parametro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaImp implements IPersona{
    @Override
    public int insertar(Persona persona) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into persona values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, persona.getCodigo()));
        lstPar.add(new Parametro(2, persona.getNombre()));
        lstPar.add(new Parametro(3, persona.getTelefono()));
        lstPar.add(new Parametro(4, persona.getCedula()));
        

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
    public List<Persona> obtener() throws Exception{
        List<Persona> lista = new ArrayList<>();
        
        String sql="SELECT * FROM persona;";
        Conexion con = null;
        try{
            Persona persona = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            while (rst.next()){
                persona = new Persona();
                persona.setCodigo(rst.getInt(1));
                persona.setNombre(rst.getString(2));
                persona.setTelefono(rst.getString(3));
               persona.setCedula(rst.getString(4));

                lista.add(persona);
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
    public Persona obtener(int codigo) throws Exception{
        Persona persona = null;
        String sql="SELECT * FROM persona where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()){
                persona = new Persona();
                persona.setCodigo(rst.getInt(1));
                persona.setNombre(rst.getString(2));
                persona.setTelefono(rst.getString(3));
                persona.setCedula(rst.getString(4));
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return persona;
}
}

