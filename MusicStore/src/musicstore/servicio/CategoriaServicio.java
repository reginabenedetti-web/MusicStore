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
    // Recorrer la lista de categorías
    for (Categoria categoria : data.getCategorias()) {
        // Comparar el ID buscado con el ID de la categoría
        if (categoria.getId() == id) {
            return categoria;
        }
    }
    // No se encontró ninguna categoría con ese ID
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

    Categoria categoria = buscarPorId(id);

    if (categoria == null) {
        return false;
    }

    categoria.setNombre(nombre);
    categoria.setDescripcion(descripcion);

    Persistencia.guardar(data);

    return true;
}
   
   public boolean eliminar(int id) {

    Categoria categoria = buscarPorId(id);

    if (categoria == null) {
        return false;
    }

    data.getCategorias().remove(categoria);

    Persistencia.guardar(data);

    return true;
}
}
