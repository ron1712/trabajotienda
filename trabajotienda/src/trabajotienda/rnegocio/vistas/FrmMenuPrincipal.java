package trabajotienda.rnegocio.vistas;

import trabajotienda.rnegocio.vistas.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.impl.*;


public class FrmMenuPrincipal extends JFrame {

    JMenuBar menuBarraPrincipal;
    JMenu menuInicio;
    JMenuItem menuItemLogin;
    JMenuItem menuItemSalir;
    ///////////////////////////////
    JMenu menuCliente;
    JMenuItem nuevoCliente;
    JMenuItem modificarCliente;
    JMenuItem eliminarCliente;
    JMenuItem buscarCliente;
    JMenuItem listCliente;
    /////////////////////////////////////////
    JMenu menuProducto;
    JMenuItem nuevoProducto;
    JMenuItem modificarProducto;
    JMenuItem eliminarProducto;
    JMenuItem buscarProducto;
    JMenuItem listProducto;
    ///////////////////////////////////////////////
    JMenu menuCompra;
    JMenuItem nuevoCompra;
    JMenuItem modificarCompra;
    JMenuItem eliminarCompra;
    JMenuItem buscarCompra;
    JMenuItem listCompra;
    ///////////////////////////////////////
    JDesktopPane escritorio;

    public FrmMenuPrincipal() {
        escritorio = new JDesktopPane();
       /* escritorio.setBackground(new Color(50, 30, 70));*/

        menuBarraPrincipal = new JMenuBar();
        //menu Inicio
        menuInicio = new JMenu("Inicio");
        menuItemLogin = new JMenuItem("Iniciar Sesion");
        menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuSalirActionPerformed(e);
                } catch (Exception ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        });
        menuBarraPrincipal.add(menuInicio);
        menuInicio.add(menuItemLogin);
        menuInicio.add(menuItemSalir);
        
        menuCliente = new JMenu("PERSONA");
        nuevoCliente = new JMenuItem("Nueva Persona");
        nuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoPersonaActionPerformed(e);
            }
        });
        modificarCliente = new JMenuItem("Modificar Persona");
        eliminarCliente = new JMenuItem("Eliminar Persona");
        buscarCliente = new JMenuItem("Buscar Persona");
        listCliente = new JMenuItem("Listar Personas");
        listCliente.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPersonaActionPerformed(e);
            }
        });
        menuCliente.add(nuevoCliente);
        menuCliente.add(modificarCliente);
        menuCliente.add(eliminarCliente);
        menuCliente.addSeparator();
        menuCliente.add(buscarCliente);
        menuCliente.add(listCliente);
        
        menuBarraPrincipal.add(menuCliente);
       
        ////////////////////////////////////////////
        menuProducto = new JMenu("PRODUCTO");
        nuevoProducto = new JMenuItem("Nuevo Producto");
        nuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoProductoActionPerformed(e);
            }
        });
        modificarProducto = new JMenuItem("Modificar Producto");
        eliminarProducto = new JMenuItem("Eliminar Producto");
        buscarProducto = new JMenuItem("Buscar Producto");
        listProducto = new JMenuItem("Listar Producto");
        listProducto.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaProductoActionPerformed(e);
            }
        });
        menuProducto.add(nuevoProducto);
        menuProducto.add(modificarProducto);
        menuProducto.add(eliminarProducto);
        menuProducto.addSeparator();
        menuProducto.add(buscarProducto);
        menuProducto.add(listProducto);
        
        menuBarraPrincipal.add(menuProducto);
       
        ///////////////////////////////////////////////////////////////
        menuCompra = new JMenu("TIENDA");
        nuevoCompra = new JMenuItem("Nueva Tienda");
        nuevoCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoTiendaActionPerformed(e);
            }
        });
        modificarCompra = new JMenuItem("Modificar Tienda");
        eliminarCompra = new JMenuItem("Eliminar Tienda");
        buscarCompra = new JMenuItem("Buscar Tienda");
        listCompra = new JMenuItem("Listar Tienda");
        listCompra.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTiendaActionPerformed(e);
            }
        });
        menuCompra.add(nuevoCompra);
        menuCompra.add(modificarCompra);
        menuCompra.add(eliminarCompra);
        menuCompra.addSeparator();
        menuCompra.add(buscarCompra);
        menuCompra.add(listCompra);
        
        menuBarraPrincipal.add(menuCompra);
       
        ///////////////////////////////////////////////////////////////////////
        
        
        
        this.setLayout(new BorderLayout());
        //this.setSize(360,240);
        this.add(menuBarraPrincipal, BorderLayout.NORTH);
        this.add(escritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //PARA MAXIMIZAR LA VENTANA
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//terminar proceso de la ventana ejecutada
        

    }

    public static void main(String[] args) {
        FrmMenuPrincipal ventana = new FrmMenuPrincipal();
        ventana.setVisible(true);
    }

    public void menuSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
     public void listaPersonaActionPerformed(ActionEvent e) {
        FrmListaPersona frm = new FrmListaPersona();
        escritorio.add(frm);
        frm.setVisible(true);
    }
      public void listaTiendaActionPerformed(ActionEvent e) {
        FrmListaTienda frm = new FrmListaTienda();
        escritorio.add(frm);
        frm.setVisible(true);
    }
     
     public void listaProductoActionPerformed(ActionEvent e) {
        FrmListaProducto frm = new FrmListaProducto();
        escritorio.add(frm);
        frm.setVisible(true);
    }
     public void NuevoPersonaActionPerformed(ActionEvent e) {
        FrmNuevaPersona frm = new FrmNuevaPersona();
        escritorio.add(frm);
        frm.setVisible(true);
    }

      public void NuevoTiendaActionPerformed(ActionEvent e) {
        FrmNuevaTienda frm = new FrmNuevaTienda();
        escritorio.add(frm);
        frm.setVisible(true);
    }
      
       public void NuevoProductoActionPerformed(ActionEvent e) {
        FrmNuevoProducto frm = new FrmNuevoProducto();
        escritorio.add(frm);
        frm.setVisible(true);
    }
}
