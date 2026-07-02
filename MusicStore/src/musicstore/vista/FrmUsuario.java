package musicstore.vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import musicstore.modelo.Usuario;
import musicstore.persistencia.Data;
import musicstore.servicio.UsuarioServicio;


public class FrmUsuario extends javax.swing.JFrame {

     private Data data;
    private UsuarioServicio usuarioServicio;

    public FrmUsuario(Data data) {
        initComponents();

        this.data = data;
        this.usuarioServicio = new UsuarioServicio(data);

        setLocationRelativeTo(null);

        cargarTabla();

    }
    
    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtNombreUsuario.setText("");
        txtPsw.setText("");
      }

    private void cargarTabla() {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        // Eliminar todas las filas existentes
        modelo.setRowCount(0);

        // Recorrer la lista de usuarios
        for (Usuario u : data.getUsuarios()) {
            // Agregar una nueva fila a la tabla
            modelo.addRow(new Object[]{
                u.getId(),
                u.getNombre(),
                u.getApellido(),
                u.getNombreUsuario(),
            });
        }
    }

    private boolean validarCampos() {

        if (txtId.getText().isBlank()
                || txtNombre.getText().isBlank()
                || txtApellido.getText().isBlank()
                || txtNombreUsuario.getText().isBlank()
                || txtPsw.getText().isBlank())
                {

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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblPsw = new javax.swing.JLabel();
        txtPsw = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Nombre Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("ABM Usuarios");

        lblId.setText("ID:");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblNombreUsuario.setText("Nombre Usuario");

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

        lblPsw.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblNombreUsuario))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtNombreUsuario)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(253, 253, 253)
                                .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPsw)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(77, 77, 77)
                                .addComponent(btnModificar)
                                .addGap(82, 82, 82)
                                .addComponent(btnEliminar)))
                        .addGap(78, 78, 78)
                        .addComponent(btnVolver)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPsw)
                        .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreUsuario)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String apellido = txtApellido.getText().trim();
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String password = txtPsw.getText().trim();
        
        // Crear el objeto Usuario
        Usuario usuario = new Usuario(id, nombre, apellido, nombreUsuario, password);

        // Intentar agregar el proveedor
        boolean agregado = usuarioServicio.agregar(usuario);

        if (agregado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuario registrado correctamente.",
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
                    "Ya existe un usuario con ese ID.",
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
        String nombreUsuario = txtNombreUsuario.getText().trim();
       
        // Intentar modificar el proveedor
        boolean modificado = usuarioServicio.modificar(
                id,
                nombre,
                apellido,
                nombreUsuario
        );

        if (modificado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuario modificado correctamente.",
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
                    "No existe un usuario con ese ID.",
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
                "¿Está seguro que desea eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", cancelar la operación
        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        // Intentar eliminar el cliente
        boolean eliminado = usuarioServicio.eliminar(id);

        if (eliminado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuario eliminado correctamente.",
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
                    "No existe un usuario con ese ID.",
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
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPsw;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPsw;
    // End of variables declaration//GEN-END:variables
}
