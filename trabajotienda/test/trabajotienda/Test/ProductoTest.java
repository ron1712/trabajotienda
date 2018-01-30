
package trabajotienda.Test;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.entidades.Producto;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.rnegocio.dao.IProducto;
import trabajotienda.rnegocio.impl.ProductoImp;
import trabajotienda.rnegocio.impl.PersonaImp;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProductoTest {
    public ProductoTest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IProducto productoDao = new ProductoImp();
        Producto producto = new Producto(3,"Arroz","215");
        try{
            filasAfectadas = productoDao.insertar(producto);
            System.out.println("Producto ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error:.. "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        //              LISTADO DE PEdido
        List<Producto> lista = new ArrayList<>();
        try {
            lista = productoDao.obtener(1);
            for (Producto c:lista){
                System.out.println("Codigo :"+c.getCod_producto());
                System.out.println("Nombre  :"+c.getNombre());
            System.out.println("Stock :"+c.getStock());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}

