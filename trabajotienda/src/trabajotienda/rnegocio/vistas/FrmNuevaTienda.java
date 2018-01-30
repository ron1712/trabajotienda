package trabajotienda.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import trabajotienda.rnegocio.entidades.Persona;
import trabajotienda.rnegocio.entidades.Producto;

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
    JComboBox<Producto> cbxProducto;

    JPanel pnlPrinc;
    JPanel pnlTienda;
    JPanel pnlBotones;

    public FrmNuevaTienda() {
        this.setLayout(new BorderLayout(15, 15));

        titulo = new JLabel("Nueva Tienda");
        pnlPrinc.add(titulo, BorderLayout.NORTH);

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

        cbxPersonas = new JComboBox<>();
        cbxProducto = new JComboBox<>();
        
        

    }

    public static void main(String[] args) {

    }
}
