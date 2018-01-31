
package trabajotienda.Test;
import trabajotienda.*;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class Personatest {
    
    public Personatest() {
    }
    
     @Test
    public void testGeneral(){
        IPersona clientetorDao=new PersonaImpl();
       // TEST INSERTAR
        
//        int filas=0;
//        Cliente clientetor=new Cliente("1", "DANIEL", "CANDO", "2358974125");
//        try {
//            filas=clientetorDao.insertar(clientetor);
//            System.out.println("Ingreso de " + filas + " Filas Correctas");
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertEquals(filas>0, true);
//        
        //TEST OBTENER POR CODIGO
//        
        Persona cliente=new Persona();
        try {
            cliente=clientetorDao.obtener("1");
            System.out.println("            "+cliente.getCodigoc()+"    "+cliente.getNombre()+"    "+cliente.getApellido()+"    "+cliente.getTelefono());
        } catch (Exception e) {
        }
        //*------------------------------------------------------------------------------------------------------------------------------------*
//        
        //TEST LISTADO
        ArrayList<Persona> clientetores=new ArrayList<>();
        try {
            clientetores=clientetorDao.obtener();
            for(Persona clientet:clientetores){
                System.out.println(clientet.getCodigoc()+" "+clientet.getNombre()+" "+clientet.getApellido()+" "+clientet.getTelefono());
            }
        } catch (Exception e) {
        }
        assertEquals(clientetores!=null, true);
    } 
}