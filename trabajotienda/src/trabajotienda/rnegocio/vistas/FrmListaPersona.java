
package trabajotienda.rnegocio.vistas;
import trabajotienda.rnegocio.vistas.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.impl.*;

public class FrmListaPersona extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    
    public FrmListaPersona() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Personas");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
//        modelo.addColumn("Cedula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Telefono");
        
        List<Persona> lista =new ArrayList<>();
        try {
            IPersona personaDao = new PersonaImpl();
            lista=personaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Persona cli : lista){
        modelo.addRow(new Object[]{ cli.getCodigoc(),
        cli.getNombre(),cli.getApellido(),cli.getTelefono()});
        }
        tabla.setModel(modelo);
    }
    
}
