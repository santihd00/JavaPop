/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.programacion.gui;

import com.practica.programacion.Tienda;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Hernández
 */
public class VentasRealizadas extends ListaElementosSwing {

    public VentasRealizadas() {
        super(new ListaVentas(Tienda.tienda.getVentas(new Date(0L))));
        init();
        button2.setVisible(false);
        setTitle("Ventas realizadas");

    }

    @Override
    public void init() {
        button1.setText("Buscar");
        ftfFechaDesde.setVisible(true);
        lFechaInicial.setVisible(true);
    }

    @Override
    protected void button2(ActionEvent evt) {

    }

    @Override
    protected void button1(ActionEvent evt) {
        Date fechaParaComparar;
        try {
            fechaParaComparar = Tienda.sdfDD_MM_YYYY.parse(ftfFechaDesde.getText());
            ListaVentas listaVentas = new ListaVentas(Tienda.tienda.getVentas(fechaParaComparar));
            tElementos.setModel(listaVentas);
        } catch (ParseException ex) {
            Logger.getLogger(VentasRealizadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
