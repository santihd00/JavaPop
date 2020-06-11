/** *****************************************************************************
 * 2020, All rights reserved.
 ****************************************************************************** */
package com.practica.programacion;

import java.io.Serializable;
import java.util.Date;

// Start of user code (user defined imports)
// End of user code
/**
 * Description of Producto.
 *
 * @author Santiago Hernández
 */
public class Producto implements Serializable {

    private static final long serialVersionUID = 40L;
//enumerable de las diferentes categorías que puede tener un producto

    public enum TipoProducto {
        MODA_ACCESORIOS("Moda y accesorios"),
        TV_AUDIO_FOTO("TV, audio y fotografía"),
        MOVILES("Móviles"),
        INFORMATICA_ELECTRONICA("Informática y electrónica"),
        CONSOLAS_VIDEOJUEGOS("Consolas y videojuegos"),
        DEPORTE_OCIO("Deporte y ocio");
        String nombre;

        TipoProducto(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }

    }
//enumerado de los diferentes estados en los que puede estar un producto

    public enum EstadoProducto {
        NUEVO("Nuevo"),
        COMO_NUEVO("Como nuevo"),
        BUENO("Bueno"),
        ACEPTABLE("Aceptable"),
        REGULAR("Regular");
        String nombre;

        EstadoProducto(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
    /**
     * Description of the property clientes.
     */
    protected Cliente vendedor = null;
    protected String titulo = "";
    protected String descripcion = "";
    protected TipoProducto categoria = null;
    protected EstadoProducto estado = null;
    protected boolean vendido = false;//variable para saber si el producto está ya vendido o no
    protected Double precio = 0.0;
    protected String foto = "";
    protected Date fechaPublicacion = null;
    protected String ubicacion = "";

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    /**
     * The constructor.
     */
    public Producto() {
        // Start of user code constructor for Producto)
        super();
        // End of user code
    }

    public Producto(String titulo, String descripcion, TipoProducto categoria, EstadoProducto estado, double precio, String foto, String ubicacion) {
        this();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
        this.foto = foto;
        this.fechaPublicacion = new Date();
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Returns clientes.
     *
     * @return clientes
     */
    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Returns Titulo.
     *
     * @return Titulo
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Sets a value to attribute Titulo.
     *
     * @param newTitulo
     */
    public void setTitulo(String newTitulo) {
        this.titulo = newTitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoProducto categoria) {
        this.categoria = categoria;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String txt = "Producto:{\n";
        txt = txt + "Título: " + getTitulo() + "\n";
        txt = txt + "Descripción:" + getDescripcion() + "\n";
        txt = txt + "Categoría: " + getCategoria() + "\n";
        txt = txt + "Estado: " + getEstado() + "\n";
        txt = txt + "Precio: " + getPrecio() + "\n";
        txt = txt + "Foto: " + getFoto() + "\n";
        txt = txt + "Fecha de publicación: " + getFechaPublicacion() + "\n";
        txt = txt + "Ubicación: " + getUbicacion() + "\n";
        txt = txt + "}\n";
        return txt;
    }
    /**
     * Método que reserva un producto a un comprador hasta que el vendedor confirme
     * @param comprador
     */
    public void reservar(Cliente comprador) {
        getVendedor().notificar(comprador, this);
    }
    /**
     * Método que compara ubicaciones y da un valor numérico de cercanía siguiendo la siguientes reglas: compara ubicaciones desde el número más significativo hasta que el número es diferente en ambas ubicaciones por lo que a mayor valor numérico más cercanía 
     * @param ubicacion
     * @return 
     */
    public int getDistancia(String ubicacion) {
        for (int i = 0; i < ubicacion.length(); i++) {
            if (this.ubicacion.charAt(i) != ubicacion.charAt(i)) {
                return i;
            }
        }
        return 10;
    }
}
