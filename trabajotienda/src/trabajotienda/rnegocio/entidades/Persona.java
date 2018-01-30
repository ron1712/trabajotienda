package trabajotienda.rnegocio.entidades;
public class Persona {
    private int codigo;
    private String nombre;
    private String telefono;
    private String cedula;

    public Persona() {
    }

    public Persona(int codigo, String nombre, String telefono, String cedula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    

    

    

    
    
    }

