package trabajotienda.rnegocio.entidades;

import java.util.*;

public class Producto {

    private int cod_producto;
    private String nombre;
    private String stock;

    public Producto() {
    }

    public Producto(int cod_producto, String nombre, String stock) {
        this.cod_producto = cod_producto;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
