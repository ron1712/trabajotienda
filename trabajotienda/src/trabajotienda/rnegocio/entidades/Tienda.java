package trabajotienda.rnegocio.entidades;
public class Tienda {
    private int cod_tienda;  
    private Persona persona;
      private String nombre;
      private String direccion;
      private String telefono;

    public Tienda() {
    }

    public Tienda(int cod_tienda, Persona persona, String nombre, String direccion, String telefono) {
        this.cod_tienda = cod_tienda;
        this.persona = persona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getCod_tienda() {
        return cod_tienda;
    }

    public void setCod_tienda(int cod_tienda) {
        this.cod_tienda = cod_tienda;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
      
}
