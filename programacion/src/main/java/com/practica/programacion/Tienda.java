/** *****************************************************************************
 * 2020, All rights reserved.
 ****************************************************************************** */
package com.practica.programacion;

import com.practica.programacion.gui.Principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
// Start of user code (user defined imports)

// End of user code
/**
 * Description of Tienda.
 *
 * @author Santiago Hernández
 */
public class Tienda implements Serializable {

    private static final long serialVersionUID = 60L;

    public static DateFormat sdfDD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * The constructor.
     */
    public Tienda() {
        // Start of user code constructor for Tienda)
        super();
        // End of user code
        admin = new Administrador("admin@javapop.com", "admin");
    }

    public Usuario UsuarioLogueado;
    public static Tienda tienda = new Tienda();
    public Administrador admin;
    private transient Principal ventanaPrincipal;//Ventana principal de la aplicacion
    /**
     * Description of the property clientes.
     */

    protected ArrayList<Cliente> clientes = new ArrayList<>();
    /**
     * Description of the property productos.
     */
    protected HashMap<Producto.TipoProducto, ArrayList<Producto>> productos = new HashMap<>();

    public Usuario getUsuarioLogueado() {
        return UsuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario UsuarioLogueado) {
        this.UsuarioLogueado = UsuarioLogueado;
    }

    public Principal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(Principal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    // Start of user code (user defined methods for Tienda)
    // End of user code
    /**
     * Returns clientes.
     *
     * @return clientes
     */
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Returns productos.
     *
     * @return productos
     */
    public HashMap<Producto.TipoProducto, ArrayList<Producto>> getProductos() {
        return this.productos;
    }

    /**
     * Método que servía para que en el código se viera lo que estaba haciendo
     */
    public String toString() {
        String txt = "Tienda:{\n";
        txt = txt + "Clientes:\n";
        Iterator<Cliente> iCli = clientes.iterator();
        while (iCli.hasNext()) {
            txt = txt + iCli.next().toString();
            txt = txt + "}\n";
        }
        return txt;
    }

    /**
     * Esta es una clase para comparar productos por proximidad
     */
    protected class CriterioProximidad implements Comparator<Producto> {

        String ubicacion;

        public CriterioProximidad(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        @Override
        public int compare(Producto a, Producto b) {

            return a.getDistancia(ubicacion) - b.getDistancia(ubicacion);
        }
    }

    protected class CriterioAntiguedadVentas implements Comparator<Venta> {

        @Override
        public int compare(Venta a, Venta b) {

            return a.getFechaCompra().compareTo(b.getFechaCompra());
        }
    }

    /**
     * Método general para la búsqueda de objetos
     *
     * @param categoria
     * @param palabrasClave
     * @param ubicacion
     * @return
     */
    public ArrayList<Producto> buscarProductos(Producto.TipoProducto categoria, ArrayList<String> palabrasClave, String ubicacion) {
        ArrayList<Producto> resultado = new ArrayList<>();
        ArrayList<Producto> listaOriginal = productos.get(categoria);

        if (listaOriginal != null) {
            Iterator<Producto> iListOri = listaOriginal.iterator();
            ArrayList<Producto> lista = new ArrayList<>();
            while (iListOri.hasNext()) {
                Producto prod = iListOri.next();
                if (!prod.isVendido()) {

                    lista.add(prod);

                }
            }
            if (palabrasClave == null || palabrasClave.isEmpty()) {
                return lista;
            }
            Iterator<Producto> iPro = lista.iterator();//iterador que recorre la lista de productos
            while (iPro.hasNext()) {
                Producto p = iPro.next();
                String descripcion = p.getDescripcion().toUpperCase();
                Iterator<String> iStr = palabrasClave.iterator();
                boolean seleccionado = true;
                while (iStr.hasNext()) {
                    seleccionado = seleccionado && descripcion.contains(iStr.next().toUpperCase());
                }
                if (seleccionado) {
                    resultado.add(p);
                }
            }
        }

        Collections.sort(resultado, new CriterioProximidad(ubicacion));
        return resultado;
    }

    /**
     * ordena todas las ventas realizadas y devuelve las que se realizaron después de una fecha
     *
     * @param fechaParaComparar
     * @return
     */
    public ArrayList<Venta> getVentas(Date fechaParaComparar) {
        ArrayList<Venta> resultadoInicial = new ArrayList<>();
        Iterator<Cliente> iListClientes = getClientes().iterator();
        while (iListClientes.hasNext()) {
            Cliente cliente = iListClientes.next();
            resultadoInicial.addAll(cliente.getVentas());
        }
        Collections.sort(resultadoInicial, new CriterioAntiguedadVentas());
        ArrayList<Venta> resultadoFinal = new ArrayList<>();
        Iterator<Venta> iListVentas = resultadoInicial.iterator();
        while (iListVentas.hasNext()){
            Venta venta = iListVentas.next();
            if (venta.getFechaCompra().compareTo(fechaParaComparar)>0){
                resultadoFinal.add(venta);
            }
        }
        return resultadoFinal;
    }

    /**
     * devuelve todos los productos de la tienda en una sola lista
     *
     * @return
     */
    public ArrayList<Producto> getProductosAsList() {
        ArrayList<Producto> resultado = new ArrayList<>();
        Iterator<ArrayList<Producto>> iListPro = getProductos().values().iterator();
        while (iListPro.hasNext()) {
            ArrayList<Producto> lProductos = iListPro.next();

            resultado.addAll(lProductos);
        }
        return resultado;
    }

    /**
     * añade un producto al hashmap de productos de la tienda
     *
     * @param producto
     */
    //TODO: Comentar. Antes estaba dentro del método añadirProducto(Producto producto) de Cliente
    public void añadirProducto(Producto producto) {
        ArrayList<Producto> productos = getProductos().get(producto.getCategoria());
        if (productos == null) {
            productos = new ArrayList<>();
            Tienda.tienda.getProductos().put(producto.getCategoria(), productos);
        }
        productos.add(producto);
    }

    /**
     * elimina un producto al hashmap de productos de la tienda
     *
     * @param producto
     */
    public void eliminarProducto(Producto producto) {
        ArrayList<Producto> productos = getProductos().get(producto.getCategoria());
        productos.remove(producto);
    }

    /**
     * Método para verificar si el usuario ya existe en la tienda o no
     *
     * @param correo
     * @param clave
     * @return
     */
    public Usuario verificarUsuario(String correo, String clave) {
        if (correo.equalsIgnoreCase(admin.getCorreo())) {
            //el logado es el administrador
            return admin;
        } else {
            //el logado es un cliente o no existe
            Iterator<Cliente> iListCli = getClientes().iterator();
            while (iListCli.hasNext()) {
                Cliente cliente = iListCli.next();
                if (correo.equalsIgnoreCase(cliente.getCorreo())) {
                    if (clave.equals(cliente.getClave())) {
                        return cliente;
                    }
                }

            }

        }
        return null;
    }

    public static void cargarTienda() {

        try {
            FileInputStream fi = new FileInputStream(new File("Javapop.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Tienda.tienda = (Tienda) oi.readObject();

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
    }
    public static void guardarTienda(){
    try {
            File fichero = new File("Javapop.dat");
            System.out.println(fichero.getAbsolutePath());
            FileOutputStream f = new FileOutputStream(fichero);
            ObjectOutputStream os = new ObjectOutputStream(f);
            os.writeObject(Tienda.tienda);
            os.close();
            f.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
    }
}
//TODO: Terminar los comentarios
