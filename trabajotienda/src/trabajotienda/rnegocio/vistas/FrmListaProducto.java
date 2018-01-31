package trabajotienda.rnegocio.vistas;
import trabajotienda.rnegocio.vistas.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.impl.*;

public class FrmListaProducto extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaProducto() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Productos");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");        
        
        List<Producto> lista =new ArrayList<>();
        try {
            IProducto productoDao = new ProductoImpl();
            lista=productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Producto p : lista){
        modelo.addRow(new Object[]{ p.getCodigop(), p.getNombre()});
        }
        tabla.setModel(modelo);
    }    
}
