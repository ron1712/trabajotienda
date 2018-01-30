package trabajotienda.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import trabajotienda.rnegocio.dao.IPersona;
import trabajotienda.rnegocio.dao.IProducto;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.entidades.Producto;
import trabajotienda.rnegocio.impl.PersonaImp;
import trabajotienda.rnegocio.impl.ProductoImp;

public class FrmNuevaTienda extends JInternalFrame {

    JLabel titulo;

    JLabel txCodTienda;
    JLabel txPersona;
    JLabel txProducto;
    JLabel txNombre;
    JLabel txDireccion;
    JLabel txTelefono;

    JTextField codTienda;
    JTextField nombre;
    JTextField direccion;
    JTextField telefono;

    JComboBox<Persona> cbxPersonas;
    List<Persona> lstPersonas;
    JComboBox<Producto> cbxProducto;
    List<Producto> lstProductos;

    JButton btnIngresar;
    JButton btnLimpiar;
    JButton btnCancelar;

    JPanel pnlTienda;
    JPanel pnlBotones;

    public FrmNuevaTienda() {
        this.setLayout(new BorderLayout(15, 15));

        titulo = new JLabel("Nueva Tienda");
        this.add(titulo, BorderLayout.NORTH);

        txCodTienda = new JLabel("Codigo Tiemda");
        txPersona = new JLabel("Persona");
        txProducto = new JLabel("Producto");
        txNombre = new JLabel("Nombre");
        txDireccion = new JLabel("Direccion");
        txTelefono = new JLabel("Telefono");

        codTienda = new JTextField("");
        nombre = new JTextField("");
        direccion = new JTextField("");
        telefono = new JTextField("");

        cargarPersonas();
        cbxPersonas = new JComboBox(lstPersonas.toArray());
        cargarProductos();
        cbxProducto = new JComboBox(lstProductos.toArray());

        btnIngresar = new JButton("Ingresar");
        btnLimpiar = new JButton("Limpiar");
        btnCancelar = new JButton("Cancelar");

        pnlTienda = new JPanel(new GridLayout(6, 2));
        pnlTienda.add(txCodTienda);
        pnlTienda.add(codTienda);
        pnlTienda.add(txNombre);
        pnlTienda.add(nombre);
        pnlTienda.add(txDireccion);
        pnlTienda.add(direccion);
        pnlTienda.add(txPersona);
        pnlTienda.add(cbxPersonas);
        pnlTienda.add(txProducto);
        pnlTienda.add(cbxProducto);

        pnlBotones = new JPanel(new GridLayout(1, 3));
        pnlBotones.add(btnIngresar);
        pnlBotones.add(btnLimpiar);
        pnlBotones.add(btnCancelar);

        this.add(pnlTienda, BorderLayout.CENTER);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setSize(400,300);
        this.setClosable(true);

    }

    public static void main(String[] args) {
        FrmNuevaTienda frmMenu = new FrmNuevaTienda();
        frmMenu.setVisible(true);
    }
    
    public void cargarPersonas(){
        IPersona personaDao = new PersonaImp();
        try {
            lstPersonas = personaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void cargarProductos() {
        IProducto productoDao = new ProductoImp();
        try {
            lstProductos = productoDao.obtener(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
