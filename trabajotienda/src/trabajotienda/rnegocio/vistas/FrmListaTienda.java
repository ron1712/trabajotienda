
package trabajotienda.rnegocio.vistas;
import trabajotienda.rnegocio.vistas.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.impl.*;

public class FrmListaTienda extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    
    public FrmListaTienda() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Tiendas");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Cliente");
//      
        modelo.addColumn("Persona");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        
        List<Tienda> lista =new ArrayList<>();
        try {
            ITienda tiendaDao = new TiendaImpl();
            lista=tiendaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Tienda c : lista){
        modelo.addRow(new Object[]{ c.getPersona().getCodigoc(),
        c.getProducto().getCodigop(),c.getNombre(),c.getDireccion()});
        }
        tabla.setModel(modelo);
    }
    
}
