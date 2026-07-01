package musicstore.servicio;

import musicstore.modelo.Usuario;
import musicstore.persistencia.Data;

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
}
