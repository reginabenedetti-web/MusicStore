/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musicstore.vista;
import javax.swing.JOptionPane;
import musicstore.modelo.Categoria;
import musicstore.persistencia.Data;
import musicstore.servicio.CategoriaServicio;
import javax.swing.table.DefaultTableModel;
public class FrmCategorias extends javax.swing.JFrame {

    private Data data;
    private CategoriaServicio categoriaServicio;
    
   public FrmCategorias(Data data) {

    initComponents();

    this.data = data;
    this.categoriaServicio = new CategoriaServicio(data);

    setLocationRelativeTo(null);
    cargarTabla();
}
   
    private void limpiarCampos() {

        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
    }

    private void cargarTabla() {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblCategorias.getModel();
        // Eliminar todas las filas existentes
        modelo.setRowCount(0);

        // Recorrer la lista de categorías
        for (Categoria categoria : data.getCategorias()) {
            // Agregar una nueva fila a la tabla
            modelo.addRow(new Object[]{
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion()
            });
        }
    }

    private boolean validarCampos() {

        if (txtId.getText().isBlank()
                || txtNombre.getText().isBlank()
                || txtDescripcion.getText().isBlank()) {

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

        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("ABM Categorías");

        lblId.setText("ID:");

        lblNombre.setText("Nombre:");

        lblDescripcion.setText("Descripción:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

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

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(lblNombre))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addGap(59, 59, 59)
                                        .addComponent(btnModificar)
                                        .addGap(59, 59, 59)
                                        .addComponent(btnEliminar)
                                        .addGap(52, 52, 52)
                                        .addComponent(btnVolver))
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTitulo)
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnVolver))))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
  
    }//GEN-LAST:event_txtNombreActionPerformed
  
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
   
        if (!validarCampos()) {
        return;
    }

    Integer id = obtenerId();

    if (id == null) {
        return;
    }

    Categoria categoria = new Categoria(id, txtNombre.getText().trim(), txtDescripcion.getText().trim());

    boolean agregado = categoriaServicio.agregar(categoria);

    if (agregado) {

        JOptionPane.showMessageDialog(this, "Categoría registrada correctamente.");

        cargarTabla();
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(this, "Ya existe una categoría con ese ID.","Error",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Cerrar el formulario de categorías
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
    String descripcion = txtDescripcion.getText().trim();

    // Intentar modificar la categoría
    boolean modificado = categoriaServicio.modificar(id, nombre, descripcion);

    if (modificado) {

        JOptionPane.showMessageDialog(this,"Categoría modificada correctamente.", "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE);

        // Actualizar la tabla
        cargarTabla();

        // Limpiar el formulario
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(this, "No existe una categoría con ese ID.","Error",
                JOptionPane.ERROR_MESSAGE );
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    // Obtener y validar el ID
    Integer id = obtenerId();

    if (id == null) {
        return;
    }

    // Confirmar la eliminación
    int opcion = JOptionPane.showConfirmDialog(this,"¿Está seguro que desea eliminar esta categoría?", "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE );

    // Si el usuario selecciona "No", cancelar la operación
    if (opcion != JOptionPane.YES_OPTION) {
        return;
    }

    // Intentar eliminar la categoría
    boolean eliminado = categoriaServicio.eliminar(id);

    if (eliminado) {

        JOptionPane.showMessageDialog(this,"Categoría eliminada correctamente.", "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE );

        // Actualizar la tabla
        cargarTabla();

        // Limpiar el formulario
        limpiarCampos();

    } else {

        JOptionPane.showMessageDialog(this,"No existe una categoría con ese ID.","Error",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
