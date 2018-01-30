
package trabajotienda.rnegocio.dao;
import trabajotienda.rnegocio.entidades.Producto;
import java.util.List;

public interface IProducto {
     public int insertar(Producto producto) throws Exception;
     public Producto obtener(int codigo) throws Exception;
    public List<Producto> obtener() throws Exception;
    
}
