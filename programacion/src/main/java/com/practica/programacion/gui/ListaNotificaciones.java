package com.practica.programacion.gui;


import com.practica.programacion.Notificacion;
import java.util.ArrayList;

/**
 *
 * @author Santiago Hernández
 */
public class ListaNotificaciones extends ListaElementos {

//Definir un array de strings en linea
    public ListaNotificaciones(ArrayList<Notificacion> notificaciones) {
        super(new String[]{"Nombre cliente", "Titulo producto"}, (ArrayList) notificaciones);
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
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return clase;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Buscamos el Producto correspondiente a la línea solicitada
        Object o = null;
        Notificacion n = (Notificacion) elementos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = n.getComprador().getNombre();
                break;
            case 1:
                 o = n.getProdComprado().getTitulo();
                break;

            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return o;
    }
//TODO: devolver clases

}
