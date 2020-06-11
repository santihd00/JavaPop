/** *****************************************************************************
 * 2020, All rights reserved.
 ****************************************************************************** */
package com.practica.programacion;

import com.practica.programacion.gui.Principal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    protected class CriterioProximidad implements Comparator<Producto> {

        String ubicacion;

        public CriterioProximidad(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        public int compare(Producto a, Producto b) {

            return a.getDistancia(ubicacion) - b.getDistancia(ubicacion);
        }
    }
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
    public Usuario UsuarioLogueado;
    public static Tienda tienda = new Tienda();
    public Administrador admin;
    private Principal ventanaPrincipal;
 public Principal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(Principal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    /**
     * The constructor.
     */
    public Tienda() {
        // Start of user code constructor for Tienda)
        super();
        // End of user code
        admin = new Administrador("admin@javapop.com", "admin");
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
            Iterator<Producto> iPro = lista.iterator();
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
public ArrayList<Producto> getProductosAsList(){
    ArrayList<Producto> resultado=new ArrayList<>();
    
    while{
   return new ArrayList<Producto> (productos.values());
}
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
}
