package musicstore.vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import musicstore.modelo.Cliente;
import musicstore.persistencia.Data;
import musicstore.servicio.ClienteServicio;

public class FrmCliente extends javax.swing.JFrame {

    private Data data;
    private ClienteServicio clienteServicio;

    public FrmCliente(Data data) {
        initComponents();

        this.data = data;
        this.clienteServicio = new ClienteServicio(data);

        setLocationRelativeTo(null);

        cargarTabla();

    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }

    private void cargarTabla() {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        // Eliminar todas las filas existentes
        modelo.setRowCount(0);

        // Recorrer la lista de categorías
        for (Cliente c : data.getClientes()) {
            // Agregar una nueva fila a la tabla
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNombre(),
                c.getApellido(),
                c.getTelefono(),
                c.getEmail()
            });
        }
    }

    private boolean validarCampos() {

        if (txtId.getText().isBlank()
                || txtNombre.getText().isBlank()
                || txtApellido.getText().isBlank()
                || txtTelefono.getText().isBlank()
                || txtEmail.getText().isBlank()) {

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
        tblClientes = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Telefono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("ABM Clientes");

        lblId.setText("ID:");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

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

        lblTelefono.setText("Telefono:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblEmail)
                                    .addComponent(lblTelefono))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addGap(62, 62, 62)
                                        .addComponent(btnModificar)
                                        .addGap(60, 60, 60)
                                        .addComponent(btnEliminar)
                                        .addGap(59, 59, 59)
                                        .addComponent(btnVolver))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        String apellido = txtNombre.getText().trim();
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
        Cliente cliente = new Cliente(id, nombre, apellido, telefono, email);

        // Intentar agregar el proveedor
        boolean agregado = clienteServicio.agregar(cliente);

        if (agregado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cliente registrado correctamente.",
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
                    "Ya existe un cliente con ese ID.",
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
        String apellido = txtApellido.getText().trim();
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
        boolean modificado = clienteServicio.modificar(
                id,
                nombre,
                apellido,
                telefono,
                email
        );

        if (modificado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cliente modificado correctamente.",
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
                    "No existe un cliente con ese ID.",
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
                "¿Está seguro que desea eliminar este cliente?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", cancelar la operación
        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        // Intentar eliminar el cliente
        boolean eliminado = clienteServicio.eliminar(id);

        if (eliminado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cliente eliminado correctamente.",
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
                    "No existe un cliente con ese ID.",
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
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
