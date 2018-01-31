package trabajotienda.rnegocio.vistas;


import trabajotienda.rnegocio.vistas.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.impl.*;

public class FrmNuevaPersona extends JInternalFrame {

    JLabel titulo;
    JLabel codigoc;
    JLabel nombre;
    JLabel apellido;
    JLabel telefono;
//    JLabel telefono;
//    JLabel direccion;
//    JLabel categoria;
//    JLabel sexo;
//    JLabel fechaNacimiento;
//    JLabel fechaIngreso;
//    JLabel salario;
//
    JTextField txtCod;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtTelefono;
//    JTextField txTelf;
//    JTextField txDir;
//    JComboBox<String> cmdCateg;
//    JTextField txtTitulo8;
//    JTextField txFechaNac;
//    JTextField txFechIng;
//    JTextField txSalario;
//
//    JComboBox cmbGenero;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;
//
    
    public FrmNuevaPersona() {
//
        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(4, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("DATOS DE PERSONA");

        codigoc = new JLabel("Codigo Persona: ");

        nombre = new JLabel("Nombre: ");
        apellido = new JLabel("Apellido: ");
        telefono = new JLabel("Telefono: ");
//        telefono = new JLabel("NUMERO TELEFONO");
//        direccion = new JLabel("DIRECCION");
//        categoria = new JLabel("A");
//        sexo = new JLabel("GENERO");
//        fechaNacimiento = new JLabel("FECHA NACIMIENTO");
//        fechaIngreso = new JLabel("FECHA INGRESO");
//        salario = new JLabel("salario");
//
        txtCod = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();

        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo, BorderLayout.NORTH);
        pnlcentral.add(codigoc);
        pnlcentral.add(txtCod);
        pnlcentral.add(nombre);
        pnlcentral.add(txtNombre);
        pnlcentral.add(apellido);
        pnlcentral.add(txtApellido);
        pnlcentral.add(telefono);
        pnlcentral.add(txtTelefono);
//        pnlcentral.add(telefono);
//        pnlcentral.add(txTelf);
//        pnlcentral.add(direccion);
//        pnlcentral.add(txDir);
//        pnlcentral.add(categoria);
//        pnlcentral.add(cmdCateg);
//        pnlcentral.add(sexo);
//        pnlcentral.add(cmbGenero);
//        pnlcentral.add(fechaNacimiento);
//        pnlcentral.add(txFechaNac);
//        pnlcentral.add(fechaIngreso);
//        pnlcentral.add(txFechIng);
//        pnlcentral.add(salario);
//        pnlcentral.add(txSalario);
//
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
//
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            }
        });
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        this.setClosable(true);

    }

    public static void main(String[] args) {

        FrmNuevaPersona frmMenu = new FrmNuevaPersona();
        frmMenu.setVisible(true);

    }

    public void btnAceptarActionListener(ActionEvent e) {
        try {
            Persona nPersona = new Persona();
            nPersona.setCodigoc(txtCod.getText());
            nPersona.setNombre(txtNombre.getText());
            nPersona.setApellido(txtApellido.getText());
            nPersona.setTelefono(txtTelefono.getText());
            IPersona cliDao = new PersonaImpl();
            if (cliDao.insertar(nPersona) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO FALLIDO!!"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
