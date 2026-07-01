package musicstore.app;

import musicstore.modelo.Usuario;
import musicstore.persistencia.Data;
import musicstore.persistencia.Persistencia;
import musicstore.vista.FrmLogin;

public class Main {
    public static void main(String[] args) {

        Data data = Persistencia.cargar();
        // Si es la primera ejecución del sistema, crear un usuario administrador por defecto
        if (data.getUsuarios().isEmpty()){
        
            Usuario administrador = new Usuario(1, "Administrador", "Sistema", "admin", "admin123");
                data.getUsuarios().add(administrador);
                // Guardar el administrador para futuras ejecuciones
                Persistencia.guardar(data);
        }
        FrmLogin login = new FrmLogin(data);

        login.setVisible(true);
}
}
