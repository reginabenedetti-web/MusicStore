package musicstore.servicio;

import musicstore.modelo.Producto;
import musicstore.modelo.Categoria;
import musicstore.modelo.Proveedor;
import musicstore.persistencia.Data;
import musicstore.persistencia.Persistencia;

public class ProductoServicio {
    
    private Data data;

    public ProductoServicio(Data data) {
        this.data = data;
    }
    
    public Producto buscarPorId(int id) {

    for (Producto producto : data.getProductos()) {

        if (producto.getId() == id) {
            return producto;
        }
    }

    return null;
}
    
    public boolean agregar(Producto producto) {

    if (buscarPorId(producto.getId()) != null) {
        return false;
    }

    data.getProductos().add(producto);

    Persistencia.guardar(data);

    return true;
}
    
    public boolean modificar(int id,
        String nombre,
        double precio,
        int stock,
        Categoria categoria,
        Proveedor proveedor) {

    Producto producto = buscarPorId(id);

    if (producto == null) {
        return false;
    }

    producto.setNombre(nombre);
    producto.setPrecio(precio);
    producto.setStock(stock);
    producto.setCategoria(categoria);
    producto.setProveedor(proveedor);

    Persistencia.guardar(data);

    return true;
}
    
    public boolean eliminar(int id) {

    Producto producto = buscarPorId(id);

    if (producto == null) {
        return false;
    }

    data.getProductos().remove(producto);

    Persistencia.guardar(data);

    return true;
}
}
