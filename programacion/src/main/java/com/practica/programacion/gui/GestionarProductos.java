/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.programacion.gui;

import com.practica.programacion.Producto;
import com.practica.programacion.Tienda;
import java.awt.event.ActionEvent;

/**
 *
 * @author Santiago Hernández
 */
public class GestionarProductos extends ListaElementosSwing {

    /**
     * Creates new form ProductosPropios
     */
    public GestionarProductos() {
        super(new ListaProductos(Tienda.tienda.getProductosAsList()));
        init();
        setTitle("Gestionar productos");
        button2.setVisible(false);
    }

    public void init() {
        button1.setText("Eliminar");
    }

    @Override
    protected void button1(ActionEvent evt) {
        int row = tElementos.getSelectedRow();
        if (row >= 0) {
            Producto prodCom= (Producto)modelo.getElemento(row);
            prodCom.getVendedor().eliminarProducto(prodCom);
            modelo.removeRow(row);
            modelo.fireTableStructureChanged();
        }
    }

    @Override
    protected void button2(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
