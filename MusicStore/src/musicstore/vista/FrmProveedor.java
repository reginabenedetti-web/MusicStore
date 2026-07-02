package musicstore.vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import musicstore.modelo.Proveedor;
import musicstore.persistencia.Data;
import musicstore.servicio.ProveedorServicio;

public class FrmProveedor extends javax.swing.JFrame {

    private Data data;
    private ProveedorServicio proveedorServicio;
    
    public FrmProveedor(Data data) {
        initComponents();
        
        this.data = data;
        this.proveedorServicio = new ProveedorServicio(data);

    setLocationRelativeTo(null);

    cargarTabla();

    }
  
    private void limpiarCampos() {
    txtId.setText("");
    txtNombre.setText("");
    txtTelefono.setText("");
    txtEmail.setText("");
}

    private void cargarTabla() {
    // Obtener el modelo de la tabla
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    // Eliminar todas las filas existentes
    modelo.setRowCount(0);

    // Recorrer la lista de categorías
    for (Proveedor p : data.getProveedores()) {
        // Agregar una nueva fila a la tabla
        modelo.addRow(new Object[]{
            p.getId(),
            p.getNombre(),
            p.getTelefono(),
            p.getEmail()
        });
    }
} 
    
    private boolean validarCampos() {

        if (txtId.getText().isBlank()
                || txtNombre.getText().isBlank()
                || txtTelefono.getText().isBlank()
                || txtEmail.getText().isBlank()){

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
    
    private boolean validarEmail(String email) {

        return email.contains("@");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("ABM Proveedores");

        lblId.setText("ID:");

        lblNombre.setText("Nombre:");

        lblTelefono.setText("Teléfono:");

        lblEmail.setText("Email:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefono)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblId)
                                .addComponent(lblNombre))
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(81, 81, 81)
                                .addComponent(btnModificar)
                                .addGap(76, 76, 76)
                                .addComponent(btnEliminar)
                                .addGap(63, 63, 63)
                                .addComponent(btnVolver))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    // Obtener los datos ingresados
    String nombre = txtNombre.getText().trim();
    String telefono = txtTelefono.getText().trim();
    String email = txtEmail.getText().trim();

    // Validar el formato básico del email
    if (!validarEmail(email)) {

        JOptionPane.showMessageDialog(
                this,
                "Debe ingresar un email válido.",
                "Dato inválido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }
        // Crear el objeto Proveedor
        Proveedor proveedor = new Proveedor(id, nombre, telefono,email);

    // Intentar agregar el proveedor
    boolean agregado = proveedorServicio.agregar(proveedor);

    if (agregado) {

        JOptionPane.showMessageDialog(
                this,
                "Proveedor registrado correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Actualizar la tabla
        cargarTabla();

        // Limpiar el formulario
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Ya existe un proveedor con ese ID.",
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

    // Obtener los datos ingresados
    String nombre = txtNombre.getText().trim();
    String telefono = txtTelefono.getText().trim();
    String email = txtEmail.getText().trim();

    // Validar el formato básico del email
    if (!validarEmail(email)) {

        JOptionPane.showMessageDialog(
                this,
                "Debe ingresar un email válido.",
                "Dato inválido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    // Intentar modificar el proveedor
    boolean modificado = proveedorServicio.modificar(
            id,
            nombre,
            telefono,
            email
    );

    if (modificado) {

        JOptionPane.showMessageDialog(
                this,
                "Proveedor modificado correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Actualizar la tabla
        cargarTabla();

        // Limpiar el formulario
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "No existe un proveedor con ese ID.",
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
            "¿Está seguro que desea eliminar este proveedor?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    // Si el usuario selecciona "No", cancelar la operación
    if (opcion != JOptionPane.YES_OPTION) {
        return;
    }

    // Intentar eliminar el proveedor
    boolean eliminado = proveedorServicio.eliminar(id);

    if (eliminado) {

        JOptionPane.showMessageDialog(
                this,
                "Proveedor eliminado correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Actualizar la tabla
        cargarTabla();

        // Limpiar el formulario
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "No existe un proveedor con ese ID.",
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
