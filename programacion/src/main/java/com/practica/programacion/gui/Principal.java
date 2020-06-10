package com.practica.programacion.gui;

import com.practica.programacion.Cliente;
import com.practica.programacion.ClienteProfesional;
import com.practica.programacion.Tienda;
import com.practica.programacion.Usuario;

/**
 *
 * @author Santiago Hernández
 */
public class Principal extends javax.swing.JFrame {

    public InicioSesion inicses;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();          
        mAdministracion.setVisible(false);
            mFile.setVisible(true);
            mCompra.setVisible(false);
            mVenta.setVisible(false);
            mPerfil.setVisible(false);
        
        inicses = new InicioSesion();
        this.add(inicses);
        inicses.setVisible(true);
        Tienda.tienda.setVentanaPrincipal(this);

    }
public void RegistrarUsuario(){
    Registrarse registro=new Registrarse();
    this.add(registro);
        registro.setVisible(true);
}

   public void inicioSesion(){
        inicses.setVisible(true);
    }

    public void usuarioLogueado() {
        Usuario usuario = Tienda.tienda.getUsuarioLogueado();
        if (usuario instanceof ClienteProfesional) {
            mAdministracion.setVisible(false);
            mFile.setVisible(true);
            mCompra.setVisible(true);
            mVenta.setVisible(true);
            mPerfil.setVisible(true);
        } else if (usuario instanceof Cliente) {
            mAdministracion.setVisible(false);
            mFile.setVisible(true);
            mCompra.setVisible(true);
            mVenta.setVisible(true);
            mPerfil.setVisible(true);
        } else {
            mAdministracion.setVisible(true);
            mFile.setVisible(true);
            mCompra.setVisible(false);
            mVenta.setVisible(false);
            mPerfil.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        miCerrarSesion = new javax.swing.JMenuItem();
        mCompra = new javax.swing.JMenu();
        miBuscarProducto = new javax.swing.JMenuItem();
        miProductosComprados = new javax.swing.JMenuItem();
        mVenta = new javax.swing.JMenu();
        miPorConfirmar = new javax.swing.JMenuItem();
        miProductosPropios = new javax.swing.JMenuItem();
        mPerfil = new javax.swing.JMenu();
        miPerfil = new javax.swing.JMenuItem();
        mAdministracion = new javax.swing.JMenu();
        miGestionUsuarios = new javax.swing.JMenuItem();
        miGestionProductos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mFile.setText("File");

        miCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        miCerrarSesion.setText("Cerrar Sesión");
        miCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarSesionActionPerformed(evt);
            }
        });
        mFile.add(miCerrarSesion);

        jMenuBar1.add(mFile);

        mCompra.setText("Compra");

        miBuscarProducto.setText("Buscar producto");
        miBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarProductoActionPerformed(evt);
            }
        });
        mCompra.add(miBuscarProducto);

        miProductosComprados.setText("Productos comprados");
        miProductosComprados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProductosCompradosActionPerformed(evt);
            }
        });
        mCompra.add(miProductosComprados);

        jMenuBar1.add(mCompra);

        mVenta.setText("Venta");

        miPorConfirmar.setText("Productos por confirmar");
        miPorConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPorConfirmarActionPerformed(evt);
            }
        });
        mVenta.add(miPorConfirmar);

        miProductosPropios.setText("Productos propios");
        miProductosPropios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProductosPropiosActionPerformed(evt);
            }
        });
        mVenta.add(miProductosPropios);

        jMenuBar1.add(mVenta);

        mPerfil.setText("Perfil");

        miPerfil.setText("Perfil");
        miPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPerfilActionPerformed(evt);
            }
        });
        mPerfil.add(miPerfil);

        jMenuBar1.add(mPerfil);

        mAdministracion.setText("Administración");

        miGestionUsuarios.setText("Gestión de usuarios");
        miGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGestionUsuariosActionPerformed(evt);
            }
        });
        mAdministracion.add(miGestionUsuarios);

        miGestionProductos.setText("Gestión de productos");
        mAdministracion.add(miGestionProductos);

        jMenuBar1.add(mAdministracion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miCerrarSesionActionPerformed

    private void miPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPerfilActionPerformed
Registrarse registro= new Registrarse((Cliente) Tienda.tienda.getUsuarioLogueado());
this.add(registro);
registro.setVisible(true);
    }//GEN-LAST:event_miPerfilActionPerformed

    private void miProductosPropiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProductosPropiosActionPerformed
        ProductosPropios productosPropios = new ProductosPropios();
        this.add(productosPropios);
        productosPropios.setVisible(true);
    }//GEN-LAST:event_miProductosPropiosActionPerformed

    private void miBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarProductoActionPerformed
        ComprarProductos comprarProductos = new ComprarProductos();
        this.add(comprarProductos);
        comprarProductos.setVisible(true);

    }//GEN-LAST:event_miBuscarProductoActionPerformed

    private void miPorConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPorConfirmarActionPerformed
        ConfirmarProductos confirmarProductos = new ConfirmarProductos();
        this.add(confirmarProductos);
        confirmarProductos.setVisible(true);
    }//GEN-LAST:event_miPorConfirmarActionPerformed

    private void miProductosCompradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProductosCompradosActionPerformed
        ProductosComprados productosComprados = new ProductosComprados();
        this.add(productosComprados);
        productosComprados.setVisible(true);
    }//GEN-LAST:event_miProductosCompradosActionPerformed

    private void miGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGestionUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miGestionUsuariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAdministracion;
    private javax.swing.JMenu mCompra;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenu mPerfil;
    private javax.swing.JMenu mVenta;
    private javax.swing.JMenuItem miBuscarProducto;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miGestionProductos;
    private javax.swing.JMenuItem miGestionUsuarios;
    private javax.swing.JMenuItem miPerfil;
    private javax.swing.JMenuItem miPorConfirmar;
    private javax.swing.JMenuItem miProductosComprados;
    private javax.swing.JMenuItem miProductosPropios;
    // End of variables declaration//GEN-END:variables
}