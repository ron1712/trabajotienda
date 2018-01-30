
package trabajotienda.rnegocio.vistas;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.impl.*;
import trabajotienda.rnegocio.dao.*;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class FrmListadoTienda extends JInternalFrame{
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane sr;

    public FrmListadoTienda() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE DOCENTES");
        tabla = new JTable();
        sr = new JScrollPane(tabla);
        this.add(titulo, BorderLayout.NORTH);
        this.add(sr, BorderLayout.CENTER);

        cargarTabla();

    }
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");

        modelo.addColumn("Nombre");

        modelo.addColumn("Direccion");

        modelo.addColumn("Telefono");

        modelo.addColumn("Persona");
        modelo.addColumn("Producto");

        List<Tienda> lista = new ArrayList<>();
        try {
            ITienda docDao = new TiendaImp();
            lista = docDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Tienda tiend : lista) {
            modelo.addRow(new Object[]{tiend.getCod_tienda(), tiend.getNombre(), tiend.getDireccion(), tiend.getTelefono(), tiend.getPersona().getNombre(), tiend.getProducto().getNombre()});
        }
        tabla.setModel(modelo);
    }
    
    
}
