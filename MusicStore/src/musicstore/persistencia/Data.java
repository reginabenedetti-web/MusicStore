
package musicstore.persistencia;

import java.util.ArrayList;
import java.io.Serializable;
import musicstore.modelo.Usuario;

public class Data implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private ArrayList <Usuario> usuarios = new ArrayList<>();

    public Data() {
    }

}
