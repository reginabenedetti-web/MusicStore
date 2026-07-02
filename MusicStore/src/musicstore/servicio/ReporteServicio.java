package musicstore.servicio;

import java.util.ArrayList;
import musicstore.modelo.Usuario;
import musicstore.modelo.Venta;
import musicstore.persistencia.Data;

public class ReporteServicio {
    
    private Data data;

    public ReporteServicio(Data data) {

        this.data = data;

    }
    
     public ArrayList<Venta> obtenerVentasPorUsuario(Usuario usuario) {

        ArrayList<Venta> ventasUsuario = new ArrayList<>();

        for (Venta venta : data.getVentas()) {

            if (venta.getUsuario().getId() == usuario.getId()) {
                ventasUsuario.add(venta);
            }

        }

        return ventasUsuario;
    }

}
