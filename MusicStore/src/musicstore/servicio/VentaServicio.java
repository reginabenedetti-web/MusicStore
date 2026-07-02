package musicstore.servicio;
import musicstore.persistencia.Data;
import java.util.ArrayList;
import musicstore.modelo.DetalleVenta;
import musicstore.modelo.Producto;
import musicstore.modelo.Venta;
import musicstore.persistencia.Persistencia;

public class VentaServicio {
    
      private Data data;

    public VentaServicio(Data data) {
        this.data = data;
    }
    
    public boolean validarStock(Producto producto, int cantidad) {

    return producto.getStock() >= cantidad;
}
    
    public void descontarStock(Producto producto, int cantidad) {

    producto.setStock(producto.getStock() - cantidad);
}
    
    public double calcularTotal(ArrayList<DetalleVenta> detalles) {

    double total = 0;

    for (DetalleVenta detalle : detalles) {
        total += detalle.getSubTotal();
    }

    return total;
}
    
    public boolean guardarVenta(Venta venta) {

    data.getVentas().add(venta);

    Persistencia.guardar(data);

    return true;
}
}
