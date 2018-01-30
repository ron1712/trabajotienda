package trabajotienda.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
        /*Persona */
    JMenu mnPersona;
    JMenuItem mniNuevaPersona;
    JMenuItem mniListadoNuevaPersona;
    JMenuItem mniInsertarPersona;
    JMenuItem mniListarPersona;
    JDesktopPane dkpEscritorio;
/*Producto*/
    JMenu mnProducto;
    JMenuItem mniNuevoProducto;
    JMenuItem mniListadoNuevoProducto;
    JMenuItem mniInsertarProducto;
    JMenuItem mniListarProducto;
    
    /**Tienda*/
    JMenu mnTienda;
    JMenuItem mniNuevaTienda;
    JMenuItem mniInsertarNuevaTienda;
    JMenuItem mniListarTienda;
  

    public FrmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(Color.getHSBColor(10,200,200).brighter());
        
        
        mnbPrincipal = new JMenuBar();
        
        mnInicio = new JMenu("INICIO");
        mnInicio.setForeground(Color.PINK);
        mniLogin = new JMenuItem("INICIAR SESION");
        mniSalir = new JMenuItem("SALIR");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        
        /*Persona*/
        mnPersona= new JMenu("Persona");
        mnPersona.setForeground(Color.PINK);
        mniNuevaPersona= new JMenuItem("NUEVO");
             
        mniNuevaPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPersonaActionPerformed(e);
            }

        });
        
        mniInsertarPersona= new JMenuItem("INSERTAR");
        mniNuevaPersona= new JMenuItem("LISTAR");
        
        mniNuevaPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListadoNuevaPersonaActionPerformed(e);
            }
        });
       
        mniNuevaPersona.add(mniNuevaPersona);
        mniNuevaPersona.add(mniInsertarPersona);
        mniNuevaPersona.addSeparator();
        mniNuevaPersona.add( mniListarPersona);
        
        /*Producto */
              mniNuevoProducto.setForeground(Color.PINK);
        mniNuevoProducto= new JMenuItem("NUEVO");
             
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }
        });
        
        mniInsertarProducto= new JMenuItem("INSERTAR");
       mniListarProducto= new JMenuItem("LISTAR");
        
        mniListadoNuevaPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListadoNuevaPersonaActionPerformed(e);
            }
        });
       
        mniNuevoProducto.add(mniNuevoProducto);
        mniNuevoProducto.add(mniInsertarProducto);
        
        mniNuevoProducto.add(mniListarProducto);
       
        
        /*Tienda */
        
      
        mniNuevaTienda.setForeground(Color.PINK);
        mniNuevaTienda= new JMenuItem("NUEVA");
        mniInsertarNuevaTienda = new JMenuItem("INSERTAR");
        mniListarTienda = new JMenuItem("LISTAR");
        
        mniNuevaTienda.add(mniNuevaTienda);
        mniNuevaTienda.add(mniInsertarNuevaTienda);
        mniNuevaTienda.add(mniListarTienda);
        
        mniNuevaTienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mniNuevaTiendaActionPerformed(e);
                } catch (Exception x) {System.out.println("ERROR"+x.getMessage());
                }
            }
        });
        /*UBICAION DE BOTONES*/
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mniNuevaPersona);
        mnbPrincipal.add(mniNuevoProducto);
        mnbPrincipal.add(mniNuevaTienda);
        
        mnbPrincipal.setBackground(Color.lightGray);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
      
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
     
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
    }
    
    
    /*METODOS*/
    
    public void mniNuevoPersonaActionPerformed(ActionEvent e){
        FrmListadoPersona frm = new FrmListadoPersona();
        
        dkpEscritorio.add(frm,BorderLayout.WEST);
      
        frm.setVisible(true);
    }
        public void mniNuevaTiendaActionPerformed(ActionEvent e){
        FmrNuevaTienda frm = new FmrNuevaTienda();
        dkpEscritorio.add(frm,BorderLayout.SOUTH);
        
        frm.setVisible(true);
    }
       public void mniNuevoProductoActionPerformed(ActionEvent e){
        FmrNuevoProducto frm = new FmrNuevoProducto();
        frm.setTitle("PRODUCTO");
        dkpEscritorio.add(frm,BorderLayout.SOUTH);
        
        frm.setVisible(true);
    }
        public void mniListadoProductoActionPerformed(ActionEvent e){
        FrmListadoProducto frm = new FrmListadoProducto();
        frm.setTitle("PRODUCTOS REGISTRADOS ");
        dkpEscritorio.add(frm,BorderLayout.WEST);
      
        frm.setVisible(true);
    } 
    public void mniListaPersonaActionPerformed(ActionEvent e){
        FrmListadoPersona frm = new FrmListadoPersona();
        frm.setTitle("ESTUDIANTES REGISTRADOS");
        
        dkpEscritorio.add(frm,BorderLayout.WEST);
      
        frm.setVisible(true);
    }       
    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
}

