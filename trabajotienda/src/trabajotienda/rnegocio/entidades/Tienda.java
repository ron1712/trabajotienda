
package trabajotienda.rnegocio.entidades;

import trabajotienda.rnegocio.entidades.*;


public class Tienda {
    private Persona persona;
    private Producto producto;
    private String nombre;
    private  String direccion;

    public Tienda() {
    }

    public Tienda(Persona persona, Producto producto, String nombre, String direccion) {
        this.persona = persona;
        this.producto = producto;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
