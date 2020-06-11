package com.practica.programacion.gui;

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
public class ListaProductosPropios extends ListaElementos {

//Definir un array de strings en linea
    public ListaProductosPropios(ArrayList<Producto> productos) {
        super(new String[]{"Título", "Descripción", "Categoría", "Estado", "Precio", "Fecha publicación"}, (ArrayList) productos);
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
                clase = TipoProducto.class;
                break;
            case 3:
                clase = EstadoProducto.class;
                break;
            case 4:
                clase = Double.class;
                break;
            case 5:
                clase = Date.class;
                break;
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return clase;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Buscamos el Producto correspondiente a la línea solicitada
        Object o = null;
        Producto p = (Producto) elementos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = p.getTitulo();
                break;
            case 1:
                o = p.getDescripcion();
                break;
            case 2:
                o = p.getCategoria();
                break;
            case 3:
                o = p.getEstado();
                break;
            case 4:
                o = p.getPrecio();
                break;
            case 5:
                o = p.getFechaPublicacion();
                break;
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return o;
    }

}
