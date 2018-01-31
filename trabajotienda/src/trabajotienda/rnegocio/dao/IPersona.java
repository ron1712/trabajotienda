package trabajotienda.rnegocio.dao;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import java.util.*;

public interface IPersona {
    public int insertar(Persona persona) throws Exception;
    public Persona obtener(String codigo) throws Exception;
    public ArrayList<Persona> obtener() throws Exception;
}
