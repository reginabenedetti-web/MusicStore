
package musicstore.vista;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import musicstore.modelo.Cliente;
import musicstore.modelo.DetalleVenta;
import musicstore.modelo.Producto;
import musicstore.modelo.Usuario;
import musicstore.modelo.Venta;
import musicstore.persistencia.Data;
import musicstore.servicio.VentaServicio;


public class FrmVenta extends javax.swing.JFrame {

    private Data data;
    private Usuario usuario;
    private VentaServicio ventaServicio;

// Lista temporal de los productos de la venta
    private ArrayList<DetalleVenta> detalles = new ArrayList<>();
 
    public FrmVenta(Data data, Usuario usuario) {
        initComponents();
        this.data = data;
        this.usuario = usuario;
        this.ventaServicio = new VentaServicio(data);

        setLocationRelativeTo(null);

        cargarClientes();
        cargarProductos();
        cargarTabla();

        txtNumero.setEditable(false);
        txtFecha.setEditable(false);
        txtUsuario.setEditable(false);
        txtTotal.setEditable(false);

        txtNumero.setText(String.valueOf(data.getVentas().size() + 1));
        txtFecha.setText(LocalDate.now().toString());
        txtUsuario.setText(usuario.getNombreUsuario());

        txtTotal.setText("$ 0.00");
    }
    
    private void cargarClientes() {

    cmbCliente.removeAllItems();

    for (Cliente cliente : data.getClientes()) {
        cmbCliente.addItem(cliente);
    }

}
    
    private void cargarProductos() {

    cmbProducto.removeAllItems();

    for (Producto producto : data.getProductos()) {
        cmbProducto.addItem(producto);
    }

}
    
    private void cargarTabla() {

    DefaultTableModel modelo =
            (DefaultTableModel) tblDetalleVenta.getModel();

    modelo.setRowCount(0);

    for (DetalleVenta detalle : detalles) {

        modelo.addRow(new Object[]{
            detalle.getNroRenglon(),
            detalle.getProducto().getNombre(),
            detalle.getCantidad(),
            detalle.getPrecioUnitario(),
            detalle.getSubTotal()
        });

    }

}
    
    private Integer obtenerCantidad() {

    try {
        int cantidad = Integer.parseInt(txtCantidad.getText().trim());

        if (cantidad <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "La cantidad debe ser mayor que cero.",
                    "Dato inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            txtCantidad.requestFocus();
            return null;
        }

        return cantidad;

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "La cantidad debe ser un número entero.",
                "Dato inválido",
                JOptionPane.ERROR_MESSAGE
        );

        txtCantidad.requestFocus();
        return null;
    }
}
    
   private void actualizarTotal() {

    txtTotal.setText("$ " +
            ventaServicio.calcularTotal(detalles));

}
    
    private void limpiarFormulario() {

    detalles.clear();

    txtCantidad.setText("");
    txtTotal.setText("$ 0.00");

    cmbCliente.setSelectedIndex(0);
    cmbProducto.setSelectedIndex(0);

    cargarTabla();

    txtNumero.setText(String.valueOf(data.getVentas().size() + 1));
    txtFecha.setText(LocalDate.now().toString());
    actualizarTotal();
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVentas = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        cmbCliente = new javax.swing.JComboBox();
        lblProducto = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lblDetalle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVentas.setText("Ventas");

        lblNumero.setText("Nro Venta:");

        lblCliente.setText("Cliente:");

        lblUsuario.setText("Usuario:");

        lblFecha.setText("Fecha:");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblProducto.setText("Producto:");

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCantidad.setText("Cantidad:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDetalle.setText("Detalle de Venta:");

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Renglon", "Producto", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetalleVenta);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblTotal.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDetalle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtUsuario)
                                        .addComponent(cmbCliente, 0, 141, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(175, 175, 175))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(84, 84, 84)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCantidad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCantidad))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblFecha)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(71, 71, 71)
                                        .addComponent(btnAgregar))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(lblVentas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnConfirmar)
                        .addGap(54, 54, 54)
                        .addComponent(btnCancelar)
                        .addGap(51, 51, 51)
                        .addComponent(btnVolver)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblVentas)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(lblFecha)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(29, 29, 29)
                .addComponent(lblDetalle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar)
                    .addComponent(btnVolver))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       // Obtener la cantidad
    Integer cantidad = obtenerCantidad();

    if (cantidad == null) {
        return;
    }

    // Obtener el producto seleccionado
    Producto producto = (Producto) cmbProducto.getSelectedItem();

    // Verificar stock
    if (!ventaServicio.validarStock(producto, cantidad)) {

        JOptionPane.showMessageDialog(
                this,
                "Stock insuficiente.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Calcular subtotal
    double precioUnitario = producto.getPrecio();
    double subtotal = precioUnitario * cantidad;

    // Crear el detalle
    DetalleVenta detalle = new DetalleVenta(
            detalles.size() + 1,
            cantidad,
            precioUnitario,
            subtotal,
            producto
    );

    // Agregar a la lista temporal
    detalles.add(detalle);

    // Actualizar pantalla
    cargarTabla();
    actualizarTotal();

    txtCantidad.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
         // Verificar que la venta tenga al menos un producto
    if (detalles.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Debe agregar al menos un producto.",
                "Venta vacía",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    // Obtener el cliente seleccionado
    Cliente cliente = (Cliente) cmbCliente.getSelectedItem();

    // Calcular el total
    double total = ventaServicio.calcularTotal(detalles);

    // Crear la venta
    Venta venta = new Venta(
            Integer.parseInt(txtNumero.getText()),
            total,
            LocalDate.now(),
            cliente,
            usuario,
            new ArrayList<>(detalles)
    );

    // Descontar el stock de cada producto
    for (DetalleVenta detalle : detalles) {

        ventaServicio.descontarStock(
                detalle.getProducto(),
                detalle.getCantidad()
        );

    }

    // Guardar la venta
    ventaServicio.guardarVenta(venta);

    JOptionPane.showMessageDialog(
            this,
            "Venta registrada correctamente.",
            "Operación exitosa",
            JOptionPane.INFORMATION_MESSAGE
    );

    // Preparar el formulario para una nueva venta
    limpiarFormulario();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Desea cancelar la venta actual?",
            "Cancelar venta",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (opcion == JOptionPane.YES_OPTION) {

        limpiarFormulario();

    }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
