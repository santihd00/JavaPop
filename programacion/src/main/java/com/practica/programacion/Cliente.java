/** *****************************************************************************
 * 2020, All rights reserved.
 ****************************************************************************** */
package com.practica.programacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
// Start of user code (user defined imports)

// End of user code
/**
 * Description of Cliente.
 *
 * @author Santiago Hernández
 */
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 20L;
    /**
     * Description of the property tarjetaDeCredito.
     */
    protected String tarjetaDeCredito = "";

    /**
     * Description of the property nombre.
     */
    protected String nombre = "";

    /**
     * Description of the property ubicacion.
     */
    protected String ubicacion = "";

    /**
     * Description of the property productos.
     */
    protected ArrayList<Notificacion> notificaciones = new ArrayList<>();//ArrayList de todas las notificaciones de venta de un cliente
    protected ArrayList<Venta> ventas = new ArrayList<>();//ArrayList de todas las ventas de un cliente
    protected ArrayList<Producto> misProductos = new ArrayList<>();//ArrayList de todos los productos de un cliente
    /**
     * Description of the property DNI.
     */
    protected String DNI = "";

    // Start of user code (user defined attributes for Cliente)
    // End of user code
    /**
     * The constructor.
     */
    public Cliente() {
        // Start of user code constructor for Cliente)
        super();
        // End of user code
    }

    public Cliente(
            String correo,
            String clave,
            String nombre,
            String DNI,
            String tarjetaDeCredito,
            String ubicacion) {
        super(correo, clave);
        this.nombre = nombre;
        this.DNI = DNI;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.ubicacion = ubicacion;
    }
    // Start of user code (user defined methods for Cliente)

    // End of user code
    /**
     * Returns TarjetaDeCredito.
     *
     * @return TarjetaDeCredito
     */
    /**
     * Returns tarjetaDeCredito.
     *
     * @return tarjetaDeCredito
     */
    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public String getTarjetaDeCredito() {
        return this.tarjetaDeCredito;
    }

    /**
     * Sets a value to attribute tarjetaDeCredito.
     *
     * @param newTarjetaDeCredito
     */
    public void setTarjetaDeCredito(String newTarjetaDeCredito) {
        this.tarjetaDeCredito = newTarjetaDeCredito;
    }

    /**
     * Returns nombre.
     *
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sets a value to attribute nombre.
     *
     * @param newNombre
     */
    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    /**
     * Returns ubicacion.
     *
     * @return ubicacion
     */
    public String getUbicacion() {
        return this.ubicacion;
    }

    /**
     * Sets a value to attribute ubicacion.
     *
     * @param newUbicacion
     */
    public void setUbicacion(String newUbicacion) {
        this.ubicacion = newUbicacion;
    }

    /**
     * Returns DNI.
     *
     * @return DNI
     */
    public String getDNI() {
        return this.DNI;
    }

    /**
     * Sets a value to attribute DNI.
     *
     * @param newDNI
     */
    public void setDNI(String newDNI) {
        this.DNI = newDNI;
    }

    public ArrayList<Producto> getMisProductos() {
        return misProductos;
    }

    public void setMisProductos(ArrayList<Producto> misProductos) {
        this.misProductos = misProductos;
    }

    /**
     * Método que servía para que en el código se viera lo que estaba haciendo
     */
    @Override
    public String toString() {
        String txt = "Cliente:{\n";
        txt = txt + "Nombre:" + getNombre() + "\n";
        txt = txt + "DNI:" + getDNI() + "\n";
        Iterator<Producto> iProd = misProductos.iterator();
        while (iProd.hasNext()) {
            txt = txt + iProd.next().toString();
            txt = txt + "\n";
        }
        txt = txt + "}\n";
        return txt;
    }

    /**
     * Método para que un cliente añada productos a su lista
     *
     * @param producto
     */
    public void añadirProducto(Producto producto) {
        misProductos.add(producto);//añade un producto vacío a la lista de misProductos
        producto.setVendedor(this);//Al producto vacío le añade el dueño de este 
        ArrayList<Producto> productos = Tienda.tienda.getProductos().get(producto.getCategoria());
        if (productos == null) {
            productos = new ArrayList<>();
            Tienda.tienda.getProductos().put(producto.getCategoria(), productos);
        }
        productos.add(producto);
    }

    /**
     * Método que sirve para notificar al vendedor que le quieren comprar un
     * producto
     *
     * @param comprador
     * @param objComprado
     */
    public void notificar(Cliente comprador, Producto objComprado) {
        Notificacion solicitud = new Notificacion(comprador, objComprado);
        notificaciones.add(solicitud);
    }

    /**
     * Método que sirve para generar la venta del producto
     *
     * @param solicitud
     * @return
     */
    public Venta generarVenta(Notificacion solicitud) {
        Producto vendido = solicitud.getProdComprado();
        Venta venta = new Venta(vendido, solicitud.getComprador());
        ventas.add(venta);
        return venta;
    }

    public void eliminarProducto(Producto prodCom) {
       getMisProductos().remove(prodCom);
    }

}
