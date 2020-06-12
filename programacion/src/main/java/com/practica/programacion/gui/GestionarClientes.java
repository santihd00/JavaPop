/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.programacion.gui;

import com.practica.programacion.Tienda;
import java.awt.event.ActionEvent;

/**
 *
 * @author Santiago Hernández
 */
public class GestionarClientes extends ListaElementosSwing {

    /**
     * Creates new form ProductosPropios
     */
    public GestionarClientes() {
        super(new ListaClientes((Tienda.tienda.getClientes())));
        init();
        setTitle("Lista de clientes");
    }

    public void init() {
        button1.setText("Eliminar");
        button2.setVisible(false);
    }

    @Override
    protected void button1(ActionEvent evt) {
        int row = tElementos.getSelectedRow();
        if (row >= 0) {
            modelo.removeRow(row);
            modelo.fireTableStructureChanged();
        }
    }

    @Override
    protected void button2(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
