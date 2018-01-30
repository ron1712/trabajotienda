package trabajotienda.Test;
import trabajotienda.rnegocio.entidades.Tienda;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.dao.ITienda;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.rnegocio.impl.TiendaImp;
import trabajotienda.rnegocio.impl.PersonaImp;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TiendaTest {
    public TiendaTest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        ITienda tiendaDao = new TiendaImp();
        IPersona personaDao = new PersonaImp();
        Persona persona = personaDao.obtener(3);
        Tienda tienda = new Tienda(2,persona,"Minimarket","Ayacucho y New york", "987123");
        try{
            filasAfectadas = tiendaDao.insertar(tienda);
            System.out.println("Tienda ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Tienda> lista = new ArrayList<>();
        try {
            lista = tiendaDao.obtener();
            for (Tienda c:lista){
                System.out.println("Id_persona :"+c.getPersona().getCodigo());
                System.out.println("Codigo :"+c.getCod_tienda());
                System.out.println("NOmbre  :"+c.getNombre());
            System.out.println("Direccion :"+c.getDireccion());
            System.out.println("Telefono :"+c.getTelefono());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
