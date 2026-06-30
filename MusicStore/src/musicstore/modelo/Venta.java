package musicstore.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int numero;
    private double total;
    private LocalDate fecha;
    
    private Cliente cliente;
    private Usuario usuario;
    
    private ArrayList<DetalleVenta> detalles = new ArrayList<>();

    public Venta() {
    }

    public Venta(int numero, double total, LocalDate fecha, Cliente cliente, Usuario usuario, ArrayList<DetalleVenta> detalles) {
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Venta N° " + numero;
    }
   
}
