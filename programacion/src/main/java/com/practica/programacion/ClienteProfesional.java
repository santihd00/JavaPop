/** *****************************************************************************
 * 2020, All rights reserved.
 ****************************************************************************** */
package com.practica.programacion;

import java.io.Serializable;
// Start of user code (user defined imports)

// End of user code
/**
 * Description of ClienteProfesional.
 *
 * @author Santiago Hernández
 */
public class ClienteProfesional extends Cliente implements Serializable {

    private static final long serialVersionUID = 50L;
    /**
     * Description of the property descripcion.
     */
    public String descripcion = "";

    /**
     * Description of the property Horario de apertura.
     */
    public String horarioApertura = "";

    /**
     * Description of the property telefono.
     */
    public String telefono = "";

    /**
     * Description of the property web.
     */
    public String web = "";

    // Start of user code (user defined attributes for ClienteProfesional)
    // End of user code
    /**
     * The constructor.
     */
    public ClienteProfesional() {
        // Start of user code constructor for ClienteProfesional)
        super();
        // End of user code
    }

    public ClienteProfesional(
            String correo,
            String clave,
            String nombre,
            String DNI,
            String tarjetaDeCredito,
            String ubicacion,
            String descripcion,
            String telefono,
            String horarioApertura,
            String web) {
        super(correo, clave, nombre, DNI, tarjetaDeCredito, ubicacion);
        this.descripcion = descripcion;
        this.horarioApertura = horarioApertura;
        this.telefono = telefono;
        this.web = web;
    }
    // Start of user code (user defined methods for ClienteProfesional)

    // End of user code
    /**
     * Returns Descripcion.
     *
     * @return Descripcion
     */
    /**
     * Returns descripcion.
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Sets a value to attribute descripcion.
     *
     * @param newDescripcion
     */
    public void setDescripcion(String newDescripcion) {
        this.descripcion = newDescripcion;
    }

    /**
     * Returns Horario de apertura.
     *
     * @return Horario de apertura
     */
    public String getHorarioApertura() {
        return this.horarioApertura;
    }

    /**
     * Sets a value to attribute Horario de apertura.
     *
     * @param newHorario de apertura
     */
    public void setHorarioApertura(String newHorario) {
        this.horarioApertura = newHorario;
    }

    /**
     * Returns telefono.
     *
     * @return telefono
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Sets a value to attribute telefono.
     *
     * @param newTelefono
     */
    public void setTelefono(String newTelefono) {
        this.telefono = newTelefono;
    }

    /**
     * Returns web.
     *
     * @return web
     */
    public String getWeb() {
        return this.web;
    }

    /**
     * Sets a value to attribute web.
     *
     * @param newWeb
     */
    public void setWeb(String newWeb) {
        this.web = newWeb;
    }

    public String toString() {
        String txt = "Cliente Profesional:{\n";
        txt = txt + "Descripción: " + getDescripcion() + "\n";
        txt = txt + "Horario de apertura: " + getHorarioApertura() + "\n";
        txt = txt + "Teléfono: " + getTelefono() + "\n";
        txt = txt + "Web: " + getWeb() + "\n";
        txt = txt + super.toString();
        txt = txt + "}\n";
        return txt;
    }

}
