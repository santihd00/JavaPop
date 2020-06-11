package com.practica.programacion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Santiago Hernández
 */
public class Venta implements Serializable {

    private static final long serialVersionUID = 80L;
    protected Producto producto;
    protected Cliente comprador;
    protected Cliente vendedor;
    protected Date fechaCompra;
    /**
     * Método para generar la venta con la fecha del dia que se produce
     * @param producto
     * @param comprador
     */
    public Venta(Producto producto, Cliente comprador) {
        this.producto = producto;
        this.comprador = comprador;
        vendedor = producto.getVendedor();
        fechaCompra = new Date();
        producto.setVendido(true);
    }

    @Override
    public String toString() {
        String txt = "Venta:{n";
        txt = txt + producto.toString() + "\n";
        txt = txt + "Fecha de venta: " + fechaCompra.toString() + "n";
        txt = txt + "Datos comprador:n";
        txt = txt + "- DNI:" + comprador.getDNI() + "\n";
        txt = txt + "- Nombre: " + comprador.getNombre() + "\n";
        txt = txt + "Datos vendedor:n";
        txt = txt + "- DNI:" + vendedor.getDNI() + "\n";
        txt = txt + "- Nombre: " + vendedor.getNombre() + "\n";
        txt = txt + "}\n";
        return txt;

    }
    /**
     * Método para generar el fichero de venta
     * @return 
     */
    public String generarFichero() {
        String nombre = "VENTA_" + fechaCompra.getTime() + ".txt";
        File f = new File(nombre);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(f);
            pw = new PrintWriter(fichero);

            pw.println(toString());

        } catch (IOException e) {
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
        return f.getAbsolutePath();
    }
}
