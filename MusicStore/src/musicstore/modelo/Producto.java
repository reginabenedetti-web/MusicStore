package musicstore.modelo;

import java.io.Serializable;

public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int stock;
    
    private double precio;
    private String nombre;
    
    private Categoria categoria;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(int id, int stock, double precio, String nombre, Categoria categoria, Proveedor proveedor) {
        this.id = id;
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  nombre;
    }
     
}

