package musicstore.servicio;

import musicstore.modelo.Cliente;
import musicstore.persistencia.Data;
import musicstore.persistencia.Persistencia;

public class ClienteServicio {
    
    private Data data;

    public ClienteServicio(Data data) {
        this.data = data;
    }
    
    public Cliente buscarPorId(int id) {

        for (Cliente cliente : data.getClientes()) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    public boolean agregar(Cliente cliente) {

        if (buscarPorId(cliente.getId()) != null) {
            return false;
        }

        data.getClientes().add(cliente);

        Persistencia.guardar(data);

        return true;
    }
    
    public boolean modificar(int id, String nombre, String apellido, String telefono, String email) {

        Cliente cliente = buscarPorId(id);

        if (cliente == null) {
            return false;
        }

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        Persistencia.guardar(data);

        return true;
    }
    
    public boolean eliminar(int id) {

        Cliente cliente = buscarPorId(id);

        if (cliente == null) {
            return false;
        }

        data.getClientes().remove(cliente);

        Persistencia.guardar(data);

        return true;
    }
}
