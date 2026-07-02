package musicstore.servicio;

import musicstore.modelo.Usuario;
import musicstore.persistencia.Data;
import musicstore.persistencia.Persistencia;

public class UsuarioServicio {
    
    private Data data;

    public UsuarioServicio(Data data) {
        this.data = data;
    }
    
    public Usuario validarLogin(String nombreUsuario, String password){
    
        for (Usuario usuario : data.getUsuarios()){
                
            if(usuario.getNombreUsuario().equals(nombreUsuario) &&
                    usuario.getPassword().equals(password)){
            
                return usuario;
            }
        }
        return null;
    }
    
    public Usuario buscarPorId(int id) {

        for (Usuario usuario : data.getUsuarios()) {

            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }

    public boolean agregar(Usuario usuario) {

        if (buscarPorId(usuario.getId()) != null) {
            return false;
        }

        data.getUsuarios().add(usuario);

        Persistencia.guardar(data);

        return true;
    }
    
    public boolean modificar(int id, String nombre, String apellido, String nombreUsuario) {

        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return false;
        }

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setNombreUsuario(nombreUsuario);

        Persistencia.guardar(data);

        return true;
    }
    
 
    public boolean eliminar(int id) {

        Usuario usuario= buscarPorId(id);

        if (usuario== null) {
            return false;
        }

        data.getUsuarios().remove(usuario);

        Persistencia.guardar(data);

        return true;
    }
}
