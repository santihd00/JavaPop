package com.practica.programacion;

import java.io.Serializable;

/**
 *
 * @author Santiago Hernández
 */
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 70L;
    protected Cliente comprador = null;//variable nula ya que al principio no existe comprador
    protected Producto prodComprado = null;//variable nula ya que al principio no existe producto solicitado para comprar
    /**
     * Método para crear la notificación de compra
     */
    public Notificacion(Cliente comprador, Producto prodComprado) {
        this.comprador = comprador;
        this.prodComprado = prodComprado;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Producto getProdComprado() {
        return prodComprado;
    }

    public void setProdComprado(Producto prodComprado) {
        this.prodComprado = prodComprado;
    }

    @Override
    public String toString() {
        String txt = "Solicitud de compra:{\n";
        txt = txt + "Comprador:" + getComprador().getNombre() + "\n";
        txt = txt + "Producto comprado:" + getProdComprado().getTitulo() + "\n";
        txt = txt + "}\n";
        return txt;
    }
}
