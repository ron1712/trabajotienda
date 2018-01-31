
package trabajotienda.rnegocio.dao;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import java.util.*;

public interface ITienda {
    
     public int insertar (Tienda tienda) throws Exception;
    public Tienda obtener(String codigo) throws Exception;
     public ArrayList<Tienda> obtener () throws Exception;
}
