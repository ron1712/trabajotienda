/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajotienda.Test;
import trabajotienda.*;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.accesodatos.*;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;


/**
 *
 * @author DELL
 */
public class Productotest {
    
    public Productotest() {
    }
    
    @Test
    public void testGeneral(){
        IProducto productoDao=new ProductoImpl();
      //  TEST INSERTAR
        
        int filas=0;
        Producto producto =new Producto("1", "galletas" );
        try {
            filas=productoDao.insertar(producto);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);
//        
        
        
        
        //TEST OBTENER POR CODIGO
        
        
        
        Producto prod =new Producto();
        try {
            prod = productoDao.obtener("2");
            System.out.println("            "+prod.getCodigop()+"    "+prod.getNombre());
        } catch (Exception e) {
        }
//        

        //TEST LISTADO
        ArrayList<Producto> productos=new ArrayList<>();
        try {
            productos= productoDao.obtener();
            for(Producto productot:productos){
                System.out.println(productot.getCodigop()+" "+productot.getNombre());
            }
        } catch (Exception e) { 
            
        }
        assertEquals(productos!=null, true);
    }
}
