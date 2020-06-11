package com.practica.programacion.gui;

import com.practica.programacion.Cliente;
import com.practica.programacion.Producto;
import com.practica.programacion.Producto.EstadoProducto;
import com.practica.programacion.Producto.TipoProducto;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Santiago Hernández
 */
public class ListaClientes extends ListaElementos {

//Definir un array de strings en linea
    public ListaClientes(ArrayList<Cliente> clientes) {
        super(new String[]{"Nombre", "DNI", "Tarjeta de crédito", "Ubicación"}, (ArrayList) clientes);
    }
    //TODO: Cambiar columnas de clientes 

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
                clase = String.class;
                break;

            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return clase;
    }
//TODO: devolver clases

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Buscamos el Producto correspondiente a la línea solicitada
        Object o = null;
        Cliente p = (Cliente) elementos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = p.getNombre();
                break;
            case 1:
                o = p.getDNI();
                break;
            case 2:
                o = p.getTarjetaDeCredito();
                break;
            case 3:
                o = p.getUbicacion();
                break;
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return o;
    }
//TODO: devolver clases

}
