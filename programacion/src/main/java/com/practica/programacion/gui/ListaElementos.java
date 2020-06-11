package com.practica.programacion.gui;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Santiago Hernández
 */
public abstract class ListaElementos extends AbstractTableModel {//Esta es la clase de java básica para  productos propios, productos por confirmar y gestión tanto de usuarios como productos

    String[] columnas;
    ArrayList elementos;
    /**
     * Método que sirve para obtener una lista de elementos(dependiendo de la clase que extienda de esta será de productos o usuarios)
     * @param columnas
     * @param elementos
     */
    public ListaElementos(String[] columnas, ArrayList elementos) {
        this.elementos = elementos;
        this.columnas = columnas;
    }
public Object getElemento(int row){
    return  elementos.get(row);
}
    @Override
    public int getRowCount() {
        if (elementos == null) {
            return 0;
        }

        return elementos.size();
    }

    @Override
    public int getColumnCount() {
        if (elementos == null) {
            return 0;
        }

        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
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
        elementos.remove(row);
        fireTableRowsDeleted(row, row);
    }

}
