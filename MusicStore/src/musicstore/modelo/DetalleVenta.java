package musicstore.modelo;

import java.io.Serializable;

public class DetalleVenta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int nroRenglon;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    
    private Producto producto;

    public DetalleVenta() {
    }
    
    public DetalleVenta(int nroRenglon, int cantidad, double precioUnitario, double subTotal, Producto producto) {
        this.nroRenglon = nroRenglon;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.producto = producto;
    }

    public int getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(int nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
       return producto.toString();
    }
       
}
