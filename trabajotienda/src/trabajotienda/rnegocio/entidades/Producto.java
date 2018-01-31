
package trabajotienda.rnegocio.entidades;

import trabajotienda.rnegocio.entidades.*;


public class Producto {
    private String codigop;
    private String nombre;

    public Producto() {
    }

    public Producto(String codigop, String nombre) {
        this.codigop = codigop; 
        this.nombre = nombre;
    }

    public String getCodigop() {
        return codigop;
    }

    public void setCodigop(String codigop) {
        this.codigop = codigop;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre; 
    }
    
}
