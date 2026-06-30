package musicstore.persistencia;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.File;

public class Persistencia {

    private static final String ARCHIVO = "musicstore.dat";

    public static void guardar(Data data) {
        try (
                FileOutputStream archivoSalida = new FileOutputStream(ARCHIVO); 
                ObjectOutputStream salidaObjetos = new ObjectOutputStream(archivoSalida)
             ) {
            
           salidaObjetos.writeObject(data);
           
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public static Data cargar() {
        
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return new Data();
        }
        try (
                FileInputStream archivoEntrada = new FileInputStream(ARCHIVO); 
                ObjectInputStream entradaObjetos = new ObjectInputStream(archivoEntrada)
             ) 
        {
        return (Data) entradaObjetos.readObject();
        
        } catch (IOException | ClassNotFoundException e){
            
            e.printStackTrace();
            return new Data();
        }
    }
}
