package musicstore.app;

import musicstore.modelo.Usuario;
import musicstore.persistencia.Data;
import musicstore.persistencia.Persistencia;
import musicstore.vista.FrmLogin;

public class Main {
    public static void main(String[] args) {

        Data data = Persistencia.cargar();
        
        if (data.getUsuarios().isEmpty()){
        
            Usuario administrador = new Usuario(1, "Administrador", "Sistema", "admin", "admin123");
                data.getUsuarios().add(administrador);
                Persistencia.guardar(data);
        }
        FrmLogin login = new FrmLogin(data);

        login.setVisible(true);
}
}
