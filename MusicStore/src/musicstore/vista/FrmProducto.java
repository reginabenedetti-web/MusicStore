package musicstore.vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import musicstore.modelo.Categoria;
import musicstore.modelo.Producto;
import musicstore.modelo.Proveedor;
import musicstore.persistencia.Data;
import musicstore.servicio.ProductoServicio;

public class FrmProducto extends javax.swing.JFrame {

    private Data data;
    private ProductoServicio productoServicio;
    
    public FrmProducto(Data data) {

    initComponents();

    this.data = data;
    this.productoServicio = new ProductoServicio(data);

    setLocationRelativeTo(null);

    cargarCategorias();
    cargarProveedores();
    cargarTabla();
}
    private void limpiarCampos() {

    txtId.setText("");
    txtNombre.setText("");
    txtPrecio.setText("");
    txtStock.setText("");

    cmbCategoria.setSelectedIndex(0);
    cmbProveedor.setSelectedIndex(0);

    txtId.requestFocus();

}
    
    private boolean validarCampos() {

    if (txtId.getText().isBlank()
            || txtNombre.getText().isBlank()
            || txtPrecio.getText().isBlank()
            || txtStock.getText().isBlank()) {

        JOptionPane.showMessageDialog(
                this,
                "Debe completar todos los campos.",
                "Campos obligatorios",
                JOptionPane.WARNING_MESSAGE
        );

        return false;
    }

    return true;
}
    
    private Integer obtenerId() {

        try {
            return Integer.parseInt(txtId.getText().trim());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número entero.",
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );

            txtId.requestFocus();

            return null;
        }
    }
    
     private void cargarCategorias() {

    cmbCategoria.removeAllItems();

    for (Categoria categoria : data.getCategorias()) {
        cmbCategoria.addItem(categoria);
    }
}
    
    private void cargarProveedores() {

    cmbProveedor.removeAllItems();

    for (Proveedor proveedor : data.getProveedores()) {
        cmbProveedor.addItem(proveedor);
    }

}
    private void cargarTabla() {

    DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();

    modelo.setRowCount(0);

    for (Producto producto : data.getProductos()) {

        modelo.addRow(new Object[]{
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getCategoria().getNombre(),
            producto.getProveedor().getNombre()
        });

    }
}
    private Double obtenerPrecio() {

    try {
        return Double.parseDouble(txtPrecio.getText().trim());

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El precio debe ser un número válido.",
                "Dato inválido",
                JOptionPane.ERROR_MESSAGE
        );

        txtPrecio.requestFocus();

        return null;
    }
}
  
private Integer obtenerStock() {

    try {
        return Integer.parseInt(txtStock.getText().trim());

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El stock debe ser un número entero.",
                "Dato inválido",
                JOptionPane.ERROR_MESSAGE
        );

        txtStock.requestFocus();

        return null;
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox();
        cmbProveedor = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock", "Categoria", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("ABM Productos");

        lblId.setText("ID:");

        lblNombre.setText("Nombre:");

        lblPrecio.setText("Precio:");

        lblStock.setText("Stock:");

        lblCategoria.setText("Categoria:");

        lblProveedor.setText("Proveedor:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(lblTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblId, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(192, 192, 192)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblProveedor)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCategoria)
                                                    .addComponent(lblStock))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnGuardar)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(70, 70, 70)
                                        .addComponent(btnModificar)
                                        .addGap(90, 90, 90)
                                        .addComponent(btnEliminar)
                                        .addGap(95, 95, 95)
                                        .addComponent(btnVolver)))))
                        .addGap(0, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblId)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStock)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Verificar que todos los campos estén completos
    if (!validarCampos()) {
        return;
    }

    // Obtener y validar el ID
    Integer id = obtenerId();

    if (id == null) {
        return;
    }

    // Obtener y validar el precio
    Double precio = obtenerPrecio();

    if (precio == null) {
        return;
    }

    // Obtener y validar el stock
    Integer stock = obtenerStock();

    if (stock == null) {
        return;
    }

    // Validaciones de negocio
    if (precio <= 0) {

        JOptionPane.showMessageDialog(
                this,
                "El precio debe ser mayor que cero.",
                "Dato inválido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    if (stock < 0) {

        JOptionPane.showMessageDialog(
                this,
                "El stock no puede ser negativo.",
                "Dato inválido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    // Obtener los demás datos
    String nombre = txtNombre.getText().trim();

    Categoria categoria = (Categoria) cmbCategoria.getSelectedItem();
    Proveedor proveedor = (Proveedor) cmbProveedor.getSelectedItem();

    // Crear el producto
    Producto producto = new Producto(
        id,
        stock,
        precio,
        nombre,
        categoria,
        proveedor
);

    // Intentar agregar el producto
    boolean agregado = productoServicio.agregar(producto);

    if (agregado) {

        JOptionPane.showMessageDialog(
                this,
                "Producto registrado correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        cargarTabla();
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Ya existe un producto con ese ID.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // Verificar que todos los campos estén completos
    if (!validarCampos()) {
        return;
    }

    // Obtener y validar el ID
    Integer id = obtenerId();

    if (id == null) {
        return;
    }

    // Obtener y validar el precio
    Double precio = obtenerPrecio();

    if (precio == null) {
        return;
    }

    // Obtener y validar el stock
    Integer stock = obtenerStock();

    if (stock == null) {
        return;
    }

    // Validaciones de negocio
    if (precio <= 0) {

        JOptionPane.showMessageDialog(
                this,
                "El precio debe ser mayor que cero.",
                "Dato inválido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    if (stock < 0) {

        JOptionPane.showMessageDialog(
                this,
                "El stock no puede ser negativo.",
                "Dato inválido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    // Obtener los demás datos
    String nombre = txtNombre.getText().trim();

    Categoria categoria = (Categoria) cmbCategoria.getSelectedItem();
    Proveedor proveedor = (Proveedor) cmbProveedor.getSelectedItem();

    // Intentar modificar el producto
    boolean modificado = productoServicio.modificar(
            id,
            nombre,
            precio,
            stock,
            categoria,
            proveedor
    );

    if (modificado) {

        JOptionPane.showMessageDialog(
                this,
                "Producto modificado correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        cargarTabla();
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "No existe un producto con ese ID.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Obtener y validar el ID
    Integer id = obtenerId();

    if (id == null) {
        return;
    }

    // Confirmar la eliminación
    int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro que desea eliminar este producto?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (opcion != JOptionPane.YES_OPTION) {
        return;
    }

    // Intentar eliminar el producto
    boolean eliminado = productoServicio.eliminar(id);

    if (eliminado) {

        JOptionPane.showMessageDialog(
                this,
                "Producto eliminado correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        cargarTabla();
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "No existe un producto con ese ID.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
