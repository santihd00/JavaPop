/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.programacion.gui;

import com.practica.programacion.Cliente;
import com.practica.programacion.Notificacion;
import com.practica.programacion.Tienda;
import java.awt.event.ActionEvent;

/**
 *
 * @author Santiago Hernández
 */
public class ConfirmarProductos extends ListaElementosSwing {

    /**
     * Creates new form ProductosPropios
     */
    public ConfirmarProductos() {
        super(new ListaProductos(((Cliente) Tienda.tienda.getUsuarioLogueado()).getMisProductos()));
        init();
        setTitle("Lista de productos por confirmar");
    }

    public void init() {
        button1.setText("Confirmar");
        button2.setText("Rechazar");
    }

    @Override
    protected void button1(ActionEvent evt) {
        int row = tElementos.getSelectedRow();
((Cliente)Tienda.tienda.getUsuarioLogueado()).generarVenta((Notificacion) modelo.getElemento(row));

    }

    @Override
    protected void button2(ActionEvent evt) {
        int row = tElementos.getSelectedRow();
        if (row >= 0) {
            modelo.removeRow(row);
            modelo.fireTableStructureChanged();
        }
    }

}
