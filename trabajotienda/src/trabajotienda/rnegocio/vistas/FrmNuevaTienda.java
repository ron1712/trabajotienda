/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajotienda.rnegocio.vistas;

import trabajotienda.rnegocio.vistas.*;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.impl.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class FrmNuevaTienda extends JInternalFrame{
    
    List <Persona> lstCliente; 
    
    List<Producto> lstProducto;
    
    JComboBox<Persona> cmbCliente;
    JComboBox<Producto> cmbProducto;
    
    JLabel Titulo;
    JLabel Cliente;
    JLabel Producto;
    JLabel Descripcion;
    JLabel Precio;
  
    
    JTextField txDescripcion;
    JTextField txPrecio;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    
    
    JPanel pnlA;
    JPanel pnlB;
    
    public FrmNuevaTienda(){
        
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        pnlA = new JPanel();
        pnlB = new JPanel();
        
        pnlA.setLayout(new GridLayout(12, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));
        
        Titulo = new JLabel("DATOS DE LA TIENDA");
        
        Cliente = new JLabel("NOMBRE PERSONA");
        Producto = new JLabel("PRODUCTO");
        Descripcion = new JLabel("NOMBRE TIENDA");
        Precio = new JLabel("DIRECCION");
        
        
        txDescripcion = new JTextField();
        txPrecio = new JTextField();
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarPersona();
        cmbCliente = new JComboBox(lstCliente.toArray());
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Cliente);
        pnlA.add(cmbCliente);
        pnlA.add(Producto);
        pnlA.add(cmbProducto);
        pnlA.add(Descripcion);
        pnlA.add(txDescripcion);
        pnlA.add(Precio);
        pnlA.add(txPrecio);
        pnlB.add(btnAceptar);
        pnlB.add(btnLimpiar);
        
        
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
        
        this.add(Titulo, BorderLayout.NORTH);
        this.add(pnlA, BorderLayout.CENTER);
        this.add(pnlB, BorderLayout.SOUTH);
        this.setClosable(true);
        
    }
    
       public static void main(String[] args) {

        FrmNuevaTienda frmcompra = new FrmNuevaTienda();
        frmcompra.setVisible(true);

    }
       
       
     public void btnAceptarActionListener(ActionEvent e) {      
         
         
             ITienda tiendaDao = new TiendaImpl();
             Tienda ntienda = new Tienda();
             ntienda.setPersona((Persona) cmbCliente.getSelectedItem());
             ntienda.setProducto((Producto) cmbProducto.getSelectedItem());
             ntienda.setNombre(txDescripcion.getText());
             ntienda.setDireccion(txPrecio.getText());
              
              try{
                  
                  if (tiendaDao.insertar(ntienda) > 0) {

                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

             }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }  
     }
         

    private void cargarProducto() {
        
        IProducto productoDao = new ProductoImpl();
        try{
            
            lstProducto = productoDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS PRODUCTOS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarPersona() {
       
        IPersona personaDao = new PersonaImpl();
        try{
            
            lstCliente = personaDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LAS PERSONAS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
}
