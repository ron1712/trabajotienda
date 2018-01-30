package trabajotienda.rnegocio.dao;
import trabajotienda.rnegocio.entidades.Persona;
import java.util.List;

public interface IPersona {
     public int insertar(Persona persona) throws Exception;
     public List<Persona> obtener() throws Exception;
         public Persona obtener(int codigo) throws Exception;  
}
