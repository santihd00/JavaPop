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
public class VentasRealizadas extends ListaElementosSwing{
public VentasRealizadas(){
    super(new ListaVentas(Tienda.tienda.getVentas()) {});
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
  
    }
    
}
