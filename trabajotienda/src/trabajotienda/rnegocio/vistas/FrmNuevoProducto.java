
package trabajotienda.rnegocio.vistas;
import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import trabajotienda.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
public class FrmNuevoProducto extends JInternalFrame {
    JLabel lblTitulo1,lblTitulo2,lblTitulo3;
   
    JLabel lblTitulo0;
    
    JTextField txtTitulo1,txtTitulo2,txtTitulo3;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoProducto() {
        this.setSize(400,600);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("DATOS DEL PRODUCTO ");
        
        lblTitulo1= new JLabel("CODIGO DEL PRODUCTO :");
        lblTitulo2= new JLabel(" NOMBRE:");
        lblTitulo3= new JLabel("STOCK :");
        
        
        txtTitulo1 = new JTextField(2);
        txtTitulo2= new JTextField(2);
        txtTitulo3= new JTextField(2);
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(txtTitulo1);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(txtTitulo2);
        pnlCentral.add(lblTitulo3);
        pnlCentral.add(txtTitulo3);
        
           
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        pnlCentral.setBackground(Color.getHSBColor(100,60,27).brighter());
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);  
        this.setClosable(true);        
        
    }
    public static void main(String[] args) {
        FrmNuevoProducto frmMenu= new FrmNuevoProducto();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        
        try {
            
            Persona persona = new Persona();
            persona.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            persona.setCedula(txtTitulo2.getText());
            persona.setNombre(txtTitulo3.getText());   
            
            IProducto productoDao = new ProductoImp();
            Producto producto = null;
            
            if(productoDao.insertar(producto)>0){
                JOptionPane.showMessageDialog(this,"Registro Correcto!!",
                        "Transacción correcta",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Error de Guardado!!",
                "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
            
            
        } catch (Exception x) {
              JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            
        }
      
    }
          
    }
