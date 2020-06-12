/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.programacion.gui;

import java.awt.event.ActionEvent;

/**
 *
 * @author Santiago Hernández
 */
public class VentasRealizadas extends ListaElementosSwing{
public VentasRealizadas(){
    init();
    button2.setVisible(false);
    setTitle("Ventas realizadas");
    
}
@Override
 public void init() {
        button1.setText("Buscar");
    }
    @Override
    protected void button2(ActionEvent evt) {
       
    }

    @Override
    protected void button1(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
