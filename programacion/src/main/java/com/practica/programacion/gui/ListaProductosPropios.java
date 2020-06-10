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
public class ListaProductosPropios extends AbstractTableModel {

    String[] columnas = {"Título", "Descripción", "Categoría", "Estado", "Precio", "Fecha publicación"};
    ArrayList<Producto> productos;

    public ListaProductosPropios(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int getRowCount() {
        if (productos == null) {
            return 0;
        }

        return productos.size();
    }

    @Override
    public int getColumnCount() {
        if (productos == null) {
            return 0;
        }

        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Buscamos el Producto correspondiente a la línea solicitada
        Object o = null;
        Producto p = productos.get(rowIndex);
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

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    void removeRow(int row) {
       productos.remove(row);
       fireTableRowsDeleted(row, row);
    }

}
