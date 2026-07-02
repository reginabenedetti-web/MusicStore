package musicstore.servicio;

import musicstore.modelo.Categoria;
import musicstore.persistencia.Data;
import musicstore.persistencia.Persistencia;

public class CategoriaServicio {
    
    private Data data;

    public CategoriaServicio(Data data) {
        this.data = data;
    }
    
    public Categoria buscarPorId(int id) {
        
    for (Categoria categoria : data.getCategorias()) {
        if (categoria.getId() == id) {
            return categoria;
        }
    }
    return null;
}
    
   public boolean agregar(Categoria categoria) {
    // Verificar que no exista otra categoría con el mismo ID
    if (buscarPorId(categoria.getId()) != null) {
        return false;
    }
    // Agregar la categoría a la lista
    data.getCategorias().add(categoria);
    // Guardar los cambios
    Persistencia.guardar(data);
    return true;
}
   
   public boolean modificar(int id, String nombre, String descripcion) {

       // Buscar la categoría por su ID
    Categoria categoria = buscarPorId(id);

    if (categoria == null) {
        return false;
    }
    // Actualizar los datos
    categoria.setNombre(nombre);
    categoria.setDescripcion(descripcion);

    // Guardar los cambios
    Persistencia.guardar(data);

    return true;
}
   
   public boolean eliminar(int id) {

       // Buscar la categoría por su ID
    Categoria categoria = buscarPorId(id);

    if (categoria == null) {
        return false;
    }
     // Eliminar la categoría
    data.getCategorias().remove(categoria);
// Guardar los cambios
    Persistencia.guardar(data);

    return true;
}
}
