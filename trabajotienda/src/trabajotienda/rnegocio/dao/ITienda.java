package trabajotienda.rnegocio.dao;
import trabajotienda.rnegocio.entidades.Tienda;
import java.util.List;

public interface ITienda {
     public int insertar( Tienda tienda) throws Exception;
     public List<Tienda> obtener() throws Exception;
     public Tienda obtener(int tienda) throws Exception;   
}
