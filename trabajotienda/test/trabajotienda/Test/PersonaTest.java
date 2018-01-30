package trabajotienda.Test;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.rnegocio.impl.PersonaImp;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PersonaTest {
    public PersonaTest() {
    }
    @Test
    public void pruebageneral(){
        //              INSERTAR
        int filasAfectadas =0;
        IPersona personaDao = new PersonaImp();
        Persona persona = new Persona(10,"Ronald","034539696","060204682");
        try{
            filasAfectadas = personaDao.insertar(persona);
            System.out.println("Persona ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Persona> lista = new ArrayList<>();
        try {
            lista = personaDao.obtener();
            for (Persona c:lista){
                System.out.println("---Datos personas---");
                System.out.println("Id :"+c.getCodigo());
                System.out.println("Nombre :"+c.getNombre());
                System.out.println("Telefono :"+c.getTelefono());
            System.out.println("Cedula :"+c.getCedula());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}


