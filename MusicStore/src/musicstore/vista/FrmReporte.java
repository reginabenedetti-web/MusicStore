package musicstore.vista;

import javax.swing.table.DefaultTableModel;
import musicstore.modelo.Producto;
import musicstore.modelo.Usuario;
import musicstore.modelo.Venta;
import musicstore.persistencia.Data;
import musicstore.servicio.ReporteServicio;

public class FrmReporte extends javax.swing.JFrame {

    private Data data;
    private ReporteServicio reporteServicio;
    
    public FrmReporte(Data data){

    initComponents();

    this.data = data;
    this.reporteServicio = new ReporteServicio(data);

    setLocationRelativeTo(null);

    cargarUsuarios();
    cargarStock();
    cargarVentasUsuario();

}
    
    private void cargarUsuarios(){

    cmbUsuarios.removeAllItems();

    for(Usuario usuario : data.getUsuarios()){

        cmbUsuarios.addItem(usuario);

    }
}
    
    private void cargarStock() {

    DefaultTableModel modelo =
            (DefaultTableModel) tblStock.getModel();

    modelo.setRowCount(0);

    for (Producto producto : data.getProductos()) {

        modelo.addRow(new Object[]{
            producto.getNombre(),
            producto.getStock(),
            producto.getCategoria().getNombre(),
            producto.getProveedor().getNombre()
        });

    }
}
    
    private void cargarVentasUsuario() {

    DefaultTableModel modelo =
            (DefaultTableModel) tblVentas.getModel();

    modelo.setRowCount(0);

    Usuario usuarioSeleccionado =
            (Usuario) cmbUsuarios.getSelectedItem();

    if (usuarioSeleccionado == null) {
        return;
    }

    for (Venta venta : reporteServicio.obtenerVentasPorUsuario(usuarioSeleccionado)) {

        modelo.addRow(new Object[]{
            venta.getNumero(),
            venta.getCliente().getNombre() + " " + venta.getCliente().getApellido(),
            venta.getFecha(),
            venta.getTotal()
        });

    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblReporte = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        cmbUsuarios = new javax.swing.JComboBox();
        lblTituloDos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        lblStock = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblReporte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblReporte.setText("Reporte");

        lblUsuario.setText("Usuario:");

        cmbUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuariosActionPerformed(evt);
            }
        });

        lblTituloDos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTituloDos.setText("Ventas Realizadas:");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Stock", "Categoria", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStock);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Cliente", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVentas);

        lblStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStock.setText("Control de Stock:");

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
                        .addGap(317, 317, 317)
                        .addComponent(lblReporte))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTituloDos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addGap(74, 74, 74)
                                .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStock)
                                .addGap(88, 88, 88))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblReporte)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(lblTituloDos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(lblStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuariosActionPerformed

  cargarVentasUsuario();
    }//GEN-LAST:event_cmbUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cmbUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblReporte;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTituloDos;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblStock;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
