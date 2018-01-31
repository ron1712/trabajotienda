
package trabajotienda.Test;
import trabajotienda.*;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.accesodatos.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
import java.util.*;


public class Tiendatest {
    
    public Tiendatest() {
    }
    
   @Test
    public void testGeneral(){
        ITienda comprDao=new TiendaImpl();
////////        TEST INSERTAR
        int nfilas=0;
        Persona cliente=new Persona("1", "RONALD", "MACAS", "2358974125");
        Producto producto=new Producto("1", "galletas.");
        Tienda comp=new Tienda(cliente, producto, "ABASTOS", "AV SUCRE");
        try {
            nfilas=comprDao.insertar(comp);
            System.out.println("Filas insertadas: "+nfilas);
        } catch (Exception e) {
              System.out.println("Error: " + e.getMessage());
        }
        assertEquals(nfilas>0, true);
    
    
    
//    
//      //TEST LISTADO
//        
        ArrayList<Tienda> tratamientos=new ArrayList<>();
        try {
            tratamientos=comprDao.obtener();
            for(Tienda tra:tratamientos){
                System.out.println(tra.getPersona().getCodigoc()+"   "+tra.getProducto().getCodigop()+"   "+tra.getNombre()+"   "+tra.getDireccion());
            }
        } catch (Exception e) {
        }
        assertEquals(tratamientos!=null, true);
    }
    
}
