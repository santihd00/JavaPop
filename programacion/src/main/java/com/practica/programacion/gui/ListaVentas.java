package com.practica.programacion.gui;

import com.practica.programacion.Producto;
import com.practica.programacion.Producto.EstadoProducto;
import com.practica.programacion.Producto.TipoProducto;
import com.practica.programacion.Venta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Santiago Hernández
 */
public class ListaVentas extends ListaElementos {

//Definir un array de strings en linea
    public ListaVentas(ArrayList<Venta> ventas) {
        super(new String[]{"Comprador","Vendedor","Producto vendido","Fecha de la venta"}, ventas);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clase = null;
        switch (columnIndex) {
            case 0:
                clase = String.class;
                break;
            case 1:
                clase = String.class;
                break;
            case 2:
                clase = String.class;
                break;
            case 3:
                clase = Date.class;
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return clase;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Buscamos el Producto correspondiente a la línea solicitada
        Object o = null;
        Venta v = (Venta) elementos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = v.getComprador();
                break;
            case 1:
                o = v.getVendedor();
                break;
            case 2:
                o = v.getProducto();
                break;
            case 3:
                o = v.getFechaCompra();
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return o;
    }

}
