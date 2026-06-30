package musicstore.persistencia;

import java.util.ArrayList;
import java.io.Serializable;
import musicstore.modelo.Categoria;
import musicstore.modelo.Cliente;
import musicstore.modelo.Producto;
import musicstore.modelo.Proveedor;
import musicstore.modelo.Usuario;
import musicstore.modelo.Venta;

public class Data implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private ArrayList <Usuario> usuarios = new ArrayList<>();
    private ArrayList <Cliente> clientes = new ArrayList<>();
    private ArrayList <Producto> productos = new ArrayList<>();
    private ArrayList <Proveedor> proveedores = new ArrayList<>();
    private ArrayList <Categoria> categorias = new ArrayList<>();
    private ArrayList <Venta> ventas = new ArrayList<>();

    public Data() {
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }
  
}
