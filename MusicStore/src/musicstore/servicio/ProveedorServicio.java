package musicstore.servicio;

import musicstore.persistencia.Data;
import musicstore.modelo.Proveedor;
import musicstore.persistencia.Persistencia;

public class ProveedorServicio {
    
    private Data data;

    public ProveedorServicio(Data data) {
        this.data = data;
    }
    
    public Proveedor buscarPorId(int id) {

        for (Proveedor proveedor : data.getProveedores()) {

            if (proveedor.getId() == id) {
                return proveedor;
            }
        }

        return null;
    }

    public boolean agregar(Proveedor proveedor) {

        if (buscarPorId(proveedor.getId()) != null) {
            return false;
        }

        data.getProveedores().add(proveedor);

        Persistencia.guardar(data);

        return true;
    }
    
    public boolean modificar(int id, String nombre, String telefono, String email) {

        Proveedor proveedor = buscarPorId(id);

        if (proveedor == null) {
            return false;
        }

        proveedor.setNombre(nombre);
        proveedor.setTelefono(telefono);
        proveedor.setEmail(email);

        Persistencia.guardar(data);

        return true;
    }
    
 
    public boolean eliminar(int id) {

        Proveedor proveedor = buscarPorId(id);

        if (proveedor == null) {
            return false;
        }

        data.getProveedores().remove(proveedor);

        Persistencia.guardar(data);

        return true;
    }
}
