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
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Santiago Hernández
 */
public class ConfirmarProductos extends ListaElementosSwing {

    /**
     * Creates new form ProductosPropios
     */
    public ConfirmarProductos() {
        super(new ListaNotificaciones(((Cliente) Tienda.tienda.getUsuarioLogueado()).getNotificaciones()));

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
        ((Cliente) Tienda.tienda.getUsuarioLogueado()).generarVenta((Notificacion) modelo.getElemento(row));
        Notificacion notificacion = (Notificacion) modelo.getElemento(row);
        Iterator<Notificacion> iListNotif = modelo.elementos.iterator();
       ArrayList<Notificacion> notifs= new ArrayList();
        while (iListNotif.hasNext()) {
            Notificacion notif = iListNotif.next();
            if (!notificacion.getProdComprado().equals(notificacion.getProdComprado())) {
                notifs.add(notif);

            }
        }
 modelo.elementos=notifs;
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
